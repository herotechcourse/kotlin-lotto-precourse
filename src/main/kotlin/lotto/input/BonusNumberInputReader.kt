package lotto.input

import camp.nextstep.edu.missionutils.Console
import lotto.validation.BonusNumberValidator
import lotto.validation.WinningNumberValidator

private val bonusValidator = BonusNumberValidator(WinningNumberValidator())

class BonusNumberInputReader {

    fun read(): Int {
        while (true) {
            try {
                println("Please enter the bonus number.")
                val input = Console.readLine()

                // Validate the bonus number using the BonusNumberValidator
                return bonusValidator.validateBonusNumber(input)

            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }
}