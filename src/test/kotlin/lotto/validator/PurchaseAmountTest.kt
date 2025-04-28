package lotto.validator
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test
class PurchaseAmountTest {
    @Test
    fun `valid amount returns int`() {
        val result = validatePurchaseAmount("5000")
        assert(result == 5000)
    }

    @Test
    fun `non numeric throws exception`() {
        assertThatThrownBy { validatePurchaseAmount("five thousand") }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("[ERROR] Purchase amount must be a number.")
    }

    @Test
    fun `non multiple of 1000 throws exception`() {
        assertThatThrownBy { validatePurchaseAmount("1500") }
            .hasMessage("[ERROR] Purchase amount must be a positive multiple of 1000.")
    }
}