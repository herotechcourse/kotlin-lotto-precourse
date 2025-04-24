package lotto
import lotto.views.inputTickets
import lotto.views.inputWinningNumber
import lotto.views.inputSingleNumber

fun main() {
    // TODO: Implement the program
    val tickets = inputTickets()
    val numbers = inputWinningNumber()
    val luckyNumber = inputSingleNumber(numbers)
}

enum class LottoResults(val matches: Int, val matchBonus: Boolean, val prize: Int , val message: String) {
    FIRST_PRIZE(matches = 6,matchBonus= false, prize = 2000000000, message = "6 Matches (2,000,000,000 KRW)"),
    SECOND_PRIZE(matches = 5, matchBonus= false, prize = 30000000, message = "5 Matches + Bonus Ball (30,000,000 KRW)"),
    THIRD_PRIZE(matches = 5, matchBonus= false, prize = 1500000, message = "5 Matches (1,500,000 KRW)"),
    FOURTH_PRIZE(matches = 4, matchBonus= false, prize = 50000, message = "4 Matches (50,000 KRW)"),
    FIFTH_PRIZE(matches = 3, matchBonus= false, prize = 5000, message = "3 Matches (5,000 KRW)"),
}