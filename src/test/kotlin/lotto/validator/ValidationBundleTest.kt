package lotto.validator

import lotto.constants.Constants
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows

class ValidationBundleTest {

    @Test
    fun `success - purchaseAmount`() {
        val validInput = listOf(
            8000,
            15000,
            Constants.MIN_PURCHASE_RANGE,
            Constants.MAX_PURCHASE_RANGE,
        )

        validInput.forEach { input ->
            assertDoesNotThrow {
                ValidationBundle.purchaseAmount(input.toString())
            }
        }
    }

    @Test
    fun `exception - purchaseAmount invalid cases`() {
        val invalidInputs = listOf(
            "",
            "1200a",
            "-20000",
            (Constants.MIN_PURCHASE_RANGE - 1).toString(),
            (Constants.MAX_PURCHASE_RANGE + 1).toString(),
            "1500"
        )

        invalidInputs.forEach { input ->
            assertThrows<IllegalArgumentException> {
                ValidationBundle.purchaseAmount(input)
            }
        }
    }

    @Test
    fun `success - winningNumbers`() {
        val validInput = listOf("1,2,3,4,5,6", "10,20,30,40,41,45")

        validInput.forEach { input ->
            assertDoesNotThrow {
                ValidationBundle.winningNumbers(input)
            }
        }
    }


    @Test
    fun `exception - winningNumbers invalid cases`() {
        val invalidInputs = listOf(
            "",
            "1,2,3,four,5,6",
            "1,2,3,4.5,6",
            "1,2,3,4,5,-6"
        )

        invalidInputs.forEach { input ->
            assertThrows<IllegalArgumentException> {
                ValidationBundle.purchaseAmount(input)
            }
        }
    }

    @Test
    fun `success - bonusNumber`() {
        val validInput = listOf("7", "45")
        validInput.forEach { input ->
            assertDoesNotThrow {
                ValidationBundle.bonusNumber(input)
            }
        }
    }


    @Test
    fun `exception - bonusNumber invalid cases`() {
        val invalidInputs = listOf(
            "", "-1", "abc", "3.14"
        )
        invalidInputs.forEach { input ->
            assertThrows<IllegalArgumentException> {
                ValidationBundle.bonusNumber(input)
            }
        }
    }
}
