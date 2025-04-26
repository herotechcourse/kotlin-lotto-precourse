package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6) { "[ERROR] Lotto must contain exactly 6 numbers." }
        require(numbers.toSet().size == 6) { "[ERROR] Lotto numbers must not contain duplicates." }
    }

    override fun toString(): String {
        return numbers.sorted().joinToString(", ", prefix = "[", postfix = "]")
    }
}
