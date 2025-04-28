package lotto.model

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource

class WinningLottoTest {

    private lateinit var winningLotto: WinningLotto

    @BeforeEach
    fun setUp() {
        winningLotto = WinningLotto.create("1,2,3,4,5,6")
    }

    @Test
    @DisplayName("Test creation of WinningLotto object")
    fun createWinningLottoTest() {
        assertThat(winningLotto.getNumbers()).isEqualTo(listOf(1, 2, 3, 4, 5, 6))
    }

    @ParameterizedTest
    @ValueSource(strings = ["", " ", "1,2,3", "1,2,3,4,5,abc", "1,1,2,3,4,5"])
    @DisplayName("Exception test when creating invalid WinningLotto")
    fun createWinningLottoExceptionTest(input: String) {
        assertThatThrownBy { WinningLotto.create(input) }
            .isInstanceOf(IllegalArgumentException::class.java)
    }

    @ParameterizedTest
    @CsvSource("7", "45", "12")
    @DisplayName("Test adding bonus number")
    fun addBonusNumberTest(bonusNum: String) {
        winningLotto.addBonusNumber(bonusNum)
        assertThat(winningLotto.getBonusNum()).isEqualTo(bonusNum.toInt())
    }

    @ParameterizedTest
    @ValueSource(strings = ["1", "2", "3", "0", "46", "abc"])
    @DisplayName("Exception test when adding invalid bonus number")
    fun addBonusNumberExceptionTest(bonusNum: String) {
        assertThatThrownBy { winningLotto.addBonusNumber(bonusNum) }
            .isInstanceOf(IllegalArgumentException::class.java)
    }
}
