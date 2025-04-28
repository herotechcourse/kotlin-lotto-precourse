package lotto.controller

import lotto.domain.LottoResult
import lotto.domain.LottoTickets
import lotto.domain.Money
import lotto.domain.WinningNumbers
import lotto.view.InputView
import lotto.view.OutputView

class LottoController {
    fun run() {
        val money = readPurchaseAmount()
        val tickets = LottoTickets.generate(money)

        OutputView.printPurchaseCount(money.getNumberOfTickets())
        OutputView.printLottoTickets(tickets.getTickets())

        val winningNumbers = readWinningNumbersInput()
        val result = LottoResult(tickets.getTickets(), winningNumbers)
        val counts = result.getRankCounts()

        OutputView.printResultStatistics(counts)
        OutputView.printTotalYield(result.calculateYield(money))
    }

    private fun readPurchaseAmount(): Money {
        while (true) {
            try {
                val input = InputView.readPurchaseAmount()
                val amount = input.toInt()
                return Money(amount)
            } catch (e: NumberFormatException) {
                println("[ERROR] Input must be a number.")
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    private fun readWinningNumbersInput(): WinningNumbers {
        while (true) {
            try {
                val numbersInput = InputView.readWinningNumbers()
                val numbers = numbersInput.split(",").map { it.trim().toInt() }
                val bonusInput = InputView.readBonusNumber()
                val bonus = bonusInput.toInt()
                return WinningNumbers(numbers, bonus)
            } catch (e: NumberFormatException) {
                println("[ERROR] Input must be a number.")
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }
}