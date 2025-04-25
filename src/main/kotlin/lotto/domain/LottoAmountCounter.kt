package lotto.domain

class LottoAmountCounter() {
    fun count(amount: Int): Int {
        require(amount % LOTTO_UNIT_PRICE == 0 ) { INVALID_LOTTO_AMOUNT}
        return amount / 1000
    }

    companion object {
        const val LOTTO_UNIT_PRICE = 1000
        const val INVALID_LOTTO_AMOUNT = "[ERROR] lotto amount must be divisible by 1,000"
    }
}