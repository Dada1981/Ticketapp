package com.mahlendur.ticketapp

import android.content.Context
import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Entity(tableName = "ticket_table")
class Ticket (
    @PrimaryKey
    @ColumnInfo(name = "dateCreated")
    val dateCreated: String,
    val ticketLvl: String
)





