import lotto.domain.LottoResult
import lotto.domain.LottoTickets
import lotto.domain.Money
import lotto.domain.WinningNumbers
import lotto.view.InputView
import lotto.view.OutputView

class LottoController {
    fun run() {

        val money = retry({ InputView.readPurchaseAmount() }) { input ->
            val amount = input.toIntOrNull()
                ?: throw IllegalArgumentException("[ERROR] Input must be a number.")
            Money(amount)
        }

        val tickets = LottoTickets.generate(money)
        OutputView.printPurchaseCount(money.getNumberOfTickets())
        OutputView.printLottoTickets(tickets.getTickets())

        val numbers = retry({ InputView.readWinningNumbers() }, WinningNumbers.Companion::parseNumbers)
        val bonus   = retry({ InputView.readBonusNumber() }) { WinningNumbers.parseBonus(it, numbers) }
        val winningNumbers = WinningNumbers.of(numbers, bonus)

        val result = LottoResult(tickets.getTickets(), winningNumbers)
        val counts = result.getRankCounts()
        OutputView.printResultStatistics(counts)
        OutputView.printTotalYield(result.calculateYield(money))
    }

    private inline fun <T> retry(
        readInput: () -> String,
        parse: (String) -> T
    ): T {
        while (true) {
            try {
                val input = readInput()
                return parse(input)
            } catch (e: IllegalArgumentException) {
                println(e.message)
                println()
            } catch (e: IllegalStateException) {
                println(e.message)
                println()
            }
        }
    }
}
