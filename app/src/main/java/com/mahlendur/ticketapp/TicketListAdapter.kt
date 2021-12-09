package com.mahlendur.ticketapp

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.mahlendur.ticketapp.TicketListAdapter.TicketViewHolder

class TicketListAdapter(private var mContext: Context) : ListAdapter<Ticket, TicketViewHolder>(TicketsComparator()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TicketViewHolder {
        return TicketViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: TicketViewHolder, position: Int) {
        val current = getItem(position)
        holder.bind(current.dateCreated + " | " + current.ticketLvl)
        holder.itemView.setOnClickListener {
            val mIntent = Intent(mContext, ShowTicketActivity::class.java)
            mIntent.putExtra("givenTime", current.dateCreated)
            mContext.startActivity(mIntent)
        }
    }


    class TicketViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val ticketItemView: TextView = itemView.findViewById(R.id.textView)

        fun bind(text: String?) {
            ticketItemView.text = text
        }

        companion object {
            fun create(parent: ViewGroup): TicketViewHolder {
                val view: View = LayoutInflater.from(parent.context)
                    .inflate(R.layout.recyclerview_item, parent, false)
                return TicketViewHolder(view)
            }
        }


    }

    class TicketsComparator : DiffUtil.ItemCallback<Ticket>() {
        override fun areItemsTheSame(oldItem: Ticket, newItem: Ticket): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: Ticket, newItem: Ticket): Boolean {
            return oldItem.dateCreated == newItem.dateCreated
        }


    }
}