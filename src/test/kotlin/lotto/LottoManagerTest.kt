package lotto.domain

import lotto.Lotto
import lotto.Rank
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LottoManagerTest {

    @Test
    fun `matchLottos correctly counts ranks`() {
        val lotto1 = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val lotto2 = Lotto(listOf(1, 2, 3, 4, 5, 7))
        val lotto3 = Lotto(listOf(1, 2, 3, 4, 7, 8))

        val lottos = listOf(lotto1, lotto2, lotto3)

        val winningNumbers = listOf(1, 2, 3, 4, 5, 6)
        val bonusNumber = 7

        val winningLotto = WinningLotto(winningNumbers, bonusNumber)
        val lottoManager = LottoManager(lottos)

        val result = lottoManager.matchLottos(winningLotto)
        println(result)


        assertEquals(1, result[Rank.FIRST])
        assertEquals(1, result[Rank.SECOND])
        assertEquals(1, result[Rank.FOURTH])
    }
}
