package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == Constants.LOTTO_NUMBER_COUNT) { Constants.ERROR_INVALID_LOTTO_COUNT }
        require(numbers.toSet().size == Constants.LOTTO_NUMBER_COUNT) { Constants.ERROR_LOTTO_NUMBERS_UNIQUE }
        require(numbers.all { it in Constants.MIN_NUMBER..Constants.MAX_NUMBER }) { Constants.ERROR_LOTTO_BETWEEN }
    }

    // TODO: Implement additional functions
    fun getNumbers(): List<Int> = numbers
    fun contains(number: Int): Boolean = numbers.contains(number)
}
