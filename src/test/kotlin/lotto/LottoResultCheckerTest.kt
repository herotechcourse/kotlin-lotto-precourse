package lotto

import lotto.domain.Lotto
import lotto.domain.Prize
import lotto.service.LottoResultChecker
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LottoResultCheckerTest {

    @Test
    fun `returns correct prize count map`() {
        val lottos = listOf(
            Lotto(listOf(1, 2, 3, 4, 5, 6)),  // 6 matches → FIRST
            Lotto(listOf(1, 2, 3, 4, 5, 7)),  // 5 matches + bonus 7 → SECOND
            Lotto(listOf(1, 2, 3, 4, 5, 8))   // 5 matches → THIRD
        )
        val winningNumbers = listOf(1, 2, 3, 4, 5, 6)
        val bonusNumber = 7

        val result = LottoResultChecker.checkResults(lottos, winningNumbers, bonusNumber)

        assertEquals(1, result[Prize.FIRST])
        assertEquals(1, result[Prize.SECOND])
        assertEquals(1, result[Prize.THIRD])
    }
}
