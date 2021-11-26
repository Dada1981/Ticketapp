package com.mahlendur.ticketapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val sharedPreference: SharedPreference = SharedPreference(this)

    }

    fun startActivity_insert(view: View) {
        val intent = Intent(this, activity_insert_money::class.java)
        startActivity(intent)
    }

    fun startActivity_buy(view: View) {
        val intent = Intent(this, activity_buy_ticket::class.java)
        startActivity(intent)
    }



}