package lotto

import lotto.domain.BonusNumber
import lotto.domain.WinningNumbers
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.api.assertDoesNotThrow

class BonusNumberTest {

    private val winningNumbers = WinningNumbers("1,2,3,4,5,6")

    @Test
    fun `should not throw for valid bonus number`() {
        assertDoesNotThrow {
            BonusNumber("7", winningNumbers)
        }
    }

    @Test
    fun `should throw for duplicated bonus number`() {
        assertThrows<IllegalArgumentException> {
            BonusNumber("6", winningNumbers)
        }
    }

    @Test
    fun `should throw for out of range bonus number (above 45)`() {
        assertThrows<IllegalArgumentException> {
            BonusNumber("77", winningNumbers)
        }
    }

    @Test
    fun `should throw for out of range bonus number (below 1)`() {
        assertThrows<IllegalArgumentException> {
            BonusNumber("0", winningNumbers)
        }
    }

     @Test
    fun `should throw for non-numeric bonus number`() {
        assertThrows<IllegalArgumentException> {
            BonusNumber("abc", winningNumbers)
        }
    }
}