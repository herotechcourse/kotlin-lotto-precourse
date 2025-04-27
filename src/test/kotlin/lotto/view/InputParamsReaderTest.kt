package lotto.view

import camp.nextstep.edu.missionutils.Console
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.AfterEach
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

    @AfterEach
    fun restoreConsole() {
        Console.close()
    }

    @Test
    fun `should retry until valid amount is entered`() {
        provideInput("abc", "-1000", "1500", "2000")

        val result = reader.retrievePurchaseAmountWithRetry()
        assertThat(result).isEqualTo(2000)
    }

    @Test
    fun `should retry until valid winning numbers are entered`() {
        provideInput("a,b,c,d,e,f", "-4,5,3,1,2,3", "1,1,1,1,1,1",
            "1,2,3,4,5", "1m, 2m, 3,4,5,6", "140, 141, 2,3,4,5", "7,1,3, 45, 34,   11")

        val result = reader.retrieveLastWeekWinningNumbersWithRetry()
        assertThat(result.size).isEqualTo(6)
        assertThat(result[0]).isEqualTo(7)
        assertThat(result[1]).isEqualTo(1)
        assertThat(result[2]).isEqualTo(3)
        assertThat(result[3]).isEqualTo(45)
        assertThat(result[4]).isEqualTo(34)
        assertThat(result[5]).isEqualTo(11)
    }

    @Test
    fun `should retry until valid bonus number is entered`() {
        provideInput("abc", "-1", "0", "1", "45")

        val lastWeekWinningNumbers = listOf(1,2,3,4,5,6)
        val result = reader.retrieveBonusNumberWithRetry(lastWeekWinningNumbers)
        assertThat(result).isEqualTo(45)
    }

    private fun provideInput(vararg inputs: String) {
        val input = inputs.joinToString(separator = "\n", postfix = "\n")
        val testInputStream: InputStream = ByteArrayInputStream(input.toByteArray())
        System.setIn(testInputStream)
    }

}