package lotto.util

object Constants {
    const val MIN_LOTTO_NUMBER = 1
    const val MAX_LOTTO_NUMBER = 45
    const val LOTTO_NUMBER_COUNT = 6

    const val ERROR_PREFIX = "[ERROR]"
    const val PURCHASE_AMOUNT_UNIT = 1000
    const val MIN_PURCHASE_AMOUNT = PURCHASE_AMOUNT_UNIT
    const val CURRENCY_UNIT = "KRW"

    const val PURCHASE_AMOUNT_PROMPT = "Please enter the purchase amount."
    const val WINNING_NUMBERS_PROMPT = "\nPlease enter last week's winning numbers."
    const val BONUS_NUMBER_PROMPT = "\nPlease enter the bonus number."

    const val ERROR_INVALID_NUMBER = "$ERROR_PREFIX Input must be a valid number."
    const val ERROR_INVALID_PURCHASE_AMOUNT = "$ERROR_PREFIX Purchase amount must be at least $MIN_PURCHASE_AMOUNT $CURRENCY_UNIT."
    const val ERROR_INVALID_PURCHASE_UNIT = "$ERROR_PREFIX Purchase amount must be in units of $PURCHASE_AMOUNT_UNIT $CURRENCY_UNIT."
    const val ERROR_INVALID_WINNING_NUMBER = "$ERROR_PREFIX All Lotto numbers must be numbers."
    const val ERROR_INVALID_BONUS_NUMBER = "$ERROR_PREFIX Bonus number must be a number."
    const val ERROR_BONUS_OUT_OF_RANGE = "$ERROR_PREFIX Bonus number must be between $MIN_LOTTO_NUMBER and $MAX_LOTTO_NUMBER."
    const val ERROR_DUPLICATE_BONUS_NUMBER = "$ERROR_PREFIX Bonus number must not be a duplicate of the winning numbers."

    const val ERROR_INVALID_NUMBER_COUNT = "$ERROR_PREFIX Lotto must contain exactly $LOTTO_NUMBER_COUNT numbers."
    const val ERROR_DUPLICATE_NUMBER = "$ERROR_PREFIX Lotto numbers must not contain duplicate numbers."
    const val ERROR_NUMBER_OUT_OF_RANGE = "$ERROR_PREFIX Lotto numbers must be between $MIN_LOTTO_NUMBER and $MAX_LOTTO_NUMBER."

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