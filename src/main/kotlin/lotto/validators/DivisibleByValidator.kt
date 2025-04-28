package lotto.validators

class DivisibleByValidator(private val divisor: Int) : InputValidator<Int> {

    init {
        require(divisor != 0) { "Divisor must not be zero." }
    }

    override fun validate(input: String): Int {

        val number = input.toInt()

        if (number % divisor != 0) {
            throw IllegalArgumentException("[ERROR] The purchase amount must be at least 1,000 and divisible by $divisor.")
        }

        return number
    }
}
