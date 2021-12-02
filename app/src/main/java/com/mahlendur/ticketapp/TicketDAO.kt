package com.mahlendur.ticketapp

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface TicketDAO {

    @Query("SELECT * FROM ticket_table ORDER BY dateCreated ASC")
    fun getAllTickets(): Flow<List<Ticket>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(ticket: Ticket)

    @Query("DELETE FROM ticket_table")
    suspend fun deleteAll()
}