package lotto

import camp.nextstep.edu.missionutils.Console
import lotto.InputValidation.AmountValidation
import lotto.InputValidation.BonusNumberValidation
import lotto.InputValidation.WinningNumbersValidation

private val winningNumbersvalidator = WinningNumbersValidation()
private val amountValidator = AmountValidation()
private val bonusNumberValidation = BonusNumberValidation()

class InputView {
    //Re-prompt the purchase amount input until all validations pass
    fun InputPurchaseAmount(): Int {
        while (true) {
            try {
                println("Please enter the purchase amount.")
                val amount = Console.readLine().trim()
                val purchaseAmount = amountValidator.NullCheckNumber(amount)
                amountValidator.ValidateAmountPositive(purchaseAmount)
                amountValidator.ValidateAmountMultipleOfThousand(purchaseAmount)
                return purchaseAmount
            } catch (e: NumberFormatException) {
                println("[ERROR] Invalid purchase amount.")
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    //Re-prompt the winning numbers input until all validations pass
    fun InputWinningNumbers(): Pair<List<Int>, Lotto> {
        while (true) {
            try {
                println("Please enter last week's winning numbers.")
                val numbers = Console.readLine()
                winningNumbersvalidator.NullCheckWinningNumber(numbers)
                val winningNumbers = winningNumbersvalidator.SplitNumbersIntoList(numbers)
                val lottoVariable = Lotto(winningNumbers)
                return Pair(winningNumbers, lottoVariable)
            } catch (e: NumberFormatException) {
                println("[ERROR] Invalid winning numbers.")
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    //Re-prompt the  bonus number input until all validations pass
    fun InputBonusNumber(winningNumbers: List<Int>): Int {

        while (true) {
            try {
                println("Please enter the bonus number.")
                val bonus_no = Console.readLine()
                val bonus_number = amountValidator.NullCheckNumber(bonus_no)
                bonusNumberValidation.ValidateBonusNumberInRange1to45(bonus_number)
                bonusNumberValidation.ValidateBonusNumberUniqueness(bonus_number, winningNumbers)
                return bonus_number
            } catch (e: NumberFormatException) {
                println("[ERROR] Invalid winning numbers.")
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }
}