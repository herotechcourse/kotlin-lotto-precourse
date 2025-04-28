package lotto

import org.assertj.core.api.Assertions.assertThatCode
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

    @Test
    fun `throws an exception when lotto numbers contain duplicates`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 5))
        }
    }

    @Test
    fun `throws an exception when lotto numbers is not between 1 and 45`() {
        assertThatThrownBy { Lotto(listOf(1, 2, 3, 4, 5, 50)) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("[ERROR] Lotto must range 1 to 45. ")
    }

    @Test
    fun `throws an exception when lotto numbers include zero`() {
        assertThatThrownBy { Lotto(listOf(0, 2, 3, 4, 5, 6)) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("[ERROR] Lotto must range 1 to 45. ")
    }

    @Test
    fun `throws an exception when lotto numbers include negative number`() {
        assertThatThrownBy { Lotto(listOf(-1, 2, 3, 4, 5, 6)) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("[ERROR] Lotto must range 1 to 45. ")
    }

    @Test
    fun `throws an exception when order of lotto numbers is not ascending order`() {
        assertThatThrownBy { Lotto(listOf(9, 3, 8, 4, 5, 43)) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("[ERROR] Lotto must order in ascending order. ")
    }

    @Test
    fun `pass when lotto numbers contain 6 distinct numbers in ascending order`() {
        assertThatCode { Lotto(listOf(1, 2, 3, 4, 5, 6)) }.doesNotThrowAnyException()
    }
}
