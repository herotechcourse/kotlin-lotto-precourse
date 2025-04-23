package lotto

import camp.nextstep.edu.missionutils.Console


object InputView {
    fun readPurchaseAmount(): Int {
        val amount = Console.readLine().toInt()
        Validator.validateAmount(amount)
        return amount
    }

    fun raedWinnerNumbers(): List<Int> {
        val winnerNumbers = Console.readLine()
            .split(",")
            .map { it.trim().toInt() }
        Validator.validateWinningNumbers(winnerNumbers)
        return winnerNumbers
    }

    fun readBonusNumber(winningNumbers: List<Int>): Int {
        val bonus = Console.readLine().toInt()
        Validator.validateBonusNumber(bonus, winningNumbers)
        return bonus
    }

}