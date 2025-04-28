package lotto

import org.assertj.core.api.Assertions.assertThatThrownBy
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoTest {

    @Test
    fun `throws an exception when lotto numbers exceed six`() {
        assertThatThrownBy {
            Lotto(listOf(1, 2, 3, 4, 5, 6, 7))
        }.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("[ERROR]")
    }

    @Test
    fun `throws an exception when lotto numbers contain duplicates`() {
        assertThatThrownBy {
            Lotto(listOf(1, 2, 3, 4, 5, 5))
        }.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("[ERROR]")
    }

    @Test
    fun `creates a lotto successfully with six unique numbers`() {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        assertThat(lotto.getNumbers()).containsExactly(1, 2, 3, 4, 5, 6)
    }
}
