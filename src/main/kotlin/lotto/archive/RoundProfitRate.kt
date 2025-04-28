package lotto.archive

import kotlin.math.round

fun roundProfitRate(input: Double): Double {
    return (round(input * 10) / 10.0)
}