package com.mahlendur.ticketapp

import android.app.Application
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob

class TicketApplication : Application() {
    private val applicationScope = CoroutineScope(SupervisorJob())

    private val database by lazy { TicketRoomDatabase.getDatabase(this, applicationScope) }
    val repository by lazy { TicketRepository(database.TicketDAO()) }
}