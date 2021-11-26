package com.mahlendur.ticketapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_buy_ticket.*

class activity_buy_ticket : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_buy_ticket)

        val sharedPreference: SharedPreference = SharedPreference(this)
        var alreadyPaid = sharedPreference.getValueInt("alreadyPaid").toDouble()/100
        txtPaid_buy.text = alreadyPaid.toString() + " €"

        btn_A.setOnClickListener { onEntry(270) }
        btn_B.setOnClickListener { onEntry(520) }
        btn_C.setOnClickListener { onEntry(990) }
        btn_D.setOnClickListener { onEntry(1520) }
    }

    private fun onEntry(entryVal: Int) {
        val sharedPreference: SharedPreference = SharedPreference(this)
        var alreadyPaid = sharedPreference.getValueInt("alreadyPaid")

        if (alreadyPaid >= entryVal) {
            val toast = Toast.makeText(applicationContext, "Ticket wird generiert, bitte warten!", Toast.LENGTH_LONG)
            toast.show()
            alreadyPaid -= entryVal
            sharedPreference.save("alreadyPaid", alreadyPaid)
            txtPaid_buy.text = (alreadyPaid.toDouble()/100).toString() + " €"
        } else {
            val toast = Toast.makeText(applicationContext, "Nicht genügend Geld eingeworfen!", Toast.LENGTH_LONG)
            toast.show()
        }
    }


}