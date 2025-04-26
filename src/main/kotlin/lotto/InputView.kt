package lotto

import camp.nextstep.edu.missionutils.Randoms
import camp.nextstep.edu.missionutils.Console

class InputView {
    private var numberOfTickets: Int = 0
    private var purchaseAmount: Int = 0
    private var tickets: List<List<Int>> = listOf(listOf())
    private var winningNumbers: List<Int> = listOf()
    private var bonusNumber: Int = 0

    fun initPrintTicket() {
        parsePurchaseAmount()
        tickets = generateTickets(purchaseAmount)
        OutputView.printTickets(tickets, numberOfTickets)
        parseWinningNumbers()
        parseBonusNumber()
    }

    private fun parsePurchaseAmount() {
        while (true) {
            try {
                println()
                println("Please enter the purchase amount.")
                purchaseAmount = InputValidate.validateAmount(Console.readLine())
                break
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    private fun parseWinningNumbers() {
        while (true) {
            try {
                println("Please enter last week's winning numbers.")
                winningNumbers = InputValidate.validateWinningNumbers(Console.readLine())
                break
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    private fun parseBonusNumber() {
        while (true) {
            try {
                println()
                println("Please enter the bonus number.")
                bonusNumber = InputValidate.validateBonusNumber(Console.readLine(), winningNumbers)
                break
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    private fun generateTickets(purchaseAmount: Int): List<List<Int>> {
        numberOfTickets = purchaseAmount / 1000
        val rawTickets: MutableList<MutableList<Int>> = mutableListOf()

        for (i in 0 until numberOfTickets) {
            val singleTicket = generateSingleTicket()
            rawTickets.add(singleTicket)
        }
        return InputValidate.validateTickets(rawTickets)
    }

    private fun generateSingleTicket(): MutableList<Int> = Randoms.pickUniqueNumbersInRange(1, 45, 6)

    fun getWinningNumbers(): List<Int> = winningNumbers

    fun getBonusNumber(): Int = bonusNumber

    fun getPurchaseAmount(): Int = purchaseAmount

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
