package lotto.model 

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6) { "[ERROR] Lotto must contain exactly 6 numbers." }
        require(numbers.distinct().size == 6) { "[ERROR] Every numbers must be unique." }
    }

    // TODO: Implement additional functions
    fun match(winningNumbers: List<Int>): Int {
        return numbers.count { number in winningNumbers }
    }

    fun isBonusContain(bonusNumber: Int): Boolean {
        return number in numbers
    }

    fun getNumbers() {
        return numbers 
    }
}
