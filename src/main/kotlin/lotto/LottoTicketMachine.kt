package lotto

import lotto.StringUtil.toIntList

class LottoTicketMachine(
    private val input: Input,
    private val validator: Validator,
    private val output: Output,
) {

    fun enterPurchaseAmount(): Int {
        println("Please enter the purchase amount.")
        return input.enterNumber { validator.validateStringToInt(it) }
    }

    fun issueTickets(purchaseAmount: Int): List<List<Int>> {
        val issuedTicket = IssuedTicket(purchaseAmount, DefaultRandomGenerator())
        val issuedTickets = IssuedTicketsGenerator.of(issuedTicket)
        output.printIssuedTickets(issuedTicket.getCount(), issuedTickets)
        return issuedTickets
    }

    fun enterWinningNumbers(): List<Int> {
        println("Please enter last week's winning numbers.")
        return input.enterNumber { it.toIntList(validator) }
    }

    fun enterBonusNumber(winningNumbers: List<Int>): Int {
        println("Please enter the bonus number.")
        return input.enterNumber { validator.validateBonusNumber(it, winningNumbers) }
    }

    fun winningStatistics(
        lotto: Lotto,
        issuedTickets: List<List<Int>>,
        bonusNumber: Int,
        purchaseAmount: Int,
    ) {
        lotto.simulate(issuedTickets, bonusNumber)
        output.printWinningStatistics(lotto.getProfitRate(purchaseAmount))
    }
}
