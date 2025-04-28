package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6) { "[ERROR] Lotto must contain exactly 6 numbers." }
        require(numbers.toSet().size == 6) { "[ERROR] Lotto must contain unique numbers." }
    }

    fun getLottoNumbers () : List<Int> {
        return numbers
    }

    fun countMatchingNumber (winningLotto : Lotto) : Int {
        val winningNumbers = winningLotto.getLottoNumbers()
        return numbers.count { it in winningNumbers }
    }

    fun checkForBonusNumber (bonusNumber : Int) : Boolean {
        return bonusNumber in numbers
    }
}
