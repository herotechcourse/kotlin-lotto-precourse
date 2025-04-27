package lotto

import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.assertThrows

class WinningLottoTest {
    @Test
    fun `should create WinningLotto with valid bonus number`() {
        val winningLotto = WinningLotto(
            Lotto(listOf(1, 2, 3, 4, 5, 6)),
            bonusNumber = 7
        )

        assertThat(winningLotto).isNotNull
    }

    @Test
    fun `should throw error when bonus number is out of range`() {
        assertThrows<IllegalArgumentException> {
            WinningLotto(
                Lotto(listOf(1, 2, 3, 4, 5, 6)),
                bonusNumber = 50
            )
        }
    }

    @Test
    fun `should return FIRST rank when 6 numbers match`() {
        val winningLotto = WinningLotto(
            Lotto(listOf(1, 2, 3, 4, 5, 6)),
            bonusNumber = 7
        )
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))

        val rank = winningLotto.match(lotto)

        assertThat(rank).isEqualTo(LottoRank.FIRST)
    }

    @Test
    fun `should return SECOND rank when 5 numbers match plus bonus`() {
        val winningLotto = WinningLotto(
            Lotto(listOf(1, 2, 3, 4, 5, 6)),
            bonusNumber = 7
        )
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 7))

        val rank = winningLotto.match(lotto)

        assertThat(rank).isEqualTo(LottoRank.SECOND)
    }

    @Test
    fun `should return THIRD rank when 5 numbers match without bonus`() {
        val winningLotto = WinningLotto(
            Lotto(listOf(1, 2, 3, 4, 5, 6)),
            bonusNumber = 7
        )
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 8))

        val rank = winningLotto.match(lotto)

        assertThat(rank).isEqualTo(LottoRank.THIRD)
    }

    @Test
    fun `should return NONE when less than 3 numbers match`() {
        val winningLotto = WinningLotto(
            Lotto(listOf(1, 2, 3, 4, 5, 6)),
            bonusNumber = 7
        )
        val lotto = Lotto(listOf(10, 11, 12, 13, 14, 15))

        val rank = winningLotto.match(lotto)

        assertThat(rank).isEqualTo(LottoRank.NONE)
    }
}