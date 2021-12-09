package com.mahlendur.ticketapp

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import kotlinx.coroutines.CoroutineScope

@Database(entities = [Ticket::class], version = 1, exportSchema = false)
abstract class TicketRoomDatabase : RoomDatabase() {

    abstract fun TicketDAO(): TicketDAO

    companion object {
        @Volatile
        private var INSTANCE: TicketRoomDatabase? = null

        fun getDatabase(
            context: Context,
            scope: CoroutineScope
        ): TicketRoomDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    TicketRoomDatabase::class.java,
                    "ticket_database"
                ).addCallback(TicketDatabaseCallback(scope))
                    .build()
                INSTANCE = instance

                instance
            }
        }

        private class TicketDatabaseCallback(
            private val scope: CoroutineScope
        ) : RoomDatabase.Callback() {
            override fun onCreate(db: SupportSQLiteDatabase) {
                super.onCreate(db)
            }
        }
    }
}