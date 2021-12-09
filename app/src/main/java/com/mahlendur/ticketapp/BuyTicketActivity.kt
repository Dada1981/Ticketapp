package com.mahlendur.ticketapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import kotlinx.android.synthetic.main.activity_buy_ticket.*
import java.time.OffsetDateTime
import java.time.format.DateTimeFormatter

class BuyTicketActivity : AppCompatActivity() {
    private val ticketViewModel: TicketViewModel by viewModels {
        TicketViewModelFactory((application as TicketApplication).repository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_buy_ticket)

        val sharedPreference = SharedPreference(this)
        val alreadyPaid = sharedPreference.getValueInt("alreadyPaid").toDouble()/100
        txtPaid_buy.text = "$alreadyPaid €"

        btn_A.setOnClickListener { onEntry(270, "A") }
        btn_B.setOnClickListener { onEntry(520, "B") }
        btn_C.setOnClickListener { onEntry(990, "C") }
        btn_D.setOnClickListener { onEntry(1520, "D") }
    }

    private fun onEntry(entryVal: Int, lvl: String) {
        val sharedPreference = SharedPreference(this)
        var alreadyPaid = sharedPreference.getValueInt("alreadyPaid")

        if (alreadyPaid >= entryVal) {
            //val toast = Toast.makeText(applicationContext, "Ticket wird generiert, bitte warten!", Toast.LENGTH_LONG)
            //toast.show()
            alreadyPaid -= entryVal
            sharedPreference.save("alreadyPaid", alreadyPaid)
            txtPaid_buy.text = (alreadyPaid.toDouble()/100).toString() + " €"
            val actTime: OffsetDateTime = OffsetDateTime.now()


            ticketViewModel.insert(Ticket(OffsetDateTime.now().toString(), lvl))


            val intent = Intent(this, ShowTicketActivity::class.java)
            intent.putExtra("givenTime", actTime.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME))
            startActivity(intent)
        } else {
            val toast = Toast.makeText(applicationContext, "Nicht genügend Geld eingeworfen!", Toast.LENGTH_LONG)
            toast.show()
        }
    }


}