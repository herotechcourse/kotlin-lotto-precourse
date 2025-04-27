package lotto

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class WinningLottoTest {
    @ParameterizedTest
    @ValueSource(ints = [1, 2, 3, 4, 5, 6])
    fun `throws an exception when winning numbers contains bonus number`(bonusNumber: Int) {
        assertThrows<IllegalArgumentException> {
            WinningLotto(Lotto(listOf(1, 2, 3, 4, 5, 6)), bonusNumber)
        }
    }

    @Test
    fun `compare each ticket with the winning numbers and bonus number`() {
        val lottos = listOf(
            Lotto(listOf(1, 2, 3, 4, 5, 6)),
            Lotto(listOf(1, 2, 3, 4, 5, 7)),
            Lotto(listOf(1, 2, 3, 4, 5, 8)),
            Lotto(listOf(1, 2, 3, 4, 7, 8)),
            Lotto(listOf(1, 2, 3, 7, 8, 9)),
            Lotto(listOf(1, 2, 7, 8, 9, 10))
        )
        val winningLotto = WinningLotto(Lotto(listOf(1, 2, 3, 4, 5, 6)), 7)

        val lottoRanks = listOf(
            LottoRank.FIRST,
            LottoRank.SECOND,
            LottoRank.THIRD,
            LottoRank.FOURTH,
            LottoRank.FIFTH,
            LottoRank.NONE
        )
        assertEquals(lottoRanks, winningLotto.match(lottos))
    }
}
