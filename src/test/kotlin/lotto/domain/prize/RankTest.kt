package lotto.domain.prize

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class RankTest {
    @Nested
    inner class RankFindTest {
        @Test
        @DisplayName("[Success] when matchCount is 5 with bonus, rank is 2nd")
        fun `test finding second rank`() {
            val rank = Rank.find(5, true)
            Assertions.assertEquals(rank, Rank.SECOND)
        }

        @Test
        @DisplayName("[Success] when matchCount is 5 without bonus, rank is 3rd")
        fun `test finding third rank`() {
            val rank = Rank.find(5, false)
            Assertions.assertEquals(rank, Rank.THIRD)
        }

        @ParameterizedTest
        @ValueSource(ints = [1, 2, 0])
        fun `when matchCount doesn't exceed 3, rank is none`(matchCount: Int) {
            val rank = Rank.find(matchCount, false)
            Assertions.assertEquals(Rank.NONE, rank)
        }
    }
}