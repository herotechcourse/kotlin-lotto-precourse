package lotto

import java.util.Locale
import kotlin.math.pow
import kotlin.math.round

fun Number.formatWithComma(): String =
    when (this) {
        is Int, is Long -> String.format(Locale.US, "%,d", this)
        else -> String.format(Locale.US, "%,.1f", this.toDouble())
    }

fun Float.roundToDecimalPlaces(places: Int): Double {
    require(places >= 0) { "Decimal places must be non-negative." }
    val factor = 10.0.pow(places)
    return round(this * factor) / factor
}