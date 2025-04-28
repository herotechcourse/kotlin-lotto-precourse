package service

object InputProcessingService {

    fun validateInputInteger(input:String):Int {
        val number = input.toIntOrNull()
        require(number != null) { "The input must be a integer." }
        require(number in 1..45) { "The input number must be between 1 and 45." }
        return number
    }

    fun splitWinningNumbers(numbers:String):List<Int> {
        return numbers.split(",").map { validateInputInteger(it) }
    }

    fun validatePurchaseAmount(number:Int) {
        require(number > 0) { "The purchase amount must be greater than 0." }
        require(number % 1000 == 0) { "The purchase amount must be a multiple of 1000." }
    }

    fun validateWinningNumbers(numberList:List<Int>) {
        require(numberList.size == 6) { "The number of winning numbers must be 6." }
        require(numberList.distinct().size == 6) { "The winning numbers must not contain duplicates." }
    }
}