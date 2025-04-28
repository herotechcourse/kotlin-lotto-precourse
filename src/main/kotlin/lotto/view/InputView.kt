package lotto.view

import camp.nextstep.edu.missionutils.Console

object InputView {
    fun inputPurchase() : String {
        println("Please enter the purchase amount.")
        val input = Console.readLine()
        validatePriceInput(input)
        return input
    }

    fun inputWinNumbers() : List<Int> {
        println("Please enter last week's winning numbers.")
        val input = Console.readLine()
        validateWinNumber(input)
        return input.split(",").map {it.trim().toInt()}
    }

    fun inputBonusNumbers(winNumbers : List<Int>) : Int {
        println("Please enter the bonus number.")
        val input = Console.readLine()
        val bonus = validateBonusNumber(input, winNumbers)
        return bonus
    }

    private fun validateWinNumber(input:String) {
        // TODO : 입력갯수, 범위, 중복숫자, 콤마로 분리되어있는 지 체크하기
        val num = input.split(",").map {it.trim()}
        require(num.size == 6) { "[ERROR] You must enter exactly 6 numbers." }
        require( num.all { it.all { ch-> ch.isDigit() }}) { "[ERROR] All winning numbers must be numeric." }
        val intNumber = num.map{ it.toInt() }
        require(intNumber.all { it in 1..45 }) { "[ERROR] Winning numbers must be between 1 and 45." }
        require(intNumber.toSet().size == 6) { "[ERROR] Winning numbers must not contain duplicates." }
    }

    private fun validateBonusNumber(input:String, winNum : List<Int>) : Int {
        require(input.all { it.isDigit() }) { "[ERROR] Bonus number must be numeric." }
        val bonus = input.toInt()
        require(bonus in 1..45) { "[ERROR] Bonus number must be between 1 and 45." }
        require(!winNum.contains(bonus)) { "[ERROR] Bonus number must not be one of the winning numbers." }
        return bonus
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
