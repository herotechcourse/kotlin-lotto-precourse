package lotto

import camp.nextstep.edu.missionutils.Console

class InputView {
    var purchaseAmount: Int = 0
    var tickets: List<List<Int>> = listOf(listOf())
    var winningNumbers: List<Int> = listOf()
    var bonusNumber: Int = 0

    fun init() {
        parsePurchaseAmount()
        tickets = Lotto.generateTickets(purchaseAmount)
        OutputView.printTickets(tickets)
        parseWinningNumbers()
        parseBonusNumber()
    }

    private fun parsePurchaseAmount() {
        while (true) try {
            println("\nPlease enter the purchase amount.")
            purchaseAmount = InputValidate.validateAmount(Console.readLine())
            break
        } catch (e: IllegalArgumentException) {
            println(e.message)
        }
    }

    private fun parseWinningNumbers() {
        while (true) try {
            println("\nPlease enter last week's winning numbers.")
            winningNumbers = InputValidate.validateWinningNumbers(Console.readLine())
            break
        } catch (e: IllegalArgumentException) {
            println(e.message)
        }
    }

    private fun parseBonusNumber() {
        while (true) try {
            println("\nPlease enter the bonus number.")
            bonusNumber = InputValidate.validateBonusNumber(Console.readLine(), winningNumbers)
            break
        } catch (e: IllegalArgumentException) {
            println(e.message)
        }
    }

}