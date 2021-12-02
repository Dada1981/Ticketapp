package com.mahlendur.ticketapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.activity.viewModels

class activity_all_tickets : AppCompatActivity() {
    private val ticketViewModel: TicketViewModel by viewModels {
        TicketViewModelFactory((application as TicketApplication).repository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_all_tickets)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerview)
        val adapter = TicketListAdapter(this)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        ticketViewModel.allTickets.observe(this) { tickets ->
            tickets.let { adapter.submitList(it) }
        }



    }

    fun click_Delete(view: View) {
        ticketViewModel.deleteAll()
        Toast.makeText(this, "Tickets gelöscht!", Toast.LENGTH_SHORT).show()
    }




}