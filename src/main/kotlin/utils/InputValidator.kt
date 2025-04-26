package utils

class InputValidator {
    companion object{
//        fun validate(input : String):Int{
//            if (input.isBlank()) {
//                throw IllegalArgumentException("Input cannot be null or empty.")
//            }
//            try {
//                val amount = input.toInt()
//                if (amount % 1000 != 0) {
//                    throw IllegalArgumentException("Amount must be divisible by 1000.")
//                }
//                val numberOfLottos = amount/1000
//                return numberOfLottos
//            } catch (e: NumberFormatException) {
//                throw IllegalArgumentException("You entered an invalid number. Please enter a valid integer.")
//            }
//        }
fun validate(input: String): Int {
    checkNotBlank(input)
    val amount = parseToInt(input)
    checkDivisibleByThousand(amount)
    return calculateNumberOfLottos(amount)
}
fun validateBonusNum(input: String):Int{
    checkNotBlank(input)
    val num = parseToInt(input)
    isInRange(num)
    return num
}
        private fun checkNotBlank(input: String) {
            if (input.isBlank()) {
                throw IllegalArgumentException("[Error] Input cannot be null or empty.")
            }
        }

        private fun parseToInt(input: String): Int {
            try {
                return input.toInt()
            } catch (e: NumberFormatException) {
                throw IllegalArgumentException("[Error] You entered an invalid number. Please enter a valid integer.")
            }
        }

        private fun checkDivisibleByThousand(amount: Int) {
            if (amount % 1000 != 0) {
                throw IllegalArgumentException("[Error] Amount must be divisible by 1000.")
            }
        }

        private fun calculateNumberOfLottos(amount: Int): Int {
            return amount / 1000
        }
        private fun isInRange(num : Int):Boolean{
            if (num !in 1..45){
                throw IllegalArgumentException("[Error] The bonus number need to be in range 1 to 45.")
            }
            return true
        }
    }
}