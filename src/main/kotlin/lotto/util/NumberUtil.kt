package lotto.util

fun Int.toFormatted(): String = "%,d".format(this)

fun Double.toPercentageString(): String = "%.1f%%".format(this)