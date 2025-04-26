package lotto.service.validation

/**
 *  [ Background ]
 *  1. toSet() // Converts the list to a Set, removing duplicates.
 */
class ValidateWinningMain {

    fun typeValidate(inputs: List<Any>) {
        require(inputs.all { it is Int }) {
            "[ERROR] Winning numbers must be of integer type."
        }
    }

    fun validate(inputs: List<Int>) {
        require(inputs.isNotEmpty()) {
            "[ERROR] Winning numbers must not be empty."
        }

        require(inputs.size == 6) {
            "[ERROR] Winning numbers must contain exactly 6 numbers."
        }

        require(inputs.toSet().size == inputs.size) {
            "[ERROR] Winning numbers must be unique."
        }

        require(inputs.all { it in 1..45 }) {
            "[ERROR] Winning numbers must be between 1 and 45."
        }
    }
}