package lotto



object Configuration {
    const val LOTTO_NUMBER_COUNT = 6  // Top level constant!
    const val LOTTO_PRICE = 1000
    const val MAX_NUMBER = 45
    const val MIN_NUMBER = 1
    const val LOTTO_COUNT = 6

    object ErrorMessages {
        const val PURCHASE_AMOUNT_NON_ZERO = "[ERROR] Purchase amount must be greater than 0."
        const val PURCHASE_AMOUNT_DIVISIBLE = "[ERROR] Purchase amount must be a multiple of "
        const val PURCHASE_AMOUNT_INVALID = "[ERROR] [ERROR] Purchase amount must be a valid number."

        const val WINNING_NUMBERS_INVALID = "[ERROR] Winning numbers must be valid integers."

        const val BONUS_NUMBER_INVALID_RANGE = "[ERROR] Bonus number must be between ${Configuration.MIN_NUMBER} and ${Configuration.MAX_NUMBER}."
        const val BONUS_NUMBER_INVALID = "[ERROR] Bonus number must be a valid integer."

        const val LOTTO_COUNT_INVALID = "[ERROR] Lotto count must be greater than 0."
        const val LOTTO_COUNT_INVALID_SIZE = "[ERROR] Lotto must contain exactly ${Configuration.LOTTO_COUNT} numbers."
        const val LOTTO_COUNT_INVALID_DUPLICATE = "[ERROR] Lotto numbers must be unique."
        const val LOTTO_COUNT_INVALID_RANGE = "[ERROR] Lotto numbers must be between ${Configuration.MIN_NUMBER} and ${Configuration.MAX_NUMBER}."
    }

    object Prices {
        const val FIRST = 2_000_000_000
        const val SECOND = 1_500_000
        const val THIRD = 30_000_000
        const val FOURTH = 50_000
        const val FIFTH = 5_000
    }
}