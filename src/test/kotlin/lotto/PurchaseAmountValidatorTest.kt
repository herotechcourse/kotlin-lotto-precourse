package lotto

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class PurchaseAmountValidatorTest {
    @Test
    fun `throws an exception when purchase amount is not positive`() {
        assertThrows<IllegalArgumentException> {
            PurchaseAmountValidator.validate("-1000")
        }
    }

    @Test
    fun `throws an exception when purchase amount is blank`() {
        assertThrows<IllegalArgumentException> {
            PurchaseAmountValidator.validate(" ")
        }
    }

    @Test
    fun `throws an exception when purchase amount includes decimal`() {
        assertThrows<IllegalArgumentException> {
            PurchaseAmountValidator.validate("1000.5")
        }
    }

    @Test
    fun `throws an exception when purchase amount is less than 1,000`() {
        assertThrows<IllegalArgumentException> {
            PurchaseAmountValidator.validate("500")
        }
    }

    @Test
    fun `throws an exception when purchase amount is not divisible 1,000`() {
        assertThrows<IllegalArgumentException> {
            PurchaseAmountValidator.validate("2500")
        }
    }

    @Test
    fun `passes when purchase amount is a valid integer without commas`() {
        PurchaseAmountValidator.validate("1000")
    }

    @Test
    fun `passes when purchase amount is a valid integer with commas`() {
        PurchaseAmountValidator.validate("1,000")
    }
}