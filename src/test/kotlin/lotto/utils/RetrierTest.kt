package lotto.utils

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class RetrierTest {

    @Test
    fun `retryInput should retry on IllegalArgumentException and eventually succeed`() {
        var attempts = 0

        val result = Retrier.retryInput {
            attempts++
            if (attempts < 3) {
                throw IllegalArgumentException("Temporary error")
            }
            "Success after $attempts attempts"
        }

        assertThat(result).isEqualTo("Success after 3 attempts")
    }

    @Test
    fun `retryInput should succeed immediately without retry if no exception`() {
        val result = Retrier.retryInput {
            "Immediate Success"
        }

        assertThat(result).isEqualTo("Immediate Success")
    }
}
