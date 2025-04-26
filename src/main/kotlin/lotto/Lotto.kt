package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6) { "[ERROR] Lotto must contain exactly 6 numbers." }
    }

    fun getHitNumberResult(winningNumbers: List<Int>): Int {
        return numbers.count { it in winningNumbers }
    }

    fun containsBonus(bonusNumber: Int): Boolean {
        return numbers.contains(bonusNumber)
    }

    override fun toString(): String {
        return numbers.toString()
    }
}
