package lotto

import lotto.models.Lotto
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.assertj.core.api.Assertions.assertThat


class LottoTest {
    @Test
    fun `TEST creates Lotto with valid numbers`() {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        assertThat(lotto.getNumbers()).containsExactly(1, 2, 3, 4, 5, 6)
    }

    @Test
    fun `EXCEPTION lotto numbers exceed six`() {
        val exception = assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 6, 7))
        }

        assertThat(exception.message).contains(ERROR_MESSAGE)

    }

    @Test
    fun `EXCEPTION lotto numbers less than six`() {
        val exception = assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5))
        }

        assertThat(exception.message).contains(ERROR_MESSAGE)

    }

    @Test
    fun `EXCEPTION lotto numbers contain duplicates`() {
        val exception = assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 5))
        }

        assertThat(exception.message).contains(ERROR_MESSAGE)
    }

    @Test
    fun `EXCEPTION numbers are out of 1 to 45 range`() {
        val exception = assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 46))
        }

        assertThat(exception.message).contains(ERROR_MESSAGE)

    }

    companion object {
        private const val ERROR_MESSAGE: String = "[ERROR]"
    }
}
