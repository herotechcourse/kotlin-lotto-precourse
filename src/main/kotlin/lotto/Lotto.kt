package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6) { LottoErrorEnum.INVALID_SIZE.message }
        require(numbers.all { it in 1..45 }) { LottoErrorEnum.NUMBER_OUT_OF_RANGE.message }
        require(numbers.size == numbers.distinct().size) { LottoErrorEnum.DUPLICATED_NUMBER.message }
    }

    fun getNumbers(): List<Int> {
        return numbers
    }
}
