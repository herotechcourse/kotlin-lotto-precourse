package lotto

import camp.nextstep.edu.missionutils.Randoms

class LottoMachine(private val money: Int) {

    val tickets: List<Lotto> = generateTickets()

    private fun generateTickets(): List<Lotto> {
        return List(money / 1000) {
            generateSingleTicket()
        }
    }

    private fun generateSingleTicket(): Lotto {
        val numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6).sorted()
        return Lotto(numbers)
    }

    private fun countMatch(actualNumbers: Set<Int>, guessNumbers: Set<Int>): Int {
        return actualNumbers.intersect(guessNumbers).size
    }

    private fun checkBonusMatch(ticket: Lotto, bonusNumber: Int): Boolean {
        return ticket.getNumbers().contains(bonusNumber)
    }
}
