package lotto.service

import camp.nextstep.edu.missionutils.Randoms
import lotto.model.Lotto

class LottoMachine {

    fun issue(amount: Int): List<Lotto> {
        validateAmount(amount)

        val ticketCount = amount / TICKET_PRICE
        return generateLottos(ticketCount)
    }

    private fun validateAmount(amount: Int) {
        require(amount > 0) { "[ERROR] Purchase amount must be greater than 0." }
        require(amount % TICKET_PRICE == 0) { "[ERROR] Purchase amount must be divisible by 1,000." }
    }

    private fun generateLottos(count: Int): List<Lotto> {
        return (1..count).map {
            generateLotto()
        }
    }

    private fun generateLotto(): Lotto {
        val numbers = Randoms.pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, LOTTO_SIZE)
        return Lotto(numbers)
    }

    companion object {
        const val TICKET_PRICE = 1000
        const val LOTTO_SIZE = 6
        const val MIN_NUMBER = 1
        const val MAX_NUMBER = 45
    }
}