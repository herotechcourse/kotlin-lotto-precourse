package lotto.model

import lotto.common.ErrorMessages
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class MoneyTest {

    @Nested
    @DisplayName("Money creation tests")
    inner class MoneyCreationTest {
        
        @Test
        @DisplayName("Should create Money with valid amount")
        fun createMoneyWithValidAmount() {
            // Given, When
            val money = Money(1000)
            
            // Then
            assertThat(money.getAmount()).isEqualTo(1000)
        }
        
        @Test
        @DisplayName("Should throw exception when amount is null")
        fun throwExceptionWhenAmountIsNull() {
            // Given, When, Then
            assertThatThrownBy { Money(null) }
                .isInstanceOf(IllegalArgumentException::class.java)
                .hasMessage(ErrorMessages.INVALID_PURCHASE_AMOUNT_TYPE)
        }
        
        @ParameterizedTest
        @ValueSource(ints = [0, 500, 999])
        @DisplayName("Should throw exception when amount is less than minimum")
        fun throwExceptionWhenAmountIsLessThanMinimum(amount: Int) {
            // Given, When, Then
            assertThatThrownBy { Money(amount) }
                .isInstanceOf(IllegalArgumentException::class.java)
                .hasMessage(ErrorMessages.INVALID_PURCHASE_AMOUNT_UNIT)
        }
    }
    
    @Nested
    @DisplayName("Money behavior tests")
    inner class MoneyBehaviorTest {
        
        @ParameterizedTest
        @ValueSource(ints = [1000, 2000, 100000])
        @DisplayName("Should return correct amount when getAmount is called")
        fun getAmountShouldReturnCorrectValue(amount: Int) {
            // Given
            val money = Money(amount)
            
            // When
            val result = money.getAmount()
            
            // Then
            assertThat(result).isEqualTo(amount)
        }
        
        @Test
        @DisplayName("Should allow maximum valid amount")
        fun shouldAllowMaximumValidAmount() {
            // Given, When
            val money = Money(Int.MAX_VALUE)
            
            // Then
            assertThat(money.getAmount()).isEqualTo(Int.MAX_VALUE)
        }
    }
}