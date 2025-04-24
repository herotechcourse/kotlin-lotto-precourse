package lotto

class
Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6) {
            String.format(Messages.ERROR, Messages.ERROR_NOT_SIX_NUMBERS)
        }
        require(numbers.toSet().size == numbers.size) {
            String.format(Messages.ERROR, Messages.ERROR_NOT_UNIQUE)
        }
        require(numbers.all { it in 1..45 }) {
            String.format(Messages.ERROR, Messages.ERROR_OUT_OF_RANGE)
        }
    }

    fun getNumbers(): List<Int> {
        return numbers
    }
}
