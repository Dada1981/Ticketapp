package com.mahlendur.ticketapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_insert_money.*


class InsertMoneyActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        val sharedPreference = SharedPreference(this)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_insert_money)
        val alreadyPaid = sharedPreference.getValueInt("alreadyPaid").toDouble()/100
        txtPaid.text = "$alreadyPaid €"

        btn1c.setOnClickListener { onEntry(1) }
        btn2c.setOnClickListener { onEntry(2) }
        btn5c.setOnClickListener { onEntry(5) }
        btn10c.setOnClickListener { onEntry(10) }
        btn20c.setOnClickListener { onEntry(20) }
        btn50c.setOnClickListener { onEntry(50) }
        btn1e.setOnClickListener { onEntry(100) }
        btn2e.setOnClickListener { onEntry(200) }
        btn5e.setOnClickListener { onEntry(500) }
        btn10e.setOnClickListener { onEntry(1000) }
        btn20e.setOnClickListener { onEntry(2000) }

    }

    private fun onEntry(entryVal: Int) {
        val sharedPreference = SharedPreference(this)
        var alreadyPaid: Int = sharedPreference.getValueInt("alreadyPaid")
        alreadyPaid += entryVal
        sharedPreference.save("alreadyPaid", alreadyPaid)
        txtPaid.text = (alreadyPaid.toDouble()/100).toString() + " €"
    }

}