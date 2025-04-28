package lotto

object Config {
    const val TICKET_PRICE = 1000
    const val MIN_LOTTO_NUMBER = 1
    const val MAX_LOTTO_NUMBER = 45
    const val LOTTO_NUMBER_COUNT = 6

    object RankConfig {
        const val FIRST_MATCH_COUNT = 6
        const val SECOND_MATCH_COUNT = 5
        const val THIRD_MATCH_COUNT = 5
        const val FOURTH_MATCH_COUNT = 4
        const val FIFTH_MATCH_COUNT = 3

        // Prizes in Korean Won as Long type
        const val FIRST_PRIZE = 2000000000L
        const val SECOND_PRIZE = 30000000L
        const val THIRD_PRIZE = 1500000L
        const val FOURTH_PRIZE = 50000L
        const val FIFTH_PRIZE = 5000L
    }
}
