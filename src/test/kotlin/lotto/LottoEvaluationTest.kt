package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoEvaluationTest {
    @Test
    fun `returns 5th prize when 3 numbers are matched`() {
        val winningNumbers = listOf(1, 2, 3, 4, 5, 6)
        val bonusNumber = 7
        val evaluation = LottoEvaluation(winningNumbers, bonusNumber)
        val lottos = listOf(
            Lotto(listOf(1, 2, 3, 8, 9, 10))
        )
        val result = evaluation.evaluate(lottos, 1000)
        assertThat(result.getMatchCounts()).containsExactly(1, 0, 0, 0, 0)
    }

    @Test
    fun `returns 4th prize when 4 numbers are matched`() {
        val winningNumbers = listOf(1, 2, 3, 4, 5, 6)
        val bonusNumber = 7
        val evaluation = LottoEvaluation(winningNumbers, bonusNumber)
        val lottos = listOf(
            Lotto(listOf(1, 2, 3, 4, 8, 9))
        )
        val result = evaluation.evaluate(lottos, 1000)
        assertThat(result.getMatchCounts()).containsExactly(0, 1, 0, 0, 0)
    }

    @Test
    fun `returns 3rd prize when 5 numbers are matched`() {
        val winningNumbers = listOf(1, 2, 3, 4, 5, 6)
        val bonusNumber = 7
        val evaluation = LottoEvaluation(winningNumbers, bonusNumber)
        val lottos = listOf(
            Lotto(listOf(1, 2, 3, 4, 5, 8))
        )
        val result = evaluation.evaluate(lottos, 1000)
        assertThat(result.getMatchCounts()).containsExactly(0, 0, 1, 0, 0)
    }

    @Test
    fun `returns 2nd prize when 5 numbers and bonus number are mathched`() {
        val winningNumbers = listOf(1, 2, 3, 4, 5, 6)
        val bonusNumber = 7
        val evaluation = LottoEvaluation(winningNumbers, bonusNumber)
        val lottos = listOf(
            Lotto(listOf(1, 2, 3, 4, 5, 7))
        )
        val result = evaluation.evaluate(lottos, 1000)
        assertThat(result.getMatchCounts()).containsExactly(0, 0, 0, 1, 0)
    }

    @Test
    fun `returns 1st prize when 6 numbers are matched`() {
        val winningNumbers = listOf(1, 2, 3, 4, 5, 6)
        val bonusNumber = 7
        val evaluation = LottoEvaluation(winningNumbers, bonusNumber)
        val lottos = listOf(
            Lotto(listOf(1, 2, 3, 4, 5, 6)) // 6개 일치
        )
        val result = evaluation.evaluate(lottos, 1000)
        assertThat(result.getMatchCounts()).containsExactly(0, 0, 0, 0, 1)
    }

    @Test
    fun `returns 0 when nothing is matched`() {
        val winningNumbers = listOf(1, 2, 3, 4, 5, 6)
        val bonusNumber = 7
        val evaluation = LottoEvaluation(winningNumbers, bonusNumber)
        val lottos = listOf(
            Lotto(listOf(8, 9, 10, 11, 12, 13))
        )
        val result = evaluation.evaluate(lottos, 1000)
        assertThat(result.getMatchCounts()).containsExactly(0, 0, 0, 0, 0)
    }
}