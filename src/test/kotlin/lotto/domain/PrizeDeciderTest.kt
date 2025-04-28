package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class PrizeDeciderTest {

    @Test
    fun `returns FIRST prize when 6 numbers match`() {
        val result = LottoMatchResult(matchCount = 6, bonusMatched = false)
        val prize = PrizeDecider.decidePrize(result)
        assertThat(prize).isEqualTo(Prize.FIRST)
    }

    @Test
    fun `returns SECOND prize when 5 numbers match and bonus is matched`() {
        val result = LottoMatchResult(matchCount = 5, bonusMatched = true)
        val prize = PrizeDecider.decidePrize(result)
        assertThat(prize).isEqualTo(Prize.SECOND)
    }

    @Test
    fun `returns THIRD prize when 5 numbers match and bonus is not matched`() {
        val result = LottoMatchResult(matchCount = 5, bonusMatched = false)
        val prize = PrizeDecider.decidePrize(result)
        assertThat(prize).isEqualTo(Prize.THIRD)
    }

    @Test
    fun `returns FOURTH prize when 4 numbers match`() {
        val result = LottoMatchResult(matchCount = 4, bonusMatched = false)
        val prize = PrizeDecider.decidePrize(result)
        assertThat(prize).isEqualTo(Prize.FOURTH)
    }

    @Test
    fun `returns FIFTH prize when 3 numbers match`() {
        val result = LottoMatchResult(matchCount = 3, bonusMatched = false)
        val prize = PrizeDecider.decidePrize(result)
        assertThat(prize).isEqualTo(Prize.FIFTH)
    }

    @Test
    fun `returns NONE prize when less than 3 numbers match`() {
        val result1 = LottoMatchResult(matchCount = 2, bonusMatched = false)
        val result2 = LottoMatchResult(matchCount = 1, bonusMatched = false)
        val result3 = LottoMatchResult(matchCount = 0, bonusMatched = false)

        assertThat(PrizeDecider.decidePrize(result1)).isEqualTo(Prize.NONE)
        assertThat(PrizeDecider.decidePrize(result2)).isEqualTo(Prize.NONE)
        assertThat(PrizeDecider.decidePrize(result3)).isEqualTo(Prize.NONE)
    }
}
