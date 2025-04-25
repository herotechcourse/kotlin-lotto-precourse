package lotto

import camp.nextstep.edu.missionutils.Randoms

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6) { "[ERROR] Lotto must contain exactly 6 numbers." }
        require(numbers.distinct().size == 6) { "[ERROR] Lotto numbers must be unique." }
        require(numbers.all { it in 1..45 }) { "[ERROR] Lotto numbers must be between 1 and 45." }
    }

    fun getNumbers(): List<Int> {
        return numbers
    }

    override fun toString():String {
        return "$numbers"
    }

    companion object {
        fun getUniqueNumbers(): List<Int> {            
            return Randoms.pickUniqueNumbersInRange(1, 45, 6)
        }
    }
}
