package com.mahlendur.ticketapp

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_buy_ticket.*


class activity_buy_ticket : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        val SharedPreferences: SharedPreferences = this.getSharedPreferences("com.mahlendur.ticketapp.alreadyPaid", MODE_PRIVATE)
        

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_buy_ticket)

        btn1c.setOnClickListener { onEntry(1) }
        btn2c.setOnClickListener { onEntry(2) }
        btn5c.setOnClickListener { onEntry(5) }
        btn10c.setOnClickListener { onEntry(10) }
        btn20c.setOnClickListener { onEntry(20) }
        btn50c.setOnClickListener { onEntry(50) }
        btn1e.setOnClickListener { onEntry(100) }
        btn2e.setOnClickListener { onEntry(200) }

    }

    private fun onEntry(entryVal: Int) {



    }
}