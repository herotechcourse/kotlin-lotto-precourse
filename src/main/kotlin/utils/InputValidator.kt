package utils

class InputValidator {
    companion object{
        fun validate(input : String):Int{
            if (input.isBlank()) {
                throw IllegalArgumentException("Input cannot be null or empty.")
            }
            try {
                val amount = input.toInt()
                if (amount % 1000 != 0) {
                    throw IllegalArgumentException("Amount must be divisible by 1000.")
                }
                val numberOfLottos = amount/1000
                return numberOfLottos
            } catch (e: NumberFormatException) {
                throw IllegalArgumentException("You entered an invalid number. Please enter a valid integer.")
            }
        }
    }
}