package lotto.model

class Lotto(numbers: List<Int>) {
    val numbers: List<Int>

    init {
        validateNumbers(numbers)

        this.numbers = numbers.sorted()
    }

    override fun toString(): String {
        return numbers.toString()
    }

    companion object {
        fun validateNumbers(numbers: List<Int>) {
            require(numbers.size == 6) { "[ERROR] Lotto must contain exactly 6 numbers." }
            require(numbers.toSet().size == 6) { "[ERROR] Lotto numbers must be unique." }
            require(numbers.all { it in 1..45 }) { "[ERROR] Lotto numbers must be between 1 and 45." }
        }
    }
}