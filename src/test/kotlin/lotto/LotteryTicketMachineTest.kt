package lotto

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class LotteryTicketMachineTest {
    @Test
    fun `throws exception when purchase amount is not divisible by 1,000`() {
        assertThrows<IllegalArgumentException> {
            LotteryTicketMachine.validatePurchaseAmount(1500)
        }
    }

    @Test
    fun `throws exception when more than six winning numbers are provided`() {
        assertThrows<IllegalArgumentException> {
            LotteryTicketMachine.validateAmountOfNumbers(listOf(1, 2, 3, 4, 5, 6, 7))
        }
    }

    @Test
    fun `throws exception when less than six winning numbers are provided`() {
        assertThrows<IllegalArgumentException> {
            LotteryTicketMachine.validateAmountOfNumbers(listOf(1, 2, 3, 4, 5))
        }
    }

    @Test
    fun `throws exception when winning numbers have duplicate`() {
        assertThrows<IllegalArgumentException> {
            LotteryTicketMachine.validateUniqueness(listOf(1, 2, 3, 4, 5, 5))
        }
    }

    @Test
    fun `throws exception when winning numbers are not in range from 1 to 45`() {
        assertThrows<IllegalArgumentException> {
            LotteryTicketMachine.validateWinningNumbers(listOf(1, 2, 3, 4, 5, 46))
        }
    }

    @Test
    fun `does not throw exception when winning numbers are six, in range from 1 to 45 and do not have duplicates`() {
        LotteryTicketMachine.validateWinningNumbers(listOf(1, 2, 3, 4, 5, 6))
    }

    @Test
    fun `throws exception when bonus number is not in range from 1 to 45`() {
        assertThrows<IllegalArgumentException> {
            LotteryTicketMachine.validateBonusNumber(listOf(1, 2, 3, 4, 5, 6), 46)
        }
    }

    @Test
    fun `throws exception when bonus number is already in winning numbers`() {
        assertThrows<IllegalArgumentException> {
            LotteryTicketMachine.validateBonusNumber(listOf(1, 2, 3, 4, 5, 6), 6)
        }
    }

    @Test
    fun `does not throw exception when bonus number is in range from 1 to 45 and does not have a duplicate in winning numbers`() {
        LotteryTicketMachine.validateBonusNumber(listOf(1, 2, 3, 4, 5, 6), 7)
    }
}