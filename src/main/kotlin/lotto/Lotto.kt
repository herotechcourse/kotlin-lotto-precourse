package lotto

class Lotto(private val numbers: List<Int>) {

    init {
        require(numbers.size == 6) { "[ERROR] Lotto must contain exactly 6 numbers." }
        require(numbers.toSet().size == 6) { "[ERROR] Lotto numbers must be unique." }
    }

    fun matchCount(winningLotto: Lotto): Int {
        return numbers.count {winningLotto.numbers.contains(it)}
    }

    fun containBonus(bonus: Int): Boolean {
        return numbers.contains(bonus)
    }
}
