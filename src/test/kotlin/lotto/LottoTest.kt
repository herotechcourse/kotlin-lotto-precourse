package lotto

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

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
    @MethodSource("makeInvalidNumbers")
    @DisplayName("[Exception] throws when lotto numbers are not between 1 and 45")
    fun `throws when lotto numbers are not in valid range`(numbers: List<Int>) {
        assertThrows<IllegalArgumentException> {
            Lotto(numbers)
        }
    }

    companion object {
        @JvmStatic
        private fun makeInvalidNumbers(): List<List<Int>> =
            listOf(
                listOf(1, 12, 13, 4, 15, 46), listOf(0, 20, 32, 40, 41, 42), listOf(-5, 15, 25, 35, 45, 1)
            )
    }
}
