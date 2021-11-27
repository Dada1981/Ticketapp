package com.mahlendur.ticketapp

import android.content.Context
import androidx.room.*
import java.math.BigInteger
import java.time.Instant
import java.time.LocalDateTime
import java.time.OffsetDateTime
import java.time.ZoneOffset
import java.time.format.DateTimeFormatter

class IsoTimeConverter {
    @TypeConverter
    fun stringToOffsetDateTime(value: String?): OffsetDateTime? {
        if (value == null) return null
        return OffsetDateTime.parse(value, DateTimeFormatter.ISO_OFFSET_DATE_TIME)
    }

    @TypeConverter
    fun offsetDateTimeToString(value: OffsetDateTime?): String? {
        if (value == null) return null
        return value.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME)
    }
}

@TypeConverters(IsoTimeConverter::class)
@Entity
data class TicketRoom(
    @PrimaryKey(autoGenerate = true)
    var id: Int,
    var genDate: OffsetDateTime,
    var ticket_level: String
)

@Dao
interface ticketDAO {
    @Query("SELECT * FROM ticketroom")
    fun getAll(): List<TicketRoom>

    @Insert
    fun insertAll(vararg ticket: TicketRoom)

    @Delete
    fun delete(ticket: TicketRoom)

    @Update
    fun updateTicket (vararg tickets: TicketRoom)
}

@Database(entities = [TicketRoom::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun ticketDAO(): ticketDAO
}
