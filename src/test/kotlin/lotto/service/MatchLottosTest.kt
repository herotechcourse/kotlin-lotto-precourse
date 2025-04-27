package lotto.service

import lotto.Lotto
import lotto.domain.Rank
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertEquals

class MatchLottosTest {

    @Test
    fun `givenLottosAndWinningNumbers_whenMatchLottos_thenReturnCorrectRanks`() {
        // given
        val winningNumbers = listOf(1, 2, 3, 4, 5, 6)
        val bonusNumber = 7

        val lottos = listOf(                        // Expected
            Lotto(listOf(1, 2, 3, 4, 5, 6)),        // 1st
            Lotto(listOf(1, 2, 3, 4, 5, 7)),        // 2nd
            Lotto(listOf(1, 2, 3, 4, 5, 45)),       // 3rd
            Lotto(listOf(1, 2, 3, 4, 44, 45)),      // 4th
            Lotto(listOf(1, 2, 3, 43, 44, 45)),     // 5th
            Lotto(listOf(1, 2, 42, 43, 44, 45)),    // Miss(match: 2ea)
            Lotto(listOf(1, 41, 42, 43, 44, 45)),   // Miss(match: 1ea)
            Lotto(listOf(40, 41, 42, 43, 44, 45)),  // Miss(match: 0ea)
        )

        // when
        val result = matchLottos(lottos, winningNumbers, bonusNumber)

        // then
        val expected = listOf(
            Rank.FIRST,
            Rank.SECOND,
            Rank.THIRD,
            Rank.FOURTH,
            Rank.FIFTH,
            Rank.MISS,
            Rank.MISS,
            Rank.MISS
        )
        assertEquals(expected, result)
    }
}