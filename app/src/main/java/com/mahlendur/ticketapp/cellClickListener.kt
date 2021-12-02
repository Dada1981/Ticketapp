package com.mahlendur.ticketapp

class OnClickListener(val clickListener: (ticket: Ticket) -> Unit) {
    fun onClick(ticket: Ticket) = clickListener(ticket)
}