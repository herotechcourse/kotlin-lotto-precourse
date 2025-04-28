package lotto.domain.service

import lotto.domain.model.Money
import lotto.domain.model.Rank
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class StatisticsTest {

    private val statistics = Statistics()

    @Test
    @DisplayName("Return rate is correctly calculated when there are prize winnings")
    fun calculateTotalReturnRate_withWinnings_returnsCorrectRate() {
        // given
        val money = Money(8000)
        val winResult = WinResult().apply {
            updateResult(Rank.FIFTH)
        }

        // when
        val returnRate = statistics.calculateTotalReturnRate(money, winResult)

        // then
        assertEquals(62.5, returnRate)
    }

    @Test
    @DisplayName("Return rate is 0.0 when there are no winnings")
    fun calculateTotalReturnRate_noWinnings_returnsZeroRate() {
        // given
        val money = Money(8000)
        val winResult = WinResult()

        // when
        val returnRate = statistics.calculateTotalReturnRate(money, winResult)

        // then
        assertEquals(0.0, returnRate)
    }
}
