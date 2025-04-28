package lotto.view

import camp.nextstep.edu.missionutils.Console

object InputView {
    fun inputPurchase(): String {
        println(MESSAGE_ENTER_PURCHASE_AMOUNT)
        val input = Console.readLine()
        validatePriceInput(input)
        return input
    }

    fun inputWinNumbers(): List<Int> {
        println(MESSAGE_ENTER_WINNING_NUMBERS)
        val input = Console.readLine()
        validateWinNumber(input)
        return input.split(",").map { it.trim().toInt() }
    }

    fun inputBonusNumbers(winNumbers: List<Int>): Int {
        println(MESSAGE_ENTER_BONUS_NUMBER)
        val input = Console.readLine()
        return validateBonusNumber(input, winNumbers)
    }

    fun validateWinNumber(input: String) {
        val num = input.split(",").map { it.trim() }
        require(num.size == 6) { ERROR_WIN_NUMBERS_SIZE }
        require(num.all { it.all { ch -> ch.isDigit() } }) { ERROR_WIN_NUMBERS_NUMERIC }
        val intNumber = num.map { it.toInt() }
        require(intNumber.all { it in 1..45 }) { ERROR_WIN_NUMBERS_RANGE }
        require(intNumber.toSet().size == 6) { ERROR_WIN_NUMBERS_DUPLICATE }
    }

    fun validateBonusNumber(input: String, winNum: List<Int>): Int {
        require(input.all { it.isDigit() }) { ERROR_BONUS_NUMBER_NUMERIC }
        val bonus = input.toInt()
        require(bonus in 1..45) { ERROR_BONUS_NUMBER_RANGE }
        require(!winNum.contains(bonus)) { ERROR_BONUS_NUMBER_DUPLICATE }
        return bonus
    }

    fun validatePriceInput(input: String) {
        require(input.all { it.isDigit() }) { ERROR_PURCHASE_AMOUNT_NUMERIC }
        val amount = try {
            input.toLong()
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException(ERROR_PURCHASE_AMOUNT_REALISTIC)
        }
        require(amount % 1000 == 0L) { ERROR_PURCHASE_AMOUNT_DIVISIBLE }
    }

    private const val MESSAGE_ENTER_PURCHASE_AMOUNT = "Please enter the purchase amount."
    private const val MESSAGE_ENTER_WINNING_NUMBERS = "Please enter last week's winning numbers."
    private const val MESSAGE_ENTER_BONUS_NUMBER = "Please enter the bonus number."

    private const val ERROR_WIN_NUMBERS_SIZE = "[ERROR] You must enter exactly 6 numbers."
    private const val ERROR_WIN_NUMBERS_NUMERIC = "[ERROR] All winning numbers must be numeric."
    private const val ERROR_WIN_NUMBERS_RANGE = "[ERROR] Winning numbers must be between 1 and 45."
    private const val ERROR_WIN_NUMBERS_DUPLICATE = "[ERROR] Winning numbers must not contain duplicates."

    private const val ERROR_BONUS_NUMBER_NUMERIC = "[ERROR] Bonus number must be numeric."
    private const val ERROR_BONUS_NUMBER_RANGE = "[ERROR] Bonus number must be between 1 and 45."
    private const val ERROR_BONUS_NUMBER_DUPLICATE = "[ERROR] Bonus number must not be one of the winning numbers."

    private const val ERROR_PURCHASE_AMOUNT_NUMERIC = "[ERROR] Input must be numeric."
    private const val ERROR_PURCHASE_AMOUNT_REALISTIC = "[ERROR] The amount is not within a realistic range."
    private const val ERROR_PURCHASE_AMOUNT_DIVISIBLE = "[ERROR] Amount must be divisible by 1,000."
}
