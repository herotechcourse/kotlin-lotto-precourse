package lotto

class Lotto(val numbers: List<Int>) {
    init {
        require(numbers.size == 6) { LottoMessages.sixNumbers }
        require(numbers.distinct().size == numbers.size) { LottoMessages.duplicate }
        require(numbers.all { it in 1..45 }) { LottoMessages.rangeOneToFortyfive }
    }

    // TODO: Implement additional functions
}
