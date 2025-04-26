package lotto

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Assertions.assertFalse
import lotto.model.MatchResult
import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import java.io.PrintStream
import lotto.controller.LottoController
import lotto.model.WinningNumbers

class LottoTest {
    @Test
    fun `throws an exception when lotto numbers exceed six`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 6, 7))
        }
    }

    // TODO: Implement production code to pass the test
    // Note: input validation (count, duplicates, range) is already covered in ValidatorTest.
    @Test
    fun `throws an exception when lotto numbers contain duplicates`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 5))
        }
    }

    @Test
    fun `getValidWinningNumbers should re-prompt only the failing step`() {
        val inputs = listOf(
            "1,2,3,4,5",
            "1,2,3,4,5,6",
            "6",
            "7"
        ).joinToString("\n") + "\n"

        System.setIn(ByteArrayInputStream(inputs.toByteArray()))
        val outCapture = ByteArrayOutputStream()
        System.setOut(PrintStream(outCapture))

        val controller = LottoController()
        val method = controller.javaClass
            .getDeclaredMethod("getValidWinningNumbers")
            .also { it.isAccessible = true }

        val result = method.invoke(controller) as WinningNumbers

        assertEquals(listOf(1, 2, 3, 4, 5, 6), result.numbers)
        assertEquals(7, result.bonusNumber)

        val outputLines = outCapture.toString().lines()

        assertEquals(
            2,
            outputLines.count { it.contains("Please enter last week's winning numbers.") }
        )

        assertEquals(
            2,
            outputLines.count { it.contains("Please enter the bonus number.") }
        )
    }

    // TODO: Implement tests based on the added features
    @Test
    fun `getNumbers returns sorted list`() {
        val raw = listOf(45, 3, 20, 1, 44, 10)
        val lotto = Lotto(raw)
        assertEquals(listOf(1, 3, 10, 20, 44, 45), lotto.getNumbers())
    }

    @Test
    fun `countMatching returns correct count`() {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val winning = listOf(4, 5, 6, 7, 8, 9)
        assertEquals(3, lotto.countMatching(winning))
    }

    @Test
    fun `contains returns true for present number`() {
        val lotto = Lotto(listOf(7, 14, 21, 28, 35, 42))
        assertTrue(lotto.contains(28))
    }

    @Test
    fun `contains returns false for absent number`() {
        val lotto = Lotto(listOf(7, 14, 21, 28, 35, 42))
        assertFalse(lotto.contains(13))
    }

    @Test
    fun `calculateProfitRate returns correct percentage`() {
        val result = MatchResult(
            rankCounts = emptyMap(),
            totalPrize = 1500,
            purchaseAmount = 1000
        )
        assertEquals(150.0, result.calculateProfitRate())
    }

    @Test
    fun `calculateProfitRate returns zero when no winnings`() {
        val result = MatchResult(
            rankCounts = emptyMap(),
            totalPrize = 0,
            purchaseAmount = 8000
        )
        assertEquals(0.0, result.calculateProfitRate())
    }

    @Test
    fun `calculateProfitRate handles fractional percentages`() {
        val result = MatchResult(
            rankCounts = emptyMap(),
            totalPrize = 1000,
            purchaseAmount = 3000
        )
        assertEquals(33.33333333333333, result.calculateProfitRate(), 1e-6)
    }
}