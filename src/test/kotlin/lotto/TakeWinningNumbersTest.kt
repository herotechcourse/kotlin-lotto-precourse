package lotto

import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class TakeWinningNumbersTest : NsTest() {

    override fun runMain() {
    }

    @Test
    fun `check that it demands numeric input for winning numbers and retries`() {
        val invalidWinningNumbersInput = "1,2,3,4,5,xx"
        val validWinningNumbersInput = "1,2,3,4,5,6"
        val bonusNumbersInput = "7"

        val inputSequence = listOf(invalidWinningNumbersInput, validWinningNumbersInput).iterator()

        val takeWinningNumbers = TakeWinningNumbers(
            testWinningNumbersProvider = { inputSequence.next() },
            testBonusNumberProvider = { bonusNumbersInput }
        )
        run {
            val result = takeWinningNumbers.inputSixNumbersAndBonus()
            assertThat(result).isEqualTo(mutableListOf(1, 2, 3, 4, 5, 6, 7))
            assertThat(output()).contains("[ERROR] Input must be fully numeric with the exception of separating commas.")
        }
    }

    @Test
    fun `check that it demands the correct amount of winning numbers and retries`() {
        val invalidWinningNumbersInput = "1,2,3,4,5,8,9"
        val validWinningNumbersInput = "1,2,3,4,5,6"
        val bonusNumbersInput = "7"

        val inputSequence = listOf(invalidWinningNumbersInput, validWinningNumbersInput).iterator()

        val takeWinningNumbers = TakeWinningNumbers(
            testWinningNumbersProvider = { inputSequence.next() },
            testBonusNumberProvider = { bonusNumbersInput }
        )
        run {
            val result = takeWinningNumbers.inputSixNumbersAndBonus()
            assertThat(result).isEqualTo(mutableListOf(1, 2, 3, 4, 5, 6, 7))
            assertThat(output()).contains("[ERROR] There must be 6 winning numbers.")
        }
    }


    @Test
    fun `check that it warns about the winning numbers being out of range and retries`() {
        val invalidWinningNumbersInput = "1,2,3,4,5,66"
        val validWinningNumbersInput = "1,2,3,4,5,6"
        val bonusNumbersInput = "7"

        val inputSequence = listOf(invalidWinningNumbersInput, validWinningNumbersInput).iterator()

        val takeWinningNumbers = TakeWinningNumbers(
            testWinningNumbersProvider = { inputSequence.next() },
            testBonusNumberProvider = { bonusNumbersInput }
        )
        run {
            val result = takeWinningNumbers.inputSixNumbersAndBonus()
            assertThat(result).isEqualTo(mutableListOf(1, 2, 3, 4, 5, 6, 7))
            assertThat(output()).contains("[ERROR] Every winning number must be from 1 to 45.")
        }
    }


    @Test
    fun `check that it returns the correct list of winning and bonus numbers`() {
        val winningNumbersInput = "1,2,3,4,5,6"
        val bonusNumbersInput = "7"
        val takeWinningNumbers = TakeWinningNumbers(
            testWinningNumbersProvider = { winningNumbersInput },
            testBonusNumberProvider = { bonusNumbersInput }
        )
        val result = takeWinningNumbers.inputSixNumbersAndBonus()
        assertThat(result).isEqualTo(mutableListOf(1, 2, 3, 4, 5, 6, 7))
    }

    @Test
    fun `check that it demands numeric input for the bonus number and retries`() {
        val winningNumbersInput = "1,2,3,4,5,6"
        val invalidBonusNumbersInput = "z"
        val validBonusNumbersInput = "7"

        val inputSequence = listOf(invalidBonusNumbersInput, validBonusNumbersInput).iterator()

        val takeWinningNumbers = TakeWinningNumbers(
            testWinningNumbersProvider = { winningNumbersInput },
            testBonusNumberProvider = { inputSequence.next() }
        )
        run {
            val result = takeWinningNumbers.inputSixNumbersAndBonus()
            assertThat(result).isEqualTo(mutableListOf(1, 2, 3, 4, 5, 6, 7))
            assertThat(output()).contains("[ERROR] Input must be fully numeric.")
        }
    }

    @Test
    fun `check that it bonus number different to all winning numbers and retries`() {
        val winningNumbersInput = "1,2,3,4,5,6"
        val invalidBonusNumbersInput = "2"
        val validBonusNumbersInput = "7"

        val inputSequence = listOf(invalidBonusNumbersInput, validBonusNumbersInput).iterator()

        val takeWinningNumbers = TakeWinningNumbers(
            testWinningNumbersProvider = { winningNumbersInput },
            testBonusNumberProvider = { inputSequence.next() }
        )
        run {
            val result = takeWinningNumbers.inputSixNumbersAndBonus()
            assertThat(result).isEqualTo(mutableListOf(1, 2, 3, 4, 5, 6, 7))
            assertThat(output()).contains("[ERROR] The bonus number can't be the same as any of the winning numbers.")
        }
    }
    @Test
    fun `check that it bonus number is within the desired range and retry`() {
        val winningNumbersInput = "1,2,3,4,5,6"
        val invalidBonusNumbersInput = "200"
        val validBonusNumbersInput = "7"

        val inputSequence = listOf(invalidBonusNumbersInput, validBonusNumbersInput).iterator()

        val takeWinningNumbers = TakeWinningNumbers(
            testWinningNumbersProvider = { winningNumbersInput },
            testBonusNumberProvider = { inputSequence.next() }
        )
        run {
            val result = takeWinningNumbers.inputSixNumbersAndBonus()
            assertThat(result).isEqualTo(mutableListOf(1, 2, 3, 4, 5, 6, 7))
            assertThat(output()).contains("[ERROR] The bonus number must be from 1 to 45.")
        }
    }
}