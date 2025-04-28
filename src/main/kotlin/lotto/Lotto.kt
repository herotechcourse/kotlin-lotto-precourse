package lotto

import camp.nextstep.edu.missionutils.Randoms

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6) { "[ERROR] Lotto must contain exactly 6 numbers." }
    }
    fun getNumbers(): List<Int> = numbers

    // TODO: Implement additional functions
}

fun generateLotto() : Lotto {
    val numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6).sorted()
    return Lotto(numbers)
}