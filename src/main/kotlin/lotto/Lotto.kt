package lotto

class Lotto(private val numbers: List<Int>) {

    init {
        require(numbers.size == SIZE) { "[ERROR] Lotto must contain exactly $SIZE numbers." }
        require(numbers.distinct().size == SIZE) { "[ERROR] Lotto numbers must not contain duplicates." }

    }

    fun getSortedNumbers(): List<Int> {
        return numbers.sorted()
    }

    companion object {
        const val SIZE = 6

        fun of(rawNumbers: List<Int>): Lotto {
            return Lotto(rawNumbers)
        }
    }

    override fun toString(): String {
        return getSortedNumbers().toString()
    }

    fun contains(number: Int): Boolean {
        return numbers.contains(number)
    }
}