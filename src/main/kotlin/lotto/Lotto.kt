package lotto 

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6) { "[ERROR] Lotto must contain exactly 6 numbers." }
        require(numbers.distinct().size == 6) { "[ERROR] Every numbers must be unique." }
        require(numbers.all { number -> number in 1..45 }) { "[ERROR] Numbers must be in the range 1 ~ 45." }
    }

    // TODO: Implement additional functions
    fun match(winningLotto: Lotto): Int {
        return numbers.count { number -> number in winningLotto.getNumbers() }
    }

    fun isBonusContain(bonusNumber: Int): Boolean {
        return bonusNumber in numbers
    }

    fun getNumbers(): List<Int> {
        return numbers.sorted() 
    }
}
