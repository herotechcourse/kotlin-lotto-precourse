package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class LottoTests {
    @ParameterizedTest
    @ValueSource(strings = ["1000", "2000", "3000"])
    fun `test getPurchaseAmount valid input`(input: String) {
        val result = InputView.getPurchaseAmount(input)
        assertThat(result).isIn(1000, 2000, 3000)
    }

    @ParameterizedTest
    @ValueSource(strings = ["0", "999", "1500", "abc"])
    fun `test getPurchaseAmount invalid input`(input: String) {
        val exception = assertThrows<IllegalArgumentException> { InputView.getPurchaseAmount(input) }

        assertThat(exception).hasMessage("[ERROR] Please enter the valid purchase amount.")
    }

    @ParameterizedTest
    @ValueSource(strings = [
        "1,2,3,4,5,6",
        "10,20,30,40,44,45"
    ])
    fun `test getWinningNumbers valid input`(input: String) {
        val result = InputView.getWinningNumbers(input)
        assertThat(result).containsExactly(*input.split(",").map { it.toInt() }.toTypedArray())
    }

    @ParameterizedTest
    @ValueSource(strings = [
        "1,2,3,4,5,46",
        "1,2,3,4,5,",
        "1,2,3,4,5",
        "1,2,3,4,5,5"
    ])

    fun `test getWinningNumbers invalid input`(input: String) {
        val exception = assertThrows<IllegalArgumentException> { InputView.getWinningNumbers(input) }

        assertThat(exception).hasMessage("[ERROR] You must enter exactly 6 unique integers between 1 and 45.")
    }

    @ParameterizedTest
    @ValueSource(strings = ["1", "45"])
    fun `test getBonusNumbers valid input`(input: String) {
        val result = InputView.getBonusNumber(input)
        assertThat(result).isIn(1, 45)
    }

    @ParameterizedTest
    @ValueSource(strings = ["0", "-1", "1.2", "46", "abc"])
    fun `test getBonusNumbers invalid input`(input: String) {
        val exception = assertThrows<IllegalArgumentException> { InputView.getBonusNumber(input) }

        assertThat(exception).hasMessage("[ERROR] Bonus number must be an integer between 1 and 45.")
    }
}
