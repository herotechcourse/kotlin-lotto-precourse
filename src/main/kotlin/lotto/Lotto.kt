package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6) { "[ERROR] Lotto must contain exactly 6 numbers." }
    }

    fun showNumbers() {
        println(numbers)
    }

    fun calculateMatches(winningCombination: List<Int>): Int {
        return numbers.filter({ value -> winningCombination.contains(value) }).size
    }
    // TODO: Implement additional functions
}
