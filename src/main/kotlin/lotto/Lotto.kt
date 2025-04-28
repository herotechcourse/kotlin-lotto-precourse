package lotto

import camp.nextstep.edu.missionutils.Randoms

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6) { "[ERROR] Lotto must contain exactly 6 numbers." }
        require(numbers.all { it in 1..45 }) { "[ERROR] Lotto numbers must be between 1 and 45." }
        require(numbers.distinct().size == 6) { "[ERROR] Lotto numbers must be unique." }
    }

    companion object {
        private const val LOTTO_PRICE = 1000
        private const val MIN_NUMBER = 1
        private const val MAX_NUMBER = 45
        private const val NUMBERS_COUNT = 6

        fun generateLotto(): Lotto {
            val numbers = Randoms.pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, NUMBERS_COUNT)
            return Lotto(numbers.sorted())
        }

        fun generateLottos(amount: Int): List<Lotto> {
            require(amount > 0) { "[ERROR] Amount must be positive." }
            return List(amount) { generateLotto() }
        }

        fun calculatePrize(matchCount: Int, hasBonus: Boolean): Int {
            return when {
                matchCount == 6 -> 2_000_000_000
                matchCount == 5 && hasBonus -> 30_000_000
                matchCount == 5 -> 1_500_000
                matchCount == 4 -> 50_000
                matchCount == 3 -> 5_000
                else -> 0
            }
        }
    }

    fun getNumbers(): List<Int> = numbers.toList()

    fun countMatches(winningNumbers: List<Int>): Int {
        return numbers.count { it in winningNumbers }
    }

    fun hasBonusNumber(bonusNumber: Int): Boolean {
        return numbers.contains(bonusNumber)
    }
}
