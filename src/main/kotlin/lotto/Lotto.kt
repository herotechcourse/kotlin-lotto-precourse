package lotto

import camp.nextstep.edu.missionutils.Randoms

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6) { "[ERROR] Lotto must contain exactly 6 numbers." }
    }

    fun getLottoNumbers () : List<Int> {
        return numbers
    }

    fun checkForWinningNumber git(winningNumbers : List<Int>) : Int {
        return numbers.count { it in winningNumbers }
    }

    fun checkForBonusNumber (bonusNumber : Int) : Boolean {
        return bonusNumber in numbers
    }
}
