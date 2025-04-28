package lotto

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.assertj.core.api.Assertions.assertThat

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
    fun `throws an exception when lotto numbers are less than six`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5))
        }
    }

    @Test
    fun `throws an exception when lotto numbers are not in range of 1-45`(){
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(67, 2, 3, 4, 5))
        }
    }

    @Test
    fun `creates a valid lotto with six unique numbers`() {
        val numbers = listOf(1, 2, 3, 4, 5, 6)

        val lotto = Lotto(numbers)

        assertThat(lotto.numbers).containsExactly(1, 2, 3, 4, 5, 6)
    }


}
