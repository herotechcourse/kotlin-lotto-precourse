package lotto.parser

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class BonusNumberInputParserTest {

    private val parser = BonusNumberInputParser()

    @Test
    fun `parses valid integer string to BonusNumber`() {
        // given
        val input = "7"

        // when
        val bonusNumber = parser.parse(input)

        // then
        assertThat(bonusNumber.number()).isEqualTo(7)
    }

    @Test
    fun `throws exception with message when input is not an integer`() {
        // given
        val input = "abc"

        // when
        val exception = assertThrows<IllegalArgumentException> {
            parser.parse(input)
        }

        // then
        assertThat(exception.message).isEqualTo(BonusNumberInputParser.BONUS_NUMBER_MUST_BE_INTEGER)
    }

    @Test
    fun `throws exception with message when input is empty`() {
        // given
        val input = ""

        // when
        val exception = assertThrows<IllegalArgumentException> {
            parser.parse(input)
        }

        // then
        assertThat(exception.message).isEqualTo(BonusNumberInputParser.BONUS_NUMBER_MUST_BE_INTEGER)
    }
}
