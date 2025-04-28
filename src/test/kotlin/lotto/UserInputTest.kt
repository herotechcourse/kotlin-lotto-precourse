package lotto

import lotto.constants.HIGHEST_NUMBER
import lotto.constants.LOWEST_NUMBER
import lotto.constants.TICKET_COST
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class UserInputTest {
    private lateinit var userInput: UserInput

    @BeforeEach
    fun setUp() {
        userInput = UserInput()
    }

    @Nested
    inner class SetPurchaseAmountTests {
        @Test
        fun `setPurchaseAmount should assign a valid value`() {
            userInput.setPurchaseAmount("5000")

            assertEquals(5000, userInput.purchaseAmount)
        }

        @Test
        fun `setPurchaseAmount should throw an exception when not a number is given`() {
            val thrown = assertThrows<IllegalArgumentException> {
                userInput.setPurchaseAmount("a")
            }

            assertThat(thrown)
                .isInstanceOf(IllegalArgumentException::class.java)
                .hasMessage(
                    "[ERROR] Purchase amount must be a number."
                )
        }

        @Test
        fun `setPurchaseAmount should throw an exception when nothing is given`() {
            val thrown = assertThrows<IllegalArgumentException> {
                userInput.setPurchaseAmount("")
            }

            assertThat(thrown)
                .isInstanceOf(IllegalArgumentException::class.java)
                .hasMessage(
                    "[ERROR] Purchase amount must be a number."
                )
        }

        @Test
        fun `setPurchaseAmount should throw an exception when a number equal or lower than zero is given`() {
            val thrown = assertThrows<IllegalArgumentException> {
                userInput.setPurchaseAmount("-42")
            }
            val thrownZero = assertThrows<IllegalArgumentException> {
                userInput.setPurchaseAmount("0")
            }

            assertThat(thrown)
                .isInstanceOf(IllegalArgumentException::class.java)
                .hasMessage(
                    "[ERROR] Purchase amount must be greater than zero."
                )
            assertThat(thrownZero)
                .isInstanceOf(IllegalArgumentException::class.java)
                .hasMessage(
                    "[ERROR] Purchase amount must be greater than zero."
                )
        }

        @Test
        fun `setPurchaseAmount should throw an exception when the purchase amount is lower that the ticket cost`() {
            val thrown = assertThrows<IllegalArgumentException> {
                userInput.setPurchaseAmount("10")
            }

            assertThat(thrown)
                .isInstanceOf(IllegalArgumentException::class.java)
                .hasMessage(
                    "[ERROR] Purchase amount must be equal or greater than $TICKET_COST."
                )
        }

        @Test
        fun `setPurchaseAmount should throw an exception when the purchase amount is not divisible the ticket cost`() {
            val thrown = assertThrows<IllegalArgumentException> {
                userInput.setPurchaseAmount("1001")
            }

            assertThat(thrown)
                .isInstanceOf(IllegalArgumentException::class.java)
                .hasMessage(
                    "[ERROR] Purchase amount must be a multiple of ${TICKET_COST}."
                )
        }
    }

    @Nested
    inner class SetWinningNumbersTests {
        @Test
        fun `setWinningNumbers should assign valid values`() {
            userInput.setWinningNumbers("1,2,3,4,5,6")

            assertEquals(mutableListOf<Int>(1, 2, 3, 4, 5, 6), userInput.winningNumbers)
        }

        @Test
        fun `setWinningNumbers should throw an exception when not a number is given`() {
            val thrown = assertThrows<IllegalArgumentException> {
                userInput.setWinningNumbers("1,2,3,4,a,6")
            }

            assertThat(thrown)
                .isInstanceOf(IllegalArgumentException::class.java)
                .hasMessage(
                    "[ERROR] All numbers must be a number."
                )
        }

        @Test
        fun `setWinningNumbers should throw an exception when nothing is given`() {
            val thrown = assertThrows<IllegalArgumentException> {
                userInput.setWinningNumbers("")
            }

            assertThat(thrown)
                .isInstanceOf(IllegalArgumentException::class.java)
                .hasMessage(
                    "[ERROR] All numbers must be a number."
                )
        }

        @Test
        fun `setWinningNumbers should throw an exception when a number is not given`() {
            val thrown = assertThrows<IllegalArgumentException> {
                userInput.setWinningNumbers("1,2,3,4,,6")
            }

            assertThat(thrown)
                .isInstanceOf(IllegalArgumentException::class.java)
                .hasMessage(
                    "[ERROR] All numbers must be a number."
                )
        }

        @Test
        fun `setWinningNumbers should throw an exception when a number equal or lower than 0 is given`() {
            val thrown = assertThrows<IllegalArgumentException> {
                userInput.setWinningNumbers("1,2,3,4,-42,6")
            }
            val thrownZero = assertThrows<IllegalArgumentException> {
                userInput.setWinningNumbers("1,2,3,4,0,6")
            }

            assertThat(thrown)
                .isInstanceOf(IllegalArgumentException::class.java)
                .hasMessage(
                    "[ERROR] All numbers must be greater than zero."
                )
            assertThat(thrownZero)
                .isInstanceOf(IllegalArgumentException::class.java)
                .hasMessage(
                    "[ERROR] All numbers must be greater than zero."
                )
        }

        @Test
        fun `setWinningNumbers should throw an exception when a number is out of Lotto bounds`() {
            val thrown = assertThrows<IllegalArgumentException> {
                userInput.setWinningNumbers("1,2,3,4,999,6")
            }

            assertThat(thrown)
                .isInstanceOf(IllegalArgumentException::class.java)
                .hasMessage(
                    "[ERROR] All numbers must be between $LOWEST_NUMBER and $HIGHEST_NUMBER."
                )
        }

        @Test
        fun `setWinningNumbers should throw an exception when not all numbers are unique`() {
            val thrown = assertThrows<IllegalArgumentException> {
                userInput.setWinningNumbers("1,2,3,4,5,5")
            }

            assertThat(thrown)
                .isInstanceOf(IllegalArgumentException::class.java)
                .hasMessage(
                    "[ERROR] All numbers must be unique"
                )
        }

        @Test
        fun `setWinningNumbers should throw an exception when less than six numbers are given`() {
            val thrown = assertThrows<IllegalArgumentException> {
                userInput.setWinningNumbers("1,2,3,4,5")
            }

            assertThat(thrown)
                .isInstanceOf(IllegalArgumentException::class.java)
                .hasMessage(
                    "[ERROR] There must be exactly 6 winning numbers."
                )
        }

        @Test
        fun `setWinningNumbers should throw an exception when more than six numbers are given`() {
            val thrown = assertThrows<IllegalArgumentException> {
                userInput.setWinningNumbers("1,2,3,4,5,6,7")
            }

            assertThat(thrown)
                .isInstanceOf(IllegalArgumentException::class.java)
                .hasMessage(
                    "[ERROR] There must be exactly 6 winning numbers."
                )
        }
    }

    @Nested
    inner class SetBonusNumberTests {
        @Test
        fun `setBonusNumber should assign a valid value`() {
            userInput.setBonusNumber("42")

            assertEquals(42, userInput.bonusNumber)
        }

        @Test
        fun `setBonusNumber should throw an exception when not a number is given`() {
            val thrown = assertThrows<IllegalArgumentException> {
                userInput.setBonusNumber("a")
            }

            assertThat(thrown)
                .isInstanceOf(IllegalArgumentException::class.java)
                .hasMessage(
                    "[ERROR] Bonus number must be a number."
                )
        }

        @Test
        fun `setBonusNumber should throw an exception when nothing is given`() {
            val thrown = assertThrows<IllegalArgumentException> {
                userInput.setBonusNumber("")
            }

            assertThat(thrown)
                .isInstanceOf(IllegalArgumentException::class.java)
                .hasMessage(
                    "[ERROR] Bonus number must be a number."
                )
        }

        @Test
        fun `setBonusNumber should throw an exception when a number equal or lower than zero is given`() {
            val thrown = assertThrows<IllegalArgumentException> {
                userInput.setBonusNumber("-42")
            }
            val thrownZero = assertThrows<IllegalArgumentException> {
                userInput.setBonusNumber("0")
            }

            assertThat(thrown)
                .isInstanceOf(IllegalArgumentException::class.java)
                .hasMessage(
                    "[ERROR] Bonus number must be greater than zero."
                )
            assertThat(thrownZero)
                .isInstanceOf(IllegalArgumentException::class.java)
                .hasMessage(
                    "[ERROR] Bonus number must be greater than zero."
                )
        }

        @Test
        fun `setBonusNumber should throw an exception when a number is out of Lotto bounds`() {
            val thrown = assertThrows<IllegalArgumentException> {
                userInput.setBonusNumber("999")
            }

            assertThat(thrown)
                .isInstanceOf(IllegalArgumentException::class.java)
                .hasMessage(
                    "[ERROR] Bonus number must be between $LOWEST_NUMBER and $HIGHEST_NUMBER."
                )
        }

        @Test
        fun `setBonusNumber should be different than all winning numbers`() {
            userInput.setWinningNumbers("1,2,3,4,5,6")

            val thrown = assertThrows<IllegalArgumentException> {
                userInput.setBonusNumber("1")
            }

            assertThat(thrown)
                .isInstanceOf(IllegalArgumentException::class.java)
                .hasMessage(
                    "[ERROR] Bonus number cannot be one of the winning numbers."
                )
        }
    }
}