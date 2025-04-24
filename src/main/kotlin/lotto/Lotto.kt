package lotto

class Lotto(private val numbers: List<Int>) {

    init {
        require(numbers.size == LOTTO_SIZE) { "Lotto must contain exactly $LOTTO_SIZE numbers." }
        require(numbers.toSet().size == LOTTO_SIZE) { "Lotto numbers must be unique." }
        require(numbers.all { it in NUMBER_RANGE }) { "Lotto numbers must be between ${NUMBER_RANGE.first} and ${NUMBER_RANGE.last}." }
    }

    fun matchCount(winningLotto: Lotto): Int = numbers.count(winningLotto::contains)

    fun contains(number: Int): Boolean = number in numbers

    fun getNumbers(): List<Int> = numbers.toList()

    companion object {
        private const val LOTTO_SIZE: Int = 6
        private val NUMBER_RANGE = 1..45
    }
}
