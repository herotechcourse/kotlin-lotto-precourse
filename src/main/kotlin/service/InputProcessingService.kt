package service

object InputProcessingService {

    fun validateInputInteger(input:String):Int {
        val number = input.toIntOrNull()
        require(number != null) { "The input must be a integer." }
        return number
    }

    fun validateNumberInLottoRange(number:Int){
        require(number in 1..45) { "The number must be between 1 and 45." }
    }

    fun splitWinningNumbers(numbers:String):List<Int> {
        return numbers.split(",").map { string ->
            string.let { validateInputInteger(it) }
                .also { validateNumberInLottoRange(it) }
        }
    }

    fun validatePurchaseAmount(number:Int) {
        require(number > 0) { "The purchase amount must be greater than 0." }
        require(number % 1000 == 0) { "The purchase amount must be a multiple of 1000." }
    }

    fun validateWinningNumbers(numberList:List<Int>) {
        require(numberList.size == 6) { "The number of winning numbers must be 6." }
        require(numberList.distinct().size == 6) { "The winning numbers must not contain duplicates." }
    }

    fun validateBonusNumber(number:Int , numberList:List<Int>){
        require(number !in numberList) { "The bonus number must be unique from the winning numbers." }
    }
}