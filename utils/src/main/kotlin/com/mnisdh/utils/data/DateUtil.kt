package com.mnisdh.utils.data

import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class DateUtil {
    companion object {

        // "yyyy-MM-dd HH:mm:ss"
        fun format(value: LocalDateTime, pattern: String): String {
            return value.format(DateTimeFormatter.ofPattern(pattern))
        }

        fun format(value: LocalDate, pattern: String): String {
            return value.format(DateTimeFormatter.ofPattern(pattern))
        }

    }
}