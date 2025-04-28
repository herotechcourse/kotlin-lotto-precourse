package input.util

import input.getLottoNumberArrayFromInput
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class NumberParserTest {

    @Test
    fun `should parse valid input into array of integers`() {
        // given
        val input = "1,23,45"

        // when
        val result = getValidatedLottoNumbers(input)


        // then
        assertArrayEquals(arrayOf(1, 23, 45), result)
    }

    @Test
    fun `should throw exception if number is less than minimum`() {
        // given
        val input = "0,23,45"

        // then
        assertThrows<IllegalArgumentException> {
            getValidatedLottoNumbers(input)
        }
    }

    @Test
    fun `should throw exception if number is greater than maximum`() {
        // given
        val input = "1,23,46"

        // then
        assertThrows<IllegalArgumentException> {
            getValidatedLottoNumbers(input)
        }
    }

    @Test
    fun `should throw exception if input contains non-integer`() {
        // given
        val input = "1,23,abc"

        // then
        assertThrows<NumberFormatException> {
            getValidatedLottoNumbers(input)
        }
    }
}