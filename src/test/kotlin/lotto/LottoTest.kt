package lotto
import lotto.views.InputView
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.assertj.core.api.Assertions.assertThat
import camp.nextstep.edu.missionutils.test.NsTest

class LottoTest : NsTest() {
    @Test
    fun `throws an exception when lotto numbers exceed six`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 6, 7))
        }
    }

    // TODO: Implement production code to pass the test
    @Test
    fun `throws an exception when lotto numbers contain duplicates`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 5))
        }
    }

    // TODO: Implement tests based on the added features
    @Test
    fun `throws an exception when purchase amount is not divisible by 1000`() {
        assertThrows<IllegalArgumentException> {
            InputView().validateTickets("1500")
        }
    }

    @Test
    fun `throws an exception when purchase amount is not a number`() {
        assertThrows<IllegalArgumentException> {
            InputView().validateTickets("abc")
        }
    }

    @Test
    fun `calculates the correct number of tickets for valid purchase amount`() {
        val inputView = InputView()
        val tickets = inputView.validateTickets("8000")
        assertThat(tickets).isEqualTo(8000)
    }

    @Test
    fun `throws an exception when winning numbers are not six`() {
        assertThrows<IllegalArgumentException> {
            InputView().validateWinningNumber("1,2,3,4,5")
        }
    }

    @Test
    fun `throws an exception when winning numbers contain duplicates`() {
        assertThrows<IllegalArgumentException> {
            InputView().validateWinningNumber("1,2,3,4,5,5")
        }
    }

    @Test
    fun `throws an exception when winning numbers are out of range`() {
        assertThrows<IllegalArgumentException> {
            InputView().validateWinningNumber("1,2,3,4,5,46")
        }
    }

    @Test
    fun `accepts valid winning numbers`() {
        val inputView = InputView()
        val winningNumbers = inputView.validateWinningNumber("1,2,3,4,5,6")
        assertThat(winningNumbers).isEqualTo(listOf(1, 2, 3, 4, 5, 6))
    }

    @Test
    fun `throws an exception when bonus number is not a number`() {
        assertThrows<IllegalArgumentException> {
            InputView().validateSingleNumber("abc", listOf(1, 2, 3, 4, 5, 6))
        }
    }

    @Test
    fun `throws an exception when bonus number is in winning numbers`() {
        assertThrows<IllegalArgumentException> {
            InputView().validateSingleNumber("5", listOf(1, 2, 3, 4, 5, 6))
        }
    }

    @Test
    fun `throws an exception when bonus number is out of range`() {
        assertThrows<IllegalArgumentException> {
            InputView().validateSingleNumber("46", listOf(1, 2, 3, 4, 5, 6))
        }
    }

    @Test
    fun `accepts valid bonus number`() {
        val inputView = InputView()
        val bonusNumber = inputView.validateSingleNumber("7", listOf(1, 2, 3, 4, 5, 6))
        assertThat(bonusNumber).isEqualTo(7)
    }

    @Test
    fun `correctly identifies prize tiers`() {
        val tickets = listOf(
            listOf(1, 2, 3, 4, 5, 6),
            listOf(1, 2, 3, 4, 5, 7),
            listOf(1, 2, 3, 4, 5, 8),
            listOf(1, 2, 3, 4, 10, 11),
            listOf(1, 2, 3, 10, 11, 12),
            listOf(10, 11, 12, 13, 14, 15)
        )
        val winningNumbers = listOf(1, 2, 3, 4, 5, 6)
        val luckyNumber = 7

        val results = checkWinningTickets(tickets, winningNumbers, luckyNumber)
        assertThat(results).containsExactly(
            LottoResults.FIRST_PRIZE,
            LottoResults.SECOND_PRIZE,
            LottoResults.THIRD_PRIZE,
            LottoResults.FOURTH_PRIZE,
            LottoResults.FIFTH_PRIZE,
            null
        )
    }

    @Test
    fun `correctly counts the number of tickets in each prize tier`() {
        val results = listOf(
            LottoResults.FIRST_PRIZE,
            LottoResults.SECOND_PRIZE,
            LottoResults.THIRD_PRIZE,
            LottoResults.FOURTH_PRIZE,
            LottoResults.FIFTH_PRIZE,
            LottoResults.FIFTH_PRIZE
        )
        val resultCounts = calculateResultCounts(results)
        assertThat(resultCounts[LottoResults.FIRST_PRIZE]).isEqualTo(1)
        assertThat(resultCounts[LottoResults.SECOND_PRIZE]).isEqualTo(1)
        assertThat(resultCounts[LottoResults.THIRD_PRIZE]).isEqualTo(1)
        assertThat(resultCounts[LottoResults.FOURTH_PRIZE]).isEqualTo(1)
        assertThat(resultCounts[LottoResults.FIFTH_PRIZE]).isEqualTo(2)
    }

    override fun runMain() {
        main()
    }

    @Test
    fun `accepts valid lotto numbers`() {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        assertThat(lotto).isNotNull
    }

}
