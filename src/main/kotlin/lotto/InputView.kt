package lotto

import camp.nextstep.edu.missionutils.Randoms
import camp.nextstep.edu.missionutils.Console

class InputView {
    private var purchaseAmount: Int? = parsePurchaseAmount()
    var tickets: List<List<Int>> = generateTickets(purchaseAmount)
    private var winningNumber: List<Int> = parseWinningNumber()
    private var bonusNumber: Int = parseBonusNumber()

    private fun parsePurchaseAmount(): Int {
        println("Please enter the purchase amount.")
        val input = Console.readLine()

        return InputValidate.validateAmount(input)
    }

    private fun parseWinningNumber(): List<Int> {
        println("Please enter last week's winning numbers.")
        val input = Console.readLine()

        return InputValidate.validateWinningNumber(input)
    }

    private fun parseBonusNumber(): Int {
        println("Please enter the bonus number.")
        val input = Console.readLine()

        return InputValidate.validateBonusNumber(input, winningNumber)
    }

    private fun generateTickets(purchaseAmount: Int?): List<List<Int>> {
        val ticketNumber = purchaseAmount?.div(1000)
        val safeTicketNumber: Int = ticketNumber!!
        var tickets: MutableList<List<Int>> = mutableListOf()

        for (i in 0 until safeTicketNumber) {
            val singleTicket: List<Int> = generateSingleTicket()
            tickets.add(singleTicket)
        }
        return InputValidate.validateTickets(tickets)
    }

    private fun generateSingleTicket(): List<Int> = Randoms.pickUniqueNumbersInRange(1, 45, 6)

    fun getWinningNumber(): List<Int> = winningNumber

    fun getBonusNumber (): Int = bonusNumber

}


// for test variables are initialized correct
//class InputView {
//
//    fun parsePurchaseAmount(input: String): Int {
//        return InputValidate.validateAmount(input)
//    }
//
//    fun parseWinningNumber(input: String): List<Int> {
//        return InputValidate.validateWinningNumber(input)
//    }
//
//    fun parseBonusNumber(input: String, winningNumber: List<Int>): Int {
//        return InputValidate.validateBonusNumber(input, winningNumber)
//    }
//}
