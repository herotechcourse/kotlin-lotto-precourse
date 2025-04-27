package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class InputViewTest {

    private val inputView = InputView()

    @Test
    fun `validate purchase amount divisible by 1000`() {
        val amount = inputView.validateAmount("3000")
        assertThat(amount).isEqualTo(3000)
    }

    @Test
    fun `throw exception for purchase amount not divisible by 1000`() {
        assertThrows<IllegalArgumentException> {
            inputView.validateAmount("2500")
        }
    }

    @Test
    fun `parse valid winning numbers into list`() {
        val numbers = inputView.parseNumbers("1,2,3,4,5,6")
        assertThat(numbers).containsExactly(1, 2, 3, 4, 5, 6)
    }

    @Test
    fun `throw exception for invalid winning numbers`() {
        assertThrows<IllegalArgumentException> {
            inputView.parseNumbers("1,2,3,4,5") // Too few
        }
        assertThrows<IllegalArgumentException> {
            inputView.parseNumbers("1,2,3,4,4,5") // Duplicates
        }
        assertThrows<IllegalArgumentException> {
            inputView.parseNumbers("1,2,3,4,5,50") // Out of range
        }
    }

    @Test
    fun `validate bonus number within range and not in winning numbers`() {
        val winningNumbers = listOf(1, 2, 3, 4, 5, 6)
        val bonus = inputView.validateBonus("7", winningNumbers)
        assertThat(bonus).isEqualTo(7)
    }

    @Test
    fun `throw exception for invalid bonus number`() {
        val winningNumbers = listOf(1, 2, 3, 4, 5, 6)
        assertThrows<IllegalArgumentException> {
            inputView.validateBonus("1", winningNumbers) // In winning numbers
        }
        assertThrows<IllegalArgumentException> {
            inputView.validateBonus("50", winningNumbers) // Out of range
        }
    }

}