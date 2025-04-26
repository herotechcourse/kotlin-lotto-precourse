package lotto.util

object Constants {
    const val MIN_LOTTO_NUMBER = 1
    const val MAX_LOTTO_NUMBER = 45
    const val LOTTO_NUMBER_COUNT = 6

    const val ERROR_PREFIX = "[ERROR]"
    const val PURCHASE_AMOUNT_UNIT = 1000
    const val MIN_PURCHASE_AMOUNT = PURCHASE_AMOUNT_UNIT
    const val CURRENCY_UNIT = "KRW"

    const val PRIZE_FIRST = 2_000_000_000
    const val PRIZE_SECOND = 30_000_000
    const val PRIZE_THIRD = 1_500_000
    const val PRIZE_FOURTH = 50_000
    const val PRIZE_FIFTH = 5_000

    private const val MONEY_FORMAT = "%,d"
    val FORMATTED_PRIZE_FIRST = MONEY_FORMAT.format(PRIZE_FIRST)
    val FORMATTED_PRIZE_SECOND = MONEY_FORMAT.format(PRIZE_SECOND)
    val FORMATTED_PRIZE_THIRD = MONEY_FORMAT.format(PRIZE_THIRD)
    val FORMATTED_PRIZE_FOURTH = MONEY_FORMAT.format(PRIZE_FOURTH)
    val FORMATTED_PRIZE_FIFTH = MONEY_FORMAT.format(PRIZE_FIFTH)
}