package lotto.util

import lotto.Lotto

object InputValidator {

    fun validateMoneyAmount(amount: String?): Int {
        val amountMoney = amount?.toIntOrNull()
        if ((amountMoney == null) || ((amountMoney % Lotto.PRICE_TICKET) != 0)) {
            throw IllegalArgumentException("[ERROR] The amount must be integer and divisible by 1,000")
        }
        return amountMoney
    }

    fun validateMainNumbers(main: String): List<Int?> {
        val mainNumbers = main.split(",").map { it.trim() }.map { it.toIntOrNull() }
        if ((mainNumbers.size != Lotto.SIZE_LOTTO) || (mainNumbers.toSet().size != Lotto.SIZE_LOTTO)) {
            throw IllegalArgumentException("[ERROR] Main numbers must contain exact 6 unique numbers")
        }
        if (mainNumbers.any {it !in Lotto.MIN_VALUE_LOTTO..Lotto.MAX_VALUE_LOTTO }) {
            throw IllegalArgumentException("[ERROR] Main number must be in the range 1..45")
        }
        return mainNumbers
    }

    fun validateBonusNumber(bonus: String, mainNumber: List<Int?>): Int? {
        val bonusNumber = bonus.toIntOrNull()
        if ((bonusNumber !in Lotto.MIN_VALUE_LOTTO..Lotto.MAX_VALUE_LOTTO) || (mainNumber.contains(bonusNumber) )) {
            throw IllegalArgumentException("[ERROR] Bonus numbers must be in the range ${Lotto.MIN_VALUE_LOTTO} .. ${Lotto.MAX_VALUE_LOTTO} and different to main numbers")
        }
        return bonusNumber
    }



}