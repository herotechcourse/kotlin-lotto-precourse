package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class RankTest {

    @ParameterizedTest
    @CsvSource(
        "6, false, FIRST",
        "5, true, SECOND",
        "5, false, THIRD",
        "4, false, FOURTH",
        "3, false, FIFTH",
        "2, false, NONE"
    )
    fun `returns correct Rank based on match count and bonus`(matchCount: Int, bonusMatch: Boolean, expected: Rank) {
        // Act
        val result = Rank.of(matchCount, bonusMatch)

        // Assert
        assertThat(result).isEqualTo(expected)
    }

    @ParameterizedTest
    @CsvSource(
        "6, FIRST",
        "4, FOURTH",
        "3, FIFTH"
    )
    fun `returns correct Rank regardless of bonus when bonus is not relevant`(matchCount: Int, expected: Rank) {
        // Act
        val result = Rank.of(matchCount, bonusMatch = true)

        // Assert
        assertThat(result).isEqualTo(expected)
    }

    @ParameterizedTest
    @CsvSource(
        "2, true",
        "1, false",
        "0, true"
    )
    fun `returns NONE when fewer than 3 numbers match`(matchCount: Int, bonusMatch: Boolean) {
        // Act
        val result = Rank.of(matchCount, bonusMatch)

        // Assert
        assertThat(result).isEqualTo(Rank.NONE)
    }

}
