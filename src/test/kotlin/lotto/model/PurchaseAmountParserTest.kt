package lotto.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class PurchaseAmountParserTest {
    @ParameterizedTest
    @CsvSource("5000, 5", "2000000, 2000", "1000, 1", "60000, 60", "7000000, 7000")
    fun `should parse based on lotto ticket unit`(input: Int, expected: Int) {
        val result = PurchaseAmountParser.parse(input)

        assertThat(result).isEqualTo(expected)
    }
}
