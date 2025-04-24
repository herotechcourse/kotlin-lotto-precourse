package lotto.domain


import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class MoneyTest {

    //값이 1000원 단위로 안떨어지면 예외던짐
    @Test
    fun `throws exception when amount is not divisible by 1000`() {
        // given
        val invalidAmount = 1500

        // when
        val exception = assertThrows<IllegalArgumentException> {
            Money(invalidAmount)
        }

        // then : [ERROR] Exception thrown - > Amount must be divisible by 1000
        assertTrue(exception.message?.contains("Amount must be divisible by 1000") == true)
    }

    // 지불한 값만 만큼 티켓 갯수 확인 검증
    @Test
    fun `returns correct ticket count`() {
        // given
        val amount = 8000

        // when
        val money = Money(amount)

        // then :  If a user pays 8000 won, lotto-machine should receive 8 tickets
        assertEquals(8, money.countTickets())
    }

    @Test
    fun `throws exception when amount is zero or negative`() {
        // given
        val invalidAmounts = listOf(0, -3000)

        // when & then
        invalidAmounts.forEach { amount ->
            val exception = assertThrows<IllegalArgumentException> {
                Money(amount)
            }
            assertTrue(exception.message?.contains("greater than 0") == true)
        }
    }
}