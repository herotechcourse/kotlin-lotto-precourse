package lotto.ui

import camp.nextstep.edu.missionutils.Console
import lotto.COST_OF_ONE_LOTTERY_TICKET
import lotto.Lotto

class InputView {

    fun getPurchaseAmount(): Long {
        var purchaseAmount: Long
        while (true) {
            try {
                purchaseAmount = readAndGetPurchaseAmount()
                if (purchaseAmount < COST_OF_ONE_LOTTERY_TICKET) {
                    println("Not enough amount to purchase at least 1 ticket (min $COST_OF_ONE_LOTTERY_TICKET KRW).")
                    println()
                    continue
                }
                break
            } catch (e: IllegalArgumentException) {
                println(e.message)
                println()
            }
        }
        return purchaseAmount
    }

    private fun readAndGetPurchaseAmount(): Long {
        println("Please enter the purchase amount.")
        val purchaseNumberInput = Console.readLine()
        if (purchaseNumberInput == null || !purchaseNumberInput.matches(Regex("\\d+"))) {
            throw IllegalArgumentException("[ERROR] Please enter digits only.")
        }
        println()
        return purchaseNumberInput.toLong()
    }

    fun getWinningNumbers(): Lotto {
        var winningNumbers: Lotto
        while (true) {
            try {
                winningNumbers = readAndGetWinningNumbers()
                break
            } catch (e: IllegalArgumentException) {
                println(e.message)
                println()
            }
        }
        return winningNumbers
    }

    fun readAndGetWinningNumbers(): Lotto {
        println()
        println("Please enter last week's winning numbers.")
        val winningNumbers = Console.readLine()!!
            .split(",")
            .map { validateLottoNumber(it.trim().toInt()) }
        return Lotto(winningNumbers)
    }

    fun getBonusNumber(): Int {
        var bonusNumber: Int
        while (true) {
            try {
                bonusNumber = readAndGetBonusNumber()
                break
            } catch (e: IllegalArgumentException) {
                println(e.message)
                println()
            }
        }
        return bonusNumber
    }

    fun readAndGetBonusNumber(): Int {
        println()
        println("Please enter the bonus number.")
        return validateLottoNumber(Console.readLine()?.toIntOrNull())
    }

    private fun validateLottoNumber(lottoNumber: Int?): Int {
        require(lottoNumber != null && lottoNumber in 1..45) {
            "[ERROR] Lotto numbers must be between 1 and 45."
        }
        return lottoNumber
    }
}