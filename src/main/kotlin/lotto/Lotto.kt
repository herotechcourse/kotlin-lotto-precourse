package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6) { "[ERROR] Lotto must contain exactly 6 numbers." }
        require(numbers.size == numbers.toSet().size) { "[ERROR] Lotto ticket must not have duplicate numbers." }
    }

    fun getNumbers(): List<Int> = numbers.toList()

    override fun toString(): String {
        return numbers.joinToString(prefix = "[", postfix = "]", separator = ", ")
    }
}
