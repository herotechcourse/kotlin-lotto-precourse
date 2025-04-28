package lotto.domain

import camp.nextstep.edu.missionutils.Randoms

class LottoGenerator {
    companion object {
        private const val TICKET_PRICE = 1000
        private const val MIN_NUMBER = 1
        private const val MAX_NUMBER = 45
        private const val NUMBERS_PER_TICKET = 6
    }
    
    fun generate(amount: Int): List<Lotto> {
        validateAmount(amount)
        val ticketCount = amount / TICKET_PRICE
        
        return List(ticketCount) {
            createRandomLotto()
        }
    }
    
    private fun validateAmount(amount: Int) {
        require(amount > 0) {
            "[ERROR] Purchase amount must be greater than 0."
        }
        require(amount % TICKET_PRICE == 0) {
            "[ERROR] Purchase amount must be divisible by 1,000."
        }
    }
    
    private fun createRandomLotto(): Lotto {
        val numbers = Randoms.pickUniqueNumbersInRange(
            MIN_NUMBER, 
            MAX_NUMBER, 
            NUMBERS_PER_TICKET
        )
        return Lotto(numbers)
    }
} 