package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6) {
            "[ERROR] Lotto must contain exactly 6 numbers."
        }
        require(numbers.size == numbers.toSet().size) {
            "[ERROR] All numbers must be unique"
        }
    }

    fun getNumbers(): List<Int> {
        return numbers
    }
}
