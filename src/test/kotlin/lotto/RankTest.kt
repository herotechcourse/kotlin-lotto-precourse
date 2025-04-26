package lotto

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import org.junit.jupiter.params.provider.ValueSource
import java.util.stream.Stream

class RankTest {

    companion object {
        @JvmStatic
        fun rankTestCases(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(6, false, Rank.FIRST),
                Arguments.of(5, true, Rank.SECOND),
                Arguments.of(5, false, Rank.THIRD),
                Arguments.of(4, false, Rank.FOURTH),
                Arguments.of(3, false, Rank.FIFTH),
                Arguments.of(2, false, Rank.NONE),
                Arguments.of(1, false, Rank.NONE),
                Arguments.of(0, false, Rank.NONE)
            )
        }

        @JvmStatic
        fun invalidMatchCountCases(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(-1, false),
                Arguments.of(7, false),
                Arguments.of(100, false)
            )
        }
    }

    @ParameterizedTest
    @MethodSource("rankTestCases")
    fun `should return correct rank for given matches and bonus`(
        matchCount: Int,
        hasBonus: Boolean,
        expectedRank: Rank
    ) {
        val actualRank = Rank.from(matchCount, hasBonus)
        assertEquals(expectedRank, actualRank)
    }

    @ParameterizedTest
    @MethodSource("invalidMatchCountCases")
    fun `should return NONE for invalid match counts`(
        matchCount: Int,
        hasBonus: Boolean
    ) {
        val rank = Rank.from(matchCount, hasBonus)
        assertEquals(Rank.NONE, rank, "Invalid match counts should return NONE")
    }
}
