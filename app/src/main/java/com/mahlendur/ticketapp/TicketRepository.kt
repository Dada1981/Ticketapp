package com.mahlendur.ticketapp

import androidx.annotation.WorkerThread
import kotlinx.coroutines.flow.Flow

class TicketRepository(private val TicketDAO: TicketDAO) {
    val allTickets: Flow<List<Ticket>> = TicketDAO.getAllTickets()

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insert(ticket: Ticket) {
        TicketDAO.insert(ticket)
    }

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun deleteAll() {
        TicketDAO.deleteAll()
    }
}