package lotto.domain



import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.assertj.core.api.Assertions.assertThatThrownBy

class MoneyTest {

    //값이 1000원 단위로 안떨어지면 예외던짐
    @Test
    fun `throws exception when amount is not divisible by 1000`() {
        // given
        val invalidAmount = 1500

        // when & then
        assertThatThrownBy { Money(invalidAmount) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("Amount must be divisible by 1000")
    }

    // 지불한 값만 만큼 티켓 갯수 확인 검증
    @Test
    fun `returns correct ticket count`() {
        // given
        val amount = 8000

        // when
        val money = Money(amount)

        // then :  If a user pays 8000 won, lotto-machine should receive 8 tickets
        assertThat(money.countTickets()).isEqualTo(8);
    }

    @Test
    fun `throws exception when amount is zero or negative`() {
        // given
        val invalidAmounts = listOf(0, -3000)

        // when & then : For each amount, check if an exception is thrown
        invalidAmounts.forEach {  // Indentation level 1
            assertThatThrownBy { Money(it) }  // Indentation level 2
                .isInstanceOf(IllegalArgumentException::class.java)
                .hasMessageContaining("greater than 0")
        }
    }
}