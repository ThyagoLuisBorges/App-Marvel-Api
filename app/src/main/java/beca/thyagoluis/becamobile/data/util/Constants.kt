package beca.thyagoluis.becamobile.data.util

import java.util.*

const val PUBLIC_KEY = ""
const val PRIVATE_KEY = ""
val TS = (Calendar.getInstance(TimeZone.getTimeZone("UTC")).timeInMillis / 1000L).toString()
val HASH = "$TS$PRIVATE_KEY$PUBLIC_KEY"