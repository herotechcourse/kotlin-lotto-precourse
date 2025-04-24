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
    fun SizeOfWinningNumberValidation(winning_numbers:List<Int>){
        if(winning_numbers.size != winning_numbers_size ) throw IllegalArgumentException("[ERROR] Enter 6 unique numbers.")
    }
    fun UniqueWinningNumbersValidation(winning_numbers : List<Int>){
        if(winning_numbers.distinct().size != winning_numbers_size ) throw IllegalArgumentException("[ERROR] Enter unique numbers only.")
    }

    fun ValidateWinningNumberInRange1to45(winning_numbers: List<Int>) {
        val isValid = winning_numbers.all { it in 1..45 }
        if(!isValid) throw IllegalArgumentException("[ERROR] Numbers must be between 1 and 45.")
    }

}