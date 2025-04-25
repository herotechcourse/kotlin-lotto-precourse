package lotto

import camp.nextstep.edu.missionutils.Console
import lotto.Consts.ERROR_PREFIX

object Input {

    fun enterPurchaseAmount(): IssuedTicket {
        println("Please enter the purchase amount.")
        return retry { IssuedTicket.of(StringValidator.validateStringToInt(it)) }
    }

    fun enterWinningNumbers(): Lotto {
        println("\nPlease enter last week's winning numbers.")
        return retry { Lotto(StringValidator.validateStringToIntList(it)) }
    }

    fun enterBonusNumber(lotto: Lotto): Int {
        println("\nPlease enter the bonus number.")
        return retry { getBonusNumber(it, lotto) }
    }

    private fun getBonusNumber(stringValue: String, lotto: Lotto): Int {
        return StringValidator.validateStringToInt(stringValue).apply {
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
