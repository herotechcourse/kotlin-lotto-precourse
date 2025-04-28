package lotto.domain

class WinningLotto(
    private val numbers: List<Int>,
    private val bonusNumber: Int
) {
    init {
        require(numbers.size == 6) { 
            "[ERROR] Winning numbers must contain exactly 6 numbers." 
        }
        require(numbers.all { it in 1..45 }) {
            "[ERROR] Winning numbers must be between 1 and 45."
        }
        require(numbers.size == numbers.distinct().size) {
            "[ERROR] Winning numbers must be unique."
        }
        require(bonusNumber in 1..45) {
            "[ERROR] Bonus number must be between 1 and 45."
        }
        require(!numbers.contains(bonusNumber)) {
            "[ERROR] Bonus number must not be included in the winning numbers."
        }
    }
    
    fun getPrize(lotto: Lotto): Prize {
        val matchCount = lotto.matchCount(numbers)
        val hasBonus = lotto.containsNumber(bonusNumber)
        
        return Prize.getByMatchResult(matchCount, hasBonus)
    }
} 