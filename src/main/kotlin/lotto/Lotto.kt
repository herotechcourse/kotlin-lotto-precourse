package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6) { "[ERROR] Lotto must contain exactly 6 numbers." }
        validateNumbers(this.numbers)
    }

    // TODO: Implement additional functions
    fun validateNumbers(numbers: List<Int>) {
        for (number in numbers) {
            if (numbers.indexOf(number) != numbers.lastIndexOf(number)) {
                throw IllegalArgumentException("[ERROR] Lotto numbers must be unique.")
            }
        }
    }
}
