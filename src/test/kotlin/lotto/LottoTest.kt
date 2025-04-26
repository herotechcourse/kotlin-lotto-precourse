package lotto

import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class LottoTest {
    @Test
    fun `throws an exception when lotto numbers exceed six`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 6, 7))
        }
    }

    // TODO: Implement production code to pass the test
    @Test
    fun `throws an exception when lotto numbers contain duplicates`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 5))
        }
    }

    @Test
    fun `throws an exception when lotto numbers are not in range`(){
        val  number = "56,1,3,7,6,9"
        assertThatThrownBy{Lotto.generateWinningLotto(number)}
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("[ERROR] Lotto numbers must be between 1 and 45.")
    }

    // TODO: Implement tests based on the added features
}
