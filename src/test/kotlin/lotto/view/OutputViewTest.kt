package lotto.view

import lotto.model.Lotto
import lotto.model.LottoResult
import lotto.model.Rank
import org.junit.jupiter.api.Test
import java.io.ByteArrayOutputStream
import java.io.PrintStream

class OutputViewTest {

    @Test
    fun `prints lottos correctly`() {
        val outputStream = captureOutput {
            val outputView = OutputView()
            val lottos = listOf(
                Lotto(listOf(1, 2, 3, 4, 5, 6)),
                Lotto(listOf(7, 8, 9, 10, 11, 12))
            )

            outputView.printLottos(lottos)
        }

        val expected = """
            
            You have purchased 2 tickets.
            [1, 2, 3, 4, 5, 6]
            [7, 8, 9, 10, 11, 12]
            
        """.trimIndent()

        assert(outputStream.contains("You have purchased 2 tickets."))
        assert(outputStream.contains("[1, 2, 3, 4, 5, 6]"))
        assert(outputStream.contains("[7, 8, 9, 10, 11, 12]"))
    }

    @Test
    fun `prints results correctly`() {
        val outputStream = captureOutput {
            val outputView = OutputView()
            val result = LottoResult().apply {
                addRank(Rank.FIRST)
                addRank(Rank.THIRD)
                addRank(Rank.THIRD)
                addRank(Rank.FIFTH)
                addRank(Rank.FIFTH)
                addRank(Rank.FIFTH)
            }

            outputView.printResults(result)
        }

        assert(outputStream.contains("Winning Statistics"))
        assert(outputStream.contains("3 Matches (5,000 KRW) – 3 tickets"))
        assert(outputStream.contains("5 Matches (1,500,000 KRW) – 2 tickets"))
        assert(outputStream.contains("6 Matches (2,000,000,000 KRW) – 1 tickets"))
    }

    @Test
    fun `prints profit rate correctly`() {
        val outputStream = captureOutput {
            val outputView = OutputView()
            outputView.printProfitRate(62.5)
        }

        assert(outputStream.contains("Total return rate is 62.5%."))
    }

    @Test
    fun `prints error message correctly`() {
        val outputStream = captureOutput {
            val outputView = OutputView()
            outputView.printError("[ERROR] Test error message")
        }

        assert(outputStream.contains("[ERROR] Test error message"))
    }

    private fun captureOutput(block: () -> Unit): String {
        val originalOut = System.out
        val outputStream = ByteArrayOutputStream()

        try {
            System.setOut(PrintStream(outputStream))
            block()
            return outputStream.toString()
        } finally {
            System.setOut(originalOut)
        }
    }
}