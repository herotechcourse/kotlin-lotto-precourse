package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6) { "[ERROR] Lotto must contain exactly 6 numbers." }
    }

    fun display(): String {
        return numbers.joinToString(", ", prefix = "[", postfix = "]")
    }

    fun sort(): Lotto {
        return Lotto(numbers.sorted())
    }
}
