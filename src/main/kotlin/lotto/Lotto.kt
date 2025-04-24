package lotto

class
Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6) {
            String.format(Messages.ERROR, Messages.ERROR_NOT_SIX_NUMBERS)
        }
    }

    fun getNumbers(): List<Int> {
        return numbers
    }
}
