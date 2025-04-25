package lotto

import camp.nextstep.edu.missionutils.Randoms
import camp.nextstep.edu.missionutils.Console

class InputView {
    private var ticketNumber: Int = 0
    private var purchaseAmount: Int = 0
    private var tickets: List<List<Int>> = listOf(listOf())
    private var winningNumber: List<Int> = listOf()
    private var bonusNumber: Int = 0

    fun initPrintTicket(){
        parsePurchaseAmount()
        tickets = generateTickets(purchaseAmount)
        OutputView.printTickets(tickets, ticketNumber)
        parseWinningNumber()
        parseBonusNumber()
    }

    private fun parsePurchaseAmount() {
        println()
        println("Please enter the purchase amount.")
        val input = Console.readLine()
        purchaseAmount = InputValidate.validateAmount(input)
    }

    private fun parseWinningNumber() {
        println("Please enter last week's winning numbers.")
        val input = Console.readLine()
        winningNumber = InputValidate.validateWinningNumber(input)
    }

    private fun parseBonusNumber(){
        println()
        println("Please enter the bonus number.")
        val input = Console.readLine()
        bonusNumber = InputValidate.validateBonusNumber(input, winningNumber)
    }

    private fun generateTickets(purchaseAmount: Int): List<List<Int>>{
        ticketNumber = purchaseAmount / 1000
        var rawTickets: MutableList<MutableList<Int>> = mutableListOf()

        for (i in 0 until ticketNumber) {
            val singleTicket: MutableList<Int> = generateSingleTicket()
            rawTickets.add(singleTicket)
        }
        return InputValidate.validateTickets(rawTickets)
    }

    private fun generateSingleTicket(): MutableList<Int> = Randoms.pickUniqueNumbersInRange(1, 45, 6)

    fun getWinningNumber(): List<Int> = winningNumber

    fun getBonusNumber (): Int = bonusNumber

    fun getPurchaseAmount (): Int = purchaseAmount

    fun getTickets(): List<List<Int>> = tickets


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
