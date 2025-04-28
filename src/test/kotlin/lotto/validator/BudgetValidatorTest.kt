package lotto.validator

import org.assertj.core.api.Assertions.assertThatThrownBy
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class BudgetValidatorTest {

    private val validator = BudgetValidator()

    @Test
    fun `If the budget is above the minimum, return it as is`() {
        val result = validator.run(1000)
        assertThat(result).isEqualTo(1000)
    }

    @Test
    fun `If the budget is below the minimum, throw an exception`() {
        assertThatThrownBy {
            validator.run(500)
        }.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("[ERROR] Budget value must be greater than")
    }
}
