package lotto.util

class StringParser private constructor() {

    companion object {
        private const val INVALID_NUMBER_ERROR = "[ERROR] Input value must be a number."

        fun parseToInt(input: String): Int {
            val round = input.toIntOrNull()
            require(round != null) { INVALID_NUMBER_ERROR }
            return round
        }
    }
}
