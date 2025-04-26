package lotto.validation

object Input {

    fun isEmpty(input: String?) {
        if (input.isNullOrEmpty()) {
            throw IllegalArgumentException("[ERROR] Input is empty")
        }
    }

    fun isInteger(input: String) {
        val number = input.toIntOrNull() ?: throw IllegalArgumentException("[ERROR] Input is not integer.")
    }

    fun isPositiveInteger(input: Int) {
        if (input <= 0) {
            throw IllegalArgumentException("[ERROR] Input must be positive integer.")
        }
    }

    fun isDivisible(input: Int, divisor: Int) {
        if (input % divisor != 0) {
            throw IllegalArgumentException("[ERROR] Input must be divisible by $divisor.")
        }
    }

    fun isInRange(input: Int, start: Int, end: Int) {
        if (input < start || input > end) {
            throw IllegalArgumentException("[ERROR] Input must be between $start and $end inclusive.")
        }
    }

    fun isEachInteger(input: List<String>) {
        input.forEach {
            if (it.toIntOrNull() == null) {
                throw IllegalArgumentException("[ERROR] Each input must be an integer.")
            }
        }
    }

    fun winningNumbersDuplication(input: List<Int>) {
        if (input.size != input.toSet().size) {
            throw IllegalArgumentException("[ERROR] Winning numbers must not be duplicated.")
        }
    }

    fun bonusNumberDuplication(input: Int, numbers: List<Int>) {
        if (input in numbers) {
            throw IllegalArgumentException("[ERROR] Bonus number must not be duplicated with the winning numbers")
        }
    }
}