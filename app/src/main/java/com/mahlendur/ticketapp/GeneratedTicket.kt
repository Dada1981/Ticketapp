package com.mahlendur.ticketapp

import java.time.LocalDateTime
import java.util.*

class GeneratedTicket (val genDate: LocalDateTime, val price: Char) {
    var dateGenerated: LocalDateTime = LocalDateTime.MIN
    var priceLevel: Char = 'X'
}