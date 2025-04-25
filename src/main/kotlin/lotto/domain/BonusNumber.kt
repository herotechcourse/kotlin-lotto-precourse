package lotto.domain

class BonusNumber(
    val number: LottoNumber,
    winningNumbers: WinningNumbers
) {
    init {
        require(!winningNumbers.contains(number)) {
            "[ERROR] Bonus number must not be included in the winning numbers."
        }
    }

    override fun toString(): String = number.toString()
}