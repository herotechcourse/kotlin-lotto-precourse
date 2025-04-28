package lotto

import lotto.utils.Constants

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == Constants.LOTTO_NUMBER_COUNT) {
            "[ERROR] Lotto must contain exactly ${Constants.LOTTO_NUMBER_COUNT} numbers."
        }
        require(numbers.distinct().size == Constants.LOTTO_NUMBER_COUNT) {
            "[ERROR] Lotto numbers must be unique."
        }
        require(numbers.all { it in Constants.MINIMUM_VALID_NUMBER..Constants.MAXIMUM_VALID_NUMBER }) {
            "[ERROR] Lotto numbers must be between ${Constants.MINIMUM_VALID_NUMBER} and ${Constants.MAXIMUM_VALID_NUMBER}."
        }
    }

    fun getNumbers(): List<Int> = numbers.sorted()
}