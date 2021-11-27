package com.mahlendur.ticketapp

import android.app.Application
import androidx.room.Room

val cacheDb: AppDatabase = TicketApplication.appDatabase!!

class TicketApplication: Application() {
    companion object {
        var appDatabase : AppDatabase? = null
    }

    override fun onCreate() {
        appDatabase = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java,
            "ticketroom"
        ).build()


        super.onCreate()
    }
}