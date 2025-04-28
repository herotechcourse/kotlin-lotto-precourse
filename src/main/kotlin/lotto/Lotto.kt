package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6) { "[ERROR] Lotto must contain exactly 6 numbers." }
        require(numbers.all { it in 1..45 }) {
            "[ERROR] Lotto numbers must be between 1 and 45."
        }
        require(numbers.distinct().size == numbers.size) { 
            "[ERROR] Lotto numbers must not contain duplicates." 
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

    // TODO: Implement additional functions
}
