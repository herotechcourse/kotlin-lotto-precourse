package lotto

import camp.nextstep.edu.missionutils.Randoms;


class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6) { "[ERROR] Lotto must contain exactly 6 numbers." }
        require(numbers.toSet().size == 6) { "[ERROR] Lotto must be composed with unique numbers" }
    }

    override fun toString(): String {
        return numbers.toString()
    }

    companion object {
        fun generate(): Lotto {
            val numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6)
            return Lotto(numbers.sorted())
        }
    }

    fun getNumbers(): List<Int> {
        return numbers.toList()
    }


}
