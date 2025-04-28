package lotto.domain

import lotto.Lotto

import camp.nextstep.edu.missionutils.Randoms

/**
 * Responsible for generating lottery tickets based on the purchase amount.
 */
class LottoMachine {

    /**
     * Issues lottery tickets based on the provided purchase amount.
     *
     * @param amount the purchase amount entered by the user
     * @return a list of generated Lotto tickets
     * @throws IllegalArgumentException if amount is not divisible by 1,000
     */
    fun issueTickets(amount: Int): List<Lotto> {
        val numberOfTickets = amount / 1000
        return List(numberOfTickets) { generateLotto() }
    }

    private fun generateLotto(): Lotto {
        val numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6)
            .sorted()
        return Lotto(numbers)
    }
}