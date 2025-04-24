package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6) { "[ERROR] Lotto must contain exactly 6 numbers." }
    }

    override fun toString(): String {
        return numbers.toString()
    }

    fun numbers(): List<Int> = numbers

}
