package lotto.view

class InputParser {
    fun parsePurchaseAmount(input: String): Int {
        try {
            return input.toInt()
        } catch (exception: NumberFormatException) {
            throw IllegalArgumentException("Input is not a number.")
        }
    }
}
