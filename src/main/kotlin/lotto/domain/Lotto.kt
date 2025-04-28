package lotto.domain

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6) { 
            "[ERROR] Lotto must contain exactly 6 numbers." 
        }
        require(numbers.all { it in 1..45 }) {
            "[ERROR] Lotto numbers must be between 1 and 45."
        }
        require(numbers.distinct().size == 6) { 
            "[ERROR] 로또 번호에 중복이 있으면 안됩니다."
        }
    }
    
    fun getNumbers(): List<Int> {
        return numbers.sorted()
    }
    
    fun matchCount(winningNumbers: List<Int>): Int {
        return numbers.count { it in winningNumbers }
    }
    
    fun containsNumber(number: Int): Boolean {
        return numbers.contains(number)
    }
} 