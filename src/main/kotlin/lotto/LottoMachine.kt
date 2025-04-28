package lotto

import camp.nextstep.edu.missionutils.Randoms

class LottoMachine {
    fun generateTickets(count: Int): List<Lotto> {
        require(count > 0) { "[ERROR] Ticket count must be positive." }
        
        return List(count) { generateLotto() }
    }
    
    private fun generateLotto(): Lotto {
        val numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6)
        return Lotto(numbers)
    }
}