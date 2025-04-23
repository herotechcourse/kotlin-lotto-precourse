package lotto

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import org.junit.jupiter.params.provider.Arguments
import java.util.stream.Stream

class LottoTest {
    private val winningNumbers: Lotto = Lotto(listOf(1,2,3,4,5,6))

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

    @Test
    fun `throws an exception when lotto numbers are below the range`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(-1, 2, 3, 4, 5, 15))
        }
    }

    @Test
    fun `throws an exception when lotto numbers are above the range`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 105))
        }
    }

    @Test
    fun `throws an exception when lotto numbers are below and above the range`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(0, 2, 3, 4, 55, 5))
        }
    }

    companion object {
        @JvmStatic
        fun matchTestCases(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(6, Lotto(listOf(1, 2, 3, 4, 5, 6))),
                Arguments.of(5, Lotto(listOf(1, 2, 3, 4, 5, 7))),
                Arguments.of(4, Lotto(listOf(1, 2, 3, 4, 7, 8))),
                Arguments.of(3, Lotto(listOf(1, 2, 3, 7, 8, 9))),
                Arguments.of(2, Lotto(listOf(1, 2, 7, 8, 9, 10))),
                Arguments.of(1, Lotto(listOf(1, 7, 8, 9, 10, 11))),
                Arguments.of(0, Lotto(listOf(7, 8, 9, 10, 11, 12)))
            )
        }
    }

    @ParameterizedTest(name = "Compare Lotto with {0} matches")
    @MethodSource("matchTestCases")
    fun `Compare lotto with varying matches`(expectedMatchCount: Int, user: Lotto) {
        assertEquals(expectedMatchCount, user.compare(winningNumbers))
    }



}
