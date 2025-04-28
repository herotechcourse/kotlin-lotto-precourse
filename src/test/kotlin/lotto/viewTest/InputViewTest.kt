package lotto.views

import lotto.Config
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.DisplayName

class InputViewTest {
    @Test
    @DisplayName("parses valid purchase amount")
    fun parseValidPurchaseAmount() {
        assertThat(InputView.parsePurchaseAmount("2000")).isEqualTo(2000)
    }

    @Test
    @DisplayName("parsePurchaseAmount with non-numeric input throws exception")
    fun parseNonNumericPurchaseAmountThrows() {
        assertThatThrownBy { InputView.parsePurchaseAmount("abc") }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("[ERROR]")
    }

    @Test
    @DisplayName("parsePurchaseAmount with non-positive multiple of ticket price throws exception")
    fun parseInvalidMultiplePurchaseAmountThrows() {
        assertThatThrownBy { InputView.parsePurchaseAmount("1500") }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("[ERROR]")
    }

    @Test
    @DisplayName("parse valid winning numbers")
    fun parseValidWinningNumbers() {
        val nums = InputView.parseWinningNumbers("1,2,3,4,5,6")
        assertThat(nums).containsExactly(1,2,3,4,5,6)
    }

    @Test
    @DisplayName("parseWinningNumbers with not enough numbers throws exception")
    fun parseWinningNumbersInvalidCountThrows() {
        assertThatThrownBy { InputView.parseWinningNumbers((1..Config.LOTTO_NUMBER_COUNT - 1).joinToString(",")) }
            .hasMessageContaining("[ERROR]")
    }

    @Test
    @DisplayName("parseWinningNumbers with duplicate numbers throws exception")
    fun parseWinningNumbersDuplicatesThrows() {
        assertThatThrownBy { InputView.parseWinningNumbers("1,2,2,3,4,5") }
            .hasMessageContaining("[ERROR]")
    }

    @Test
    @DisplayName("parseWinningNumbers with out of range number throws exception")
    fun parseWinningNumbersOutOfRangeThrows() {
        val max = Config.MAX_LOTTO_NUMBER
        assertThatThrownBy { InputView.parseWinningNumbers("${max+1}") }
            .hasMessageContaining("[ERROR]")
    }

    @Test
    @DisplayName("parses valid bonus number")
    fun parseValidBonusNumber() {
        val winning = listOf(1,2,3,4,5,6)
        assertThat(InputView.parseBonusNumber("7", winning)).isEqualTo(7)
    }

    @Test
    @DisplayName("parseBonusNumber with duplicate number in winning numbers throws exception")
    fun parseBonusNumberInWinningNumbersThrows() {
        val winning = listOf(1,2,3,4,5,6)
        assertThatThrownBy { InputView.parseBonusNumber("3", winning) }
            .hasMessageContaining("[ERROR]")
    }

    @Test
    @DisplayName("parseBonusNumber with out of range number throws exception")
    fun parseBonusNumberOutOfRangeThrows() {
        val winning = listOf(1,2,3,4,5,6)
        assertThatThrownBy { InputView.parseBonusNumber("${Config.MAX_LOTTO_NUMBER+1}", winning) }
            .hasMessageContaining("[ERROR]")
    }

    @Test
    @DisplayName("parseBonusNumber with non-numeric input throws exception")
    fun parseBonusNumberNonNumericThrows() {
        val winning = listOf(1,2,3,4,5,6)
        assertThatThrownBy { InputView.parseBonusNumber("x", winning) }
            .hasMessageContaining("[ERROR]")
    }
}
