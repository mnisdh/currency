package com.mnisdh.common.util

class StringUtil {

    companion object {

        fun getInteger(str: String): Int? {
            return str.replace("[^0-9.]".toRegex(), "").split(".")[0].toIntOrNull()
        }

        fun getFloat(str: String): Float? {
            return str.replace("[^0-9.]".toRegex(), "").toFloatOrNull()
        }

    }

}