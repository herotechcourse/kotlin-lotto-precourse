package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6) { "[ERROR] Lotto must contain exactly 6 numbers." }
        require(numbers.all { it in 1..45}) { "[ERROR] Numbers must be between 1 and 45." }
        require(numbers.size == numbers.distinct().size) { "[ERROR] Numbers must be unique. "}
    }

    fun contains(number: Int): Boolean = numbers.contains(number)

    fun countMatches(otherLotto: Lotto): Int = numbers.count { otherLotto.contains(it) }

    override fun toString(): String = numbers.sorted().toString()
}
