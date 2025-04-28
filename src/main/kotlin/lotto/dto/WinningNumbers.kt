package lotto.dto

import lotto.validator.WinningNumbersValidator

data class WinningNumbers(val numbers: List<String>){
    init{
        WinningNumbersValidator.validate(numbers)
    }

    fun getWinningNumbers(): List<Int> {
        return numbers.map { it.toInt() }
    }
}
