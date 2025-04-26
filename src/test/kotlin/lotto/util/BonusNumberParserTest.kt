package lotto.util

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class BonusNumberParserTest {
    private val bonusNumberParser = BonusNumberParser()
    private val sampleWinningNumbers = listOf(1, 2, 3, 4, 5, 6)

    @Test
    fun `throws an exception when input is empty`() {
        assertThrows<IllegalArgumentException> {
            bonusNumberParser.parse("", sampleWinningNumbers)
        }
    }

    @Test
    fun `throws an exception when input is not a number`() {
        assertThrows<IllegalArgumentException> {
            bonusNumberParser.parse("7j", sampleWinningNumbers)
        }
    }

    @Test
    fun `throws an exception when input has trailing whitespace`() {
        assertThrows<IllegalArgumentException> {
            bonusNumberParser.parse("7 ", sampleWinningNumbers)
        }

        assertThrows<IllegalArgumentException> {
            bonusNumberParser.parse(" 7", sampleWinningNumbers)
        }
    }

    @Test
    fun `throws an exception when bonus number is out of range`() {
        assertThrows<IllegalArgumentException> {
            bonusNumberParser.parse("0", sampleWinningNumbers)
        }

        assertThrows<IllegalArgumentException> {
            bonusNumberParser.parse("46", sampleWinningNumbers)
        }
    }

    @Test
    fun `throws an exception when bonus number is in winning numbers`() {
        assertThrows<IllegalArgumentException> {
            bonusNumberParser.parse("1", sampleWinningNumbers)
        }

        assertThrows<IllegalArgumentException> {
            bonusNumberParser.parse("6", sampleWinningNumbers)
        }
    }

    @Test
    fun `successfully parses valid bonus number`() {
        val result = bonusNumberParser.parse("7", sampleWinningNumbers)
        assert(result == 7)
    }
}