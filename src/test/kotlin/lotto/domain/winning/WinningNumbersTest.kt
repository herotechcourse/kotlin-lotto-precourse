package lotto.domain.winning

import lotto.Lotto
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

class WinningNumbersTest {
    @ParameterizedTest
    @MethodSource("makeNumbersWithWrongSize")
    fun `throws an exception when winning numbers exceed six`(numbers: String) {
        assertThrows<IllegalArgumentException> {
            WinningNumbers.from(numbers)
        }
    }

    @ParameterizedTest
    @MethodSource("makeDuplicatedNumbers")
    fun `throws an exception when winning numbers are duplicated`(numbers: String) {
        assertThrows<IllegalArgumentException> {
            WinningNumbers.from(numbers)
        }
    }

    @ParameterizedTest
    @MethodSource("makeInvalidNumbers")
    @DisplayName("[Exception] throws when winning numbers are not between 1 and 45")
    fun `throws an exception when winning numbers are not valid range`(numbers: String) {
        assertThrows<IllegalArgumentException> {
            WinningNumbers.from(numbers)
        }
    }

    @ParameterizedTest
    @MethodSource("giveNumbersAndExpectedMatchCount")
    @DisplayName("[Success] winning numbers object can find matching count with lotto numbers")
    fun `find matching count with lotto numbers safely`(lottoAndWinning: Pair<Lotto, WinningNumbers>, matchCount: Int) {
        val realMatchCount = lottoAndWinning.second.countMatches(lottoAndWinning.first)
        Assertions.assertThat(realMatchCount).isEqualTo(matchCount)
    }

    companion object {
        @JvmStatic
        private fun makeInvalidNumbers(): List<String> =
            listOf("1, 2, 3, 4, 5, 46", "0, 20, 30, 40, 41, 42", "-5, 15, 25, 35, 45, 1")

        @JvmStatic
        private fun makeDuplicatedNumbers(): List<String> =
            listOf("1, 2, 3, 4, 5, 5", "20, 20, 30, 40, 41, 42", "15, 15, 25, 35, 45, 1")

        @JvmStatic
        private fun makeNumbersWithWrongSize(): List<String> =
            listOf("1, 2, 3, 4, 5, 6, 7", "20, 30, 40, 41, 42", "25, 35, 45, 1")

        @JvmStatic
        fun giveNumbersAndExpectedMatchCount(): List<Arguments> {
            return listOf(
                Arguments.of(
                    Lotto(listOf(1, 2, 3, 4, 5, 6)) to WinningNumbers.from("1,2,3,10,20,30"), 3
                ),
                Arguments.of(
                    Lotto(listOf(7, 8, 9, 10, 11, 12)) to WinningNumbers.from("1,2,3,10,20,30"), 1
                )
            )
        }
    }
}