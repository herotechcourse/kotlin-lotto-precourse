package lotto.domain

class Bonus(private val number: Int) {

    companion object {
        private const val LOTTO_START_NUMBER = 1
        private const val LOTTO_END_NUMBER = 45
    }

    init {
        require(number in LOTTO_START_NUMBER..LOTTO_END_NUMBER) {
            "[ERROR] Lotto numbers must be between 1 and 45."
        }
    }

    fun isSame(other: Int): Boolean {
        return number == other
    }
}