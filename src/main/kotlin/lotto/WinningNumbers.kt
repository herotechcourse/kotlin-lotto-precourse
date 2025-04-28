package lotto
import lotto.Lotto

class WinningNumbers(numbers: List<Int>, val bonusNumber: Int): Lotto(numbers){
    val bonusBitmask: Long
    init {
        require(!numbers.contains(bonusNumber)) { "[ERROR] Bonus number must be different from winning"}

        bonusBitmask = 1L shl bonusNumber
    }
}