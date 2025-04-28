package lotto
import lotto.view.InputView
import lotto.view.InputView.Companion.validateBonusNumberRange
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class BonusNumberTest {

    @Test
    fun `should Throw Exception When Bonus Number Is Out Of Range`() {
        assertThrows<IllegalArgumentException> {
            validateBonusNumberRange(50)
        }
    }
}