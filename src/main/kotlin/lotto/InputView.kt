package lotto

import camp.nextstep.edu.missionutils.Console

class InputView {
    fun readPurchaseAmount(): Int {
        println("Purchase amount:")
        val input = Console.readLine()
        validatePurchaseAmount(input)
        return input.toInt()
    }

    fun readWinningNumbers(): List<Int> {
        println("Winning numbers:")
        val input = Console.readLine()
        validateWinningNumbers(input)
        return input.split(",").map(String::toInt)
    }

    fun readBonusNumber(): Int {
        println("Bonus number:")
        val input = Console.readLine()
        validateBonusNumber(input)
        return input.toInt()
    }

    private fun validatePurchaseAmount(input: String) {
        val amount = input.toIntOrNull()
        require(input.isNotEmpty()) { "[ERROR] Purchase amount must be non-empty" }
        require(amount != null) { "[ERROR] Purchase amount must be an integer" }
        require(amount >= 1000) { "[ERROR] Purchase amount must be more than 1000" }
    }

    private fun validateWinningNumbers(input: String) {
        val numbers = input.split(',').map(String::toIntOrNull)
        require(numbers.isNotEmpty()) { "[ERROR] Winning numbers must be non-empty" }
        require(LotteryUtil.isValidLottoSize(numbers)) { "[ERROR] Winning numbers must be 6 numbers" }
        require(numbers.all { LotteryUtil.isValidLottoNumber(it) }) { "[ERROR] Winning numbers must be between 1 and 45" }
    }

    private fun validateBonusNumber(input: String) {
        val number = input.toIntOrNull()
        require(input.isNotEmpty()) { "[ERROR] Bonus number must be non-empty" }
        require(LotteryUtil.isValidLottoNumber(number)) { "[ERROR] Bonus number must be between 1 and 45" }
    }

}