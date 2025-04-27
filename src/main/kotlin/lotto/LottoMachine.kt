package lotto.domain

import lotto.Lotto

import camp.nextstep.edu.missionutils.Randoms

// Lotto machine responsible for issuing tickets
object LottoMachine {

    // Issue a list of Lotto tickets based on the given purchase amount
    fun issueTickets(amount: Int): List<Lotto> {

        // Validates that the amount is divisible by 1000
        require(amount % 1000 == 0) { "[ERROR] Amount must be divisible by 1000." }

        // Create a list of Lotto tickets, one ticket per 1000 unites of amount
        return List(amount / 1000) {

            // Pick 6 unique random numbers between 1 and 45 for each ticket
            val numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6)

            // Return a Lotto object created with the selected numbers
            Lotto(numbers)
        }
    }
}