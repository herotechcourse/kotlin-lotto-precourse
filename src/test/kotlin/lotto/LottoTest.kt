package lotto

import org.assertj.core.api.Assertions.assertThatIllegalArgumentException
import org.assertj.core.api.Assertions.assertThatNoException
import org.assertj.core.api.NotThrownAssert
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

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

    @Test
    fun `throws an exception when lotto numbers are in the wrong range`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(46, 2, 1, 4, 5, 7))
        }
    }

    @Test
    fun `valid lotto numbers`() {
        assertThatNoException().isThrownBy {
            Lotto(listOf(45, 2, 1, 3, 5, 7))
        }
    }

    // TODO: Implement tests based on the added features
}
