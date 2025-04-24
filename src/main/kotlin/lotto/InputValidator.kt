package lotto

class InputValidator {
    companion object{
        fun validate(input : String):Int{
            if (input.isBlank()) {
                throw IllegalArgumentException("Input cannot be null or empty. Please enter a valid amount divisible by 1000.")
            }
            try {
                val amount = input.toInt()
                if (amount % 1000 != 0) {
                    throw IllegalArgumentException("Amount must be divisible by 1000.")
                }
                return amount/1000
            } catch (e: NumberFormatException) {
                throw IllegalArgumentException("You entered an invalid number. Please enter a valid integer.")
            }
        }
    }
}