package lotto

object LottoValidators {
    fun validatePurchase(amount: Int) {
        require(amount > 0) { "[ERROR] amount must be a positive number." }
        require(amount % LottoFactory.TICKET_PRICE == 0) { "[ERROR] Each ticket costs 1,000 KRW" }
    }

    fun validateWinningNumber(numbers: List<Int>) {
        require(numbers.size == Lotto.NUMBER_COUNT) { "Exactly ${Lotto.NUMBER_COUNT} numbers must be entered." }
        require(numbers.toSet().size == Lotto.NUMBER_COUNT) { "Duplicate numbers are not allowed." }
        require(numbers.all { it in Lotto.MIN_NUMBER..Lotto.MAX_NUMBER }) { "Numbers must be between ${Lotto.MIN_NUMBER} and ${Lotto.MAX_NUMBER}." }
    }

    fun validateBonusNumber(bonus: Int, winning: Collection<Int>) {
        require(bonus !in winning) { "[ERROR] Bonus number must not duplicate winning numbers." }
        require(bonus in Lotto.MIN_NUMBER..Lotto.MAX_NUMBER) { "[ERROR] Numbers must be between ${Lotto.MIN_NUMBER} and ${Lotto.MAX_NUMBER}." }
    }
}