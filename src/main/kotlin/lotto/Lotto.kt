package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6) { "[ERROR] Lotto must contain exactly 6 numbers." }

        require(numbers.toSet().size == numbers.size) {
            "[ERROR] Lotto numbers must be unique."
        }
        numbers.forEach {
            require(it in Config.MIN_LOTTO_NUMBER..Config.MAX_LOTTO_NUMBER) {
                "[ERROR] Lotto numbers must be between ${Config.MIN_LOTTO_NUMBER} and ${Config.MAX_LOTTO_NUMBER}."
            }
        }
    }

    fun getNumbers(): List<Int> = numbers

    fun countMatchingNumbers(winningNumbers: List<Int>): Int =
        numbers.count { it in winningNumbers }

    fun hasNumber(number: Int): Boolean = number in numbers
}
