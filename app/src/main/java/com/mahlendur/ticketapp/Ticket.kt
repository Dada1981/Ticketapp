package com.mahlendur.ticketapp

import androidx.room.*

@Entity(tableName = "ticket_table")
class Ticket (
    @PrimaryKey
    @ColumnInfo(name = "dateCreated")
    val dateCreated: String,
    val ticketLvl: String
)





