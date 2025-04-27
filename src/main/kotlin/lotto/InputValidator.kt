package lotto

object InputValidator {

    fun validateMoneyAmount(amount: String?): Int {
        val amountMoney = amount?.toIntOrNull()
        if ((amountMoney == null) || ((amountMoney % 1000) != 0)) {
            throw IllegalArgumentException("[ERROR] The amount must be integer and divisible by 1,000")
        }
        return amountMoney
    }

    fun validateMainNumbers(main: String): List<Int?> {
        val mainNumbers = main.split(",").map { it.trim() }.map { it.toIntOrNull() }
        if ((mainNumbers.size != 6) || (mainNumbers.toSet().size != 6)) {
            throw IllegalArgumentException("[ERROR] Main numbers must contain exact 6 unique numbers")
        }
        if (mainNumbers.any {it !in 1..45}) {
            throw IllegalArgumentException("[ERROR] Main number must be in the range 1..45")
        }
        return mainNumbers
    }

    fun validateBonusNumber(bonus: String, mainNumber: List<Int?>): Int? {
        val bonusNumber = bonus.toIntOrNull()
        if ((bonusNumber !in 1 .. 45) || (mainNumber.contains(bonusNumber) )) {
            throw IllegalArgumentException("[ERROR] Bonus numbers must be in the range 1 .. 45 and different to main numbers")
        }
        return bonusNumber
    }



}