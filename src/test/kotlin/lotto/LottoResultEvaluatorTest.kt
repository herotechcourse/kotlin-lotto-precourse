package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class LottoResultEvaluatorTest {

    private val evaluator = LottoResultEvaluator()
    private val winning   = listOf(1, 2, 3, 4, 5, 6)
    private val bonus     = 7

    @Test @DisplayName("6 matches → FIRST")
    fun firstRank() {
        val ticket = Lotto(listOf(1,2,3,4,5,6))
        assertThat(evaluator.evaluate(ticket, winning, bonus))
            .isEqualTo(LottoRank.FIRST)
    }

    @Test @DisplayName("5 matches + bonus → SECOND")
    fun secondRank() {
        val ticket = Lotto(listOf(1,2,3,4,5,7))
        assertThat(evaluator.evaluate(ticket, winning, bonus))
            .isEqualTo(LottoRank.SECOND)
    }

    @Test @DisplayName("others…")
    fun otherRanks() {

    }
}
