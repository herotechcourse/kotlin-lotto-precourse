package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6) { "[ERROR] Lotto must contain exactly 6 numbers." }
        require(numbers.toSet().size == 6) { "[ERROR] Lotto must contain unique numbers." }
    }

    fun getNumbers () : List<Int> {
        return numbers
    }

    fun countMatchingNumbers (winningLotto : Lotto) : Int {
        val winningNumbers = winningLotto.getNumbers()
        return numbers.count { it in winningNumbers }
    }

    fun containsNumber (number : Int) : Boolean {
        return number in numbers
    }
}
