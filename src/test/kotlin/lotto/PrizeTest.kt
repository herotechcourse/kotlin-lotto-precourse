package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class PrizeTest {
    @Test
    fun `returns true when matchCount and bonus number are matched`() {
        val prize = Prize(matchCount = 5, isBonusRequired = true, amount = 30000000, printText = "5 Matches + Bonus Ball")
        val result = prize.isWinning(actualMatchCount = 5, isBonusMatched = true)
        assertThat(result).isTrue()
    }

    @Test
    fun `returns false when matchCount is not matched while bonus number is matched`() {
        val prize = Prize(matchCount = 5, isBonusRequired = true, amount = 30000000, printText = "5 Matches + Bonus Ball")
        val result = prize.isWinning(actualMatchCount = 3, isBonusMatched = true)
        assertThat(result).isFalse()
    }

    @Test
    fun `returns false when matchCount is matched while bonus number is not matched`() {
        val prize = Prize(matchCount = 5, isBonusRequired = true, amount = 30000000, printText = "5 Matches + Bonus Ball")
        val result = prize.isWinning(actualMatchCount = 5, isBonusMatched = false)
        assertThat(result).isFalse()
    }

    @Test
    fun `returns false when matchCount and bonus number are not matched`() {
        val prize = Prize(matchCount = 5, isBonusRequired = true, amount = 30000000, printText = "5 Matches + Bonus Ball")
        val result = prize.isWinning(actualMatchCount = 3, isBonusMatched = false)
        assertThat(result).isFalse()
    }
}