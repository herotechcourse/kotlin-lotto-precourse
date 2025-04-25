package lotto

class Lotto(private val numbers: List<Int>) : LottoValidator, BonusValidator {

    init {
        validateNumbers(numbers)
    }

    fun simulate(
        issuedTickets: List<List<Int>>,
        bonusNumber: Int,
        statistics: LottoStatistics,
    ) {
        issuedTickets.forEach {
            statistics.updateTicketCount(getMatchCount(it), hasBonus(it, bonusNumber))
        }
    }

    private fun getMatchCount(issuedTicket: List<Int>) = numbers.count { it in issuedTicket }

    private fun hasBonus(issuedTicket: List<Int>, bonusNumber: Int) = bonusNumber in issuedTicket

    override fun validateNumber(number: Int) {
        require(number !in numbers) {
            "Bonus number must not duplicate with winning numbers."
        }
    }
}
