package lotto.controller

import lotto.*
import lotto.presentation.InputView
import lotto.presentation.OutputView
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertEquals

class LottoControllerImplTest {

    @Test
    fun `LottoControllerImpl runs the flow correctly`() {
        val fakeInputValidator = object : InputValidator {
            override fun validatePurchaseAmount(purchaseAmountInput: String): Int = 3000
            override fun validateWinningNumbers(winningNumbersInput: String): List<Int> =
                listOf(1, 2, 3, 4, 5, 6)

            override fun validateBonusNumber(bonusNumberInput: String): Int = 7
        }
        val fakeInputView = object : InputView {
            override fun readPurchaseAmount(): String = "3000"

            override fun readWinningNumbers(): String = "1,2,3,4,5,6"

            override fun readBonusNumber(): String = "7"
        }
        val fakeOutputView = object : OutputView {
            val prompts = mutableListOf<String>()
            val printedTickets = mutableListOf<List<Lotto>>()
            val printedResults = mutableListOf<Map<Rank, Int>>()
            var printedProfitRate: Double? = null
            var printedErrors = mutableListOf<String?>()

            override fun printInputPrompt(promptMessage: String) {
                prompts.add(promptMessage)
            }

            override fun printNumberOfTickets(numberOfTickets: Int) {
                prompts.add("Tickets: $numberOfTickets")
            }

            override fun printTickets(tickets: List<Lotto>) {
                printedTickets.add(tickets)
            }

            override fun printStatistics(statistics: Map<Rank, Int>) {
                printedResults.add(statistics)
            }

            override fun printProfitRate(profitRate: Double) {
                printedProfitRate = profitRate
            }

            override fun printErrorMessage(errorMessage: String?) {
                printedErrors.add(errorMessage)
            }

            override fun printBlankLine() {}
        }
        val fakeLottoTicketGenerator = object : LottoTicketGenerator {
            override fun generateNumberOfTickets(purchaseAmount: Int): Int = 3

            override fun generateTickets(numberOfTickets: Int): List<Lotto> {
                return List(numberOfTickets) { Lotto(listOf(1, 2, 3, 4, 5, 6)) }
            }

            override fun generateRandomNumbersInRange(): List<Int> {
                return listOf(1, 2, 3, 4, 5, 6)
            }
        }
        val fakeStatistics = object : Statistics {
            override fun calculateResult(
                tickets: List<Lotto>,
                winningNumbers: List<Int>,
                bonusNumber: Int,
            ): Map<Rank, Int> {
                return mapOf(Rank.FIRST to 1)
            }

            override fun calculateProfitRate(purchaseAmount: Int): Double {
                return 200.0
            }
        }
        val controller = LottoControllerImpl(
            inputValidator = fakeInputValidator,
            inputView = fakeInputView,
            outputView = fakeOutputView,
            lottoTicketGenerator = fakeLottoTicketGenerator,
            statistics = fakeStatistics,
        )

        controller.run()

        assertEquals(
            listOf(
                "Please enter the purchase amount.",
                "Tickets: 3",
                "Please enter last week's winning numbers.",
                "Please enter the bonus number.",
            ), fakeOutputView.prompts
        )
        assertEquals(1, fakeOutputView.printedTickets.size)
        assertEquals(3, fakeOutputView.printedTickets[0].size)
        assertEquals(1, fakeOutputView.printedResults.size)
        assertEquals(mapOf(Rank.FIRST to 1), fakeOutputView.printedResults[0])
        assertEquals(200.0, fakeOutputView.printedProfitRate)
    }

}
