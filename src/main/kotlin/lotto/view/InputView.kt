package lotto.view

import camp.nextstep.edu.missionutils.Console

object InputView {
    fun inputPurchase() : String {
        println("Enter the price: ")
        val input = Console.readLine()
        validatePriceInput(input)
        return input
    }

    fun inputWinNumbers() : List<Int> {
        println("Enter winning numbers (comma-separated): ")
        val input = Console.readLine()
        validateWinNumber(input)
        return input.split(",").map {it.trim().toInt()}
    }

    fun inputBonusNumbers() : String {
        println("Enter the bonus number: ")
        val input = Console.readLine()
        validateBonusNumber(input, inputWinNumbers())
        return input
    }

    private fun validateWinNumber(input:String) {
        // 입력갯수, 범위, 중복숫자, 콤마로 분리되어있는 지 체크
        val num = input.split(",").map {it.trim()}
        require(num.size == 6) { "[ERROR] You must enter exactly 6 numbers." }
        require( num.all { it.all { ch-> ch.isDigit() }}) { "[ERROR] All winning numbers must be numeric." }
        val intNumber = num.map{ it.toInt() }
        require(intNumber.all { it in 1..45 }) { "[ERROR] Winning numbers must be between 1 and 45." }
        require(intNumber.toSet().size == 6) { "[ERROR] Winning numbers must not contain duplicates." }
    }

    private fun validateBonusNumber(input:String, winNum : List<Int>) {
        require(input.all { it.isDigit() }) { "[ERROR] Bonus number must be numeric." }
        val bonus = input.toInt()
        require(bonus in 1..45) { "[ERROR] Bonus number must be between 1 and 45." }
        require(!winNum.contains(bonus)) { "[ERROR] Bonus number must not be one of the winning numbers." }
    }


    private fun validatePriceInput(input:String) {
        require(input.all {it.isDigit()}) { "[ERROR] Input must be numeric." }
        val amount = try {
            input.toLong()
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException("[ERROR] The amount is not within a realistic range.")
        }
        require(amount % 1000 == 0L) { "[ERROR] Amount must be divisible by 1,000."}
    }
}
