package lotto

import java.util.stream.Stream

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import org.junit.jupiter.params.provider.Arguments

class LottoTest {
    @Test
    fun `throws an exception when lotto numbers exceed six`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 6, 7))
        }
    }

    @Test
    fun `throws an exception when lotto numbers contain duplicates`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 5))
        }
    }

    @ParameterizedTest
    @MethodSource("provideArgumentsForLottoPrizeTest")
    fun `lotto prize test`(numbers: List<Int>, winningNumbers: List<Int>, bonusNumbers: List<Int>, expectedPrize: Prize) {
        assertThat(Lotto(numbers).prize(winningNumbers, bonusNumbers)).isEqualTo(expectedPrize)
    }

    companion object {
        @JvmStatic
        private fun provideArgumentsForLottoPrizeTest() : Stream<Arguments> {
            return Stream.of(
                Arguments.of(
                    listOf(1, 2, 3, 4, 5, 6),
                    listOf(1, 2, 3, 4, 5, 6),
                    listOf(7),
                    Prize.RANK1
                ),
                Arguments.of(
                    listOf(1, 2, 3, 4, 5, 7),
                    listOf(1, 2, 3, 4, 5, 6),
                    listOf(7),
                    Prize.RANK2
                ),
                Arguments.of(
                    listOf(1, 2, 3, 4, 5, 8),
                    listOf(1, 2, 3, 4, 5, 6),
                    listOf(9),
                    Prize.RANK3
                ),
                Arguments.of(
                    listOf(1, 2, 3, 4, 15, 8),
                    listOf(1, 2, 3, 4, 5, 6),
                    listOf(7),
                    Prize.RANK4
                ),
                Arguments.of(
                    listOf(1, 2, 33, 4, 15, 8),
                    listOf(1, 2, 3, 4, 5, 6),
                    listOf(7),
                    Prize.RANK5
                ),
            )
        }
    }
}
