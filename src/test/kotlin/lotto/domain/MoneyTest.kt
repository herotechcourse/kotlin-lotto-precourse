package lotto.domain

import lotto.InputHandler.Companion.INPUT_NOT_DIVIDABLE
import lotto.InputHandler.Companion.NUMBER_NOT_POSITIVE
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class MoneyTest {

    @Test
    @DisplayName("Valid amount returns correct ticket count")
    fun createMoney_validAmount() {
        val money = Money(5000)
        assertEquals(5, money.ticketCount)
    }

    @Test
    @DisplayName("Amount 0 should throw IllegalArgumentException with NUMBER_NOT_POSITIVE")
    fun createMoney_zeroAmount() {
        val exception = assertThrows(IllegalArgumentException::class.java) {
            Money(0)
        }
        assertEquals(NUMBER_NOT_POSITIVE, exception.message)
    }

    @Test
    @DisplayName("Negative amount should throw IllegalArgumentException with NUMBER_NOT_POSITIVE")
    fun createMoney_negativeAmount() {
        val exception = assertThrows(IllegalArgumentException::class.java) {
            Money(-1000)
        }
        assertEquals(NUMBER_NOT_POSITIVE, exception.message)
    }

    @Test
    @DisplayName("Amount not divisible by LOTTO_PRICE should throw IllegalArgumentException with INPUT_NOT_DIVIDABLE")
    fun createMoney_notDivisibleAmount() {
        val exception = assertThrows(IllegalArgumentException::class.java) {
            Money(1500)
        }
        assertEquals(INPUT_NOT_DIVIDABLE, exception.message)
    }
}
