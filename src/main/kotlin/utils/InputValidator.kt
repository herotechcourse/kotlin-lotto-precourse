package utils

class InputValidator {
    companion object {

        fun validate(input: String): Int {
            checkNotBlank(input)
            val amount = parseToInt(input)
            checkDivisibleByThousand(amount)
            return calculateNumberOfLottos(amount)
        }

        fun validateBonusNum(input: String, numList: List<Int>): Int {
            checkNotBlank(input)
            val num = parseToInt(input)
            isInRange(num)
            isAlreadyIncluded(num, numList)
            return num
        }

        private fun checkNotBlank(input: String) {
            if (input.isBlank()) {
                throw IllegalArgumentException("[ERROR] Input cannot be null or empty.")
            }
        }

        private fun parseToInt(input: String): Int {
            try {
                return input.toInt()
            } catch (e: NumberFormatException) {
                throw IllegalArgumentException("[ERROR] You entered an invalid number. Please enter a valid integer.")
            }
        }

        private fun checkDivisibleByThousand(amount: Int) {
            if (amount % 1000 != 0) {
                throw IllegalArgumentException("[ERROR] Amount must be divisible by 1000.")
            }
        }

        private fun calculateNumberOfLottos(amount: Int): Int {
            return amount / 1000
        }

        private fun isInRange(num: Int): Boolean {
            if (num !in 1..45) {
                throw IllegalArgumentException("[ERROR] The bonus number need to be in range 1 to 45.")
            }
            return true
        }

        private fun isAlreadyIncluded(num: Int, numList: List<Int>): Boolean {
            if (numList.contains(num)) {
                throw IllegalArgumentException("[ERROR] This number is already in winning numbers, enter another one.")
            }
            return false
        }
    }
}