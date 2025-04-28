package lotto.archive

class ValidateWinningBonus {
    fun validate(bonusNumber: Int, winningNumbers: List<Int>) {
        require(bonusNumber in 1..45) {
            "[ERROR] Bonus number must be between 1 and 45."
        }
        require(!winningNumbers.contains(bonusNumber)) {
            "[ERROR] Bonus number must not duplicate a winning number."
        }
    }
}