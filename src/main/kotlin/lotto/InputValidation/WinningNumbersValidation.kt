package lotto.InputValidation
const val winning_numbers_size = 6

class WinningNumbersValidation {
    fun NullCheckWinningNumber(numbers : String){
        if(numbers.isNullOrEmpty()) throw IllegalArgumentException("[ERROR] Winning numbers cannot be empty. Enter 6 unique numbers.")
    }

    fun SplitNumbersIntoList(numbers: String):List<Int>{
        val winning_numbers = numbers.split(",").map { it.trim().toInt() }
        return winning_numbers
    }

}