package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import java.io.ByteArrayInputStream
import java.io.InputStream

class InputParamsReaderTest {
    private lateinit var reader: InputParamsReader

    @BeforeEach
    fun cleanReader() {
        reader = InputParamsReader()
    }

    @Test
    fun `should retry until valid amount is entered`() {
        provideInput("abc", "-1000", "1500", "2000")

        val result = reader.retrievePurchaseAmountWithRetry()
        assertThat(result).isEqualTo(2000)
    }


    private fun provideInput(vararg inputs: String) {
        val input = inputs.joinToString(separator = "\n", postfix = "\n")
        val testInputStream: InputStream = ByteArrayInputStream(input.toByteArray())
        System.setIn(testInputStream)
    }

}