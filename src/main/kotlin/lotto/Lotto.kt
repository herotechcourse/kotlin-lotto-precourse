package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        validateNumbers(numbers)
    }

    private fun validateNumbers(numbers: List<Int>) {
        require(numbers.size == 6) { "[ERROR] Lotto must contain exactly 6 numbers." }
        require(numbers.toSet().size == 6) { "[ERROR] Lotto numbers must be unique." }
        require(numbers.all { it in 1..45 }) { "[ERROR] Lotto numbers must be between 1 and 45." }
    }

    fun getNumbers(): List<Int> = numbers.toList() // Returns a copy to ensure immutability

    fun contains(number: Int): Boolean = number in numbers

    fun getSortedNumbers(): List<Int> = numbers.sorted()

    override fun toString(): String = getSortedNumbers().toString()
}