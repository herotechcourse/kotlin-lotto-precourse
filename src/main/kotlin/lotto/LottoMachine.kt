package lotto

import camp.nextstep.edu.missionutils.Randoms

class LottoMachine {
    fun generateTickets(numberOfTickets: Int): List<Lotto> {
        require(numberOfTickets > 0) { "[ERROR] Number of tickets must be positive." }
        return (1..numberOfTickets).map {
            val numbers = generateUniqueLottoNumbers()
            Lotto(numbers)
        }
    }

    private fun generateUniqueLottoNumbers(): List<Int> {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6)
        }
}