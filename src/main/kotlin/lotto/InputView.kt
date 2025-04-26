package lotto

import camp.nextstep.edu.missionutils.Randoms
import camp.nextstep.edu.missionutils.Console

class InputView {
    private var purchaseAmount: Int = 0
    private var tickets: List<List<Int>> = listOf(listOf())
    private var winningNumbers: List<Int> = listOf()
    private var bonusNumber: Int = 0

    fun initPrintTicket() {
        parsePurchaseAmount()
        tickets = Lotto.generateTickets(purchaseAmount)
        OutputView.printTickets(tickets)
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

    fun getWinningNumbers(): List<Int> = winningNumbers

    fun getBonusNumber(): Int = bonusNumber

    fun getPurchaseAmount(): Int = purchaseAmount

    fun getTickets(): List<List<Int>> = tickets

}