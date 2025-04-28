package lotto

import lotto.config.Config

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == Config.NUMBERS_PER_TICKET) { "[ERROR] Lotto must contain exactly 6 numbers." }
        require(numbers.size == numbers.toSet().size) { "[ERROR] Lotto numbers must not contain duplicates." }
        require(numbers.all { it in Config.LOTTO_MIN_NUMBER..Config.LOTTO_MAX_NUMBER }) { "[ERROR] Lotto numbers must be between 1 and 45." }

    }
    fun getNumbers(): List<Int> = numbers.sorted()

    fun matchCount(winningNumbers: Iterable<Int>): Int =
        numbers.count { it in winningNumbers }

    fun hasBonus(bonusNumber: Int): Boolean =
        numbers.contains(bonusNumber)
}