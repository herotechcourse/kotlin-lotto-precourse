package lotto.domain

import lotto.Lotto

class BonusNumber(private val bonus: Int, private val winningNumbers: List<Int>) {

    init {
        require(bonus in Lotto.MIN_NUMBER..Lotto.MAX_NUMBER) { "[ERROR] Bonus number must be between ${Lotto.MIN_NUMBER} and ${Lotto.MAX_NUMBER}" }
        require(bonus !in winningNumbers) { "[ERROR] Bonus number must not duplicate winning numbers." }
    }

    fun get(): Int = bonus

}