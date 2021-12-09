package com.mahlendur.ticketapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val sharedPreference = SharedPreference(this)
    }

    fun startActivityInsert(view: View) {
        val intent = Intent(this, InsertMoneyActivity::class.java)
        startActivity(intent)
    }

    fun startActivityBuy(view: View) {
        val intent = Intent(this, BuyTicketActivity::class.java)
        startActivity(intent)
    }

    fun startActivityShowAll(view: View) {
        val intent = Intent(this, AllTicketsActivity::class.java)
        startActivity(intent)
    }



}