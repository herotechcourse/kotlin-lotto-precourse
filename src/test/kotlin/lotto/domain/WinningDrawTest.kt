package lotto.domain

import lotto.Lotto
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test

class WinningDrawTest {

    @Test
    fun `should throw exception if bonus number is in winning numbers`() {
        val winningNumbers = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val bonusNumber = 6
        assertThatThrownBy {
            WinningDraw(winningNumbers, bonusNumber)
        }.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("[ERROR] Bonus number must not be among winning numbers.")
    }

    @Test
    fun `should not throw exception if bonus number is separate`() {
        val winningNumbers = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val bonusNumber = 7
        val winningDraw = WinningDraw(winningNumbers, bonusNumber)
        assertThat(winningDraw).isNotNull()
    }

    @Test
    fun `match should correctly return rank based on ticket`() {
        val winningDraw = WinningDraw(
            Lotto(listOf(1, 2, 3, 4, 5, 6)),
            7,
        )
        val ticketSix = Lotto(listOf(1, 2, 3, 4, 5, 6))
        assertThat(winningDraw.match(ticketSix)).isEqualTo(LottoRank.MATCH_SIX)

        val ticketBonus = Lotto(listOf(1, 2, 3, 4, 5, 7))
        assertThat(winningDraw.match(ticketBonus)).isEqualTo(LottoRank.MATCH_BONUS)

        val ticketFive = Lotto(listOf(1, 2, 3, 4, 5, 10))
        assertThat(winningDraw.match(ticketFive)).isEqualTo(LottoRank.MATCH_FIVE)

        val ticketFour = Lotto(listOf(1, 2, 3, 4, 10, 11))
        assertThat(winningDraw.match(ticketFour)).isEqualTo(LottoRank.MATCH_FOUR)

        val ticketThree = Lotto(listOf(1, 2, 3, 10, 11, 12))
        assertThat(winningDraw.match(ticketThree)).isEqualTo(LottoRank.MATCH_THREE)

        val ticketNone = Lotto(listOf(10, 11, 12, 13, 14, 15))
        assertThat(winningDraw.match(ticketNone)).isNull()
    }
}
