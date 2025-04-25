package lotto.utils

import lotto.Lotto
import lotto.model.WinnerLotto

object InputParser {
    fun parsePurchaseAmount(amount: String): Long =
        amount.toLongOrNull() ?: throw IllegalArgumentException("Purchase amount must be numeric number")

    fun parseWinnerLottoNumbers(numbers: String): List<Int> = try {
        numbers.split(",").map { it.trim().toInt() }
    } catch (e: Exception) {
        throw IllegalArgumentException("Winner Lotto Numbers must be numeric number")
    }

    fun parseWinnerBonusNumber(number: String): Int =
        number.toIntOrNull() ?: throw IllegalArgumentException("Bonus number must be numeric number")

}