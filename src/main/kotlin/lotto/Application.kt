package lotto

fun main() {
    // TODO: Implement the program
}

enum class LottoResults(val matches: Int, val message: String) {
    FIRST_PRIZE(matches = 1, message = "6 Matches (2,000,000,000 KRW)"),
    SECOND_PRIZE(matches = 2, message = "5 Matches + Bonus Ball (30,000,000 KRW)"),
    THIRD_PRIZE(matches = 3, message = "5 Matches (1,500,000 KRW)"),
    FOURTH_PRIZE(matches = 4, message = "4 Matches (50,000 KRW)"),
    FIFTH_PRIZE(matches = 5, message = "3 Matches (5,000 KRW)"),
}