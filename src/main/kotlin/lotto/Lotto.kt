package lotto

class
Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == LottoConstants.NUMBERS_PER_TICKET) {
            String.format(Messages.ERROR, Messages.ERROR_NOT_SIX_NUMBERS)
        }
        require(numbers.toSet().size == numbers.size) {
            String.format(Messages.ERROR, Messages.ERROR_NOT_UNIQUE)
        }
        require(numbers.all {
            it in LottoConstants.MIN_NUMBER..LottoConstants.MAX_NUMBER
        }) {
            String.format(Messages.ERROR, Messages.ERROR_OUT_OF_RANGE)
        }
    }

    fun getNumbers(): List<Int> {
        return numbers
    }

    fun countHits(winningNumbers: List<Int>): Int {
        return numbers.count { it in winningNumbers }
    }

    fun containsBonus(bonusNumber: Int): Boolean {
        return numbers.contains(bonusNumber)
    }
}
