package com.mahlendur.ticketapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val refundBtn = findViewById<Button>(R.id.refundBtn)
        refundBtn.setOnClickListener {
            refundMoney()
        }

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

    fun refundMoney() {
        val sharedPreference = SharedPreference(this)
        var alreadyPaid = sharedPreference.getValueInt("alreadyPaid").toDouble()/100
        Toast.makeText(this, "$alreadyPaid € ausgezahlt!", Toast.LENGTH_SHORT).show()
        sharedPreference.removeValue("alreadyPaid")
    }

}