package lotto

import camp.nextstep.edu.missionutils.Console
import lotto.Consts.ERROR_PREFIX
import lotto.StringUtil.toIntList

class Input(private val validator: Validator) {

    fun enterPurchaseAmount(): IssuedTicket {
        println("Please enter the purchase amount.")
        return retry { IssuedTicket.of(validator.validateStringToInt(it)) }
    }

    fun enterWinningNumbers(): Lotto {
        println("\nPlease enter last week's winning numbers.")
        return retry { Lotto(it.toIntList(validator)) }
    }

    fun enterBonusNumber(lotto: Lotto): Int {
        println("\nPlease enter the bonus number.")
        return retry { getBonusNumber(it, lotto) }
    }

    private fun getBonusNumber(stringValue: String, lotto: Lotto): Int {
        return validator.validateStringToInt(stringValue).apply {
            lotto.validateNumber(this)
        }
    }

    private fun <T> retry(run: (String) -> T): T {
        while (true) {
            try {
                return run(Console.readLine())
            } catch (e: IllegalArgumentException) {
                println("$ERROR_PREFIX ${e.message}")
            }
        }
    }
}
