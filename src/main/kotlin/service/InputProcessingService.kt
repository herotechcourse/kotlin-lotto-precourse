package service

object InputProcessingService {

    fun validateInputInteger(input:String):Int {
        val number = input.toIntOrNull()
        require(number != null) { "The input must be a integer." }
        require(number in 1..45) { "The input number must be between 1 and 45." }
        return number
    }
}