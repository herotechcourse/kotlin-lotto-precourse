package lotto

import lotto.constants.HIGHEST_NUMBER
import lotto.constants.LOWEST_NUMBER
import lotto.constants.TICKET_COST

class UserInput{

    init {
        require(TICKET_COST > 0) {
            "[Error] TICKET_COST (${TICKET_COST}) must be greater than 0."
        }
        require(LOWEST_NUMBER < HIGHEST_NUMBER) {
            "[Error] LOWEST_NUMBER (${LOWEST_NUMBER}) must be smaller than HIGHEST_NUMBER (${HIGHEST_NUMBER})."
        }
    }

    var purchaseAmount: Int = 0
        private set
    var winningNumbers: MutableList<Int> = mutableListOf()
        private set
    var bonusNumber: Int = 0
        private set

    fun setPurchaseAmount(input: String) {
        val purchaseAmount = input.toIntOrNull()

        sanitizePurchaseAmount(purchaseAmount)
        if (purchaseAmount != null) {
            this.purchaseAmount = purchaseAmount
        }
    }

    private fun sanitizePurchaseAmount(purchaseAmount: Int?) {
        require(purchaseAmount != null) {
            "[ERROR] Purchase amount must be a number."
        }
        require(purchaseAmount >= 0) {
            "[ERROR] Purchase amount must be a positive number."
        }
        require(purchaseAmount >= TICKET_COST) {
            "[ERROR] Purchase amount must be equal or greater than ${TICKET_COST}."
        }
        require(purchaseAmount % TICKET_COST == 0) {
            "[ERROR] Purchase amount must be a multiple of ${TICKET_COST}."
        }
    }

    fun setWinningNumbers(input: String) {
        val splitNumbers = input.split(",").map { it.trim() }
        val numbers = mutableListOf<Int>()

        for (splitNumber in splitNumbers) {
            val number = splitNumber.toIntOrNull()
            sanitizeNumber(number)
            if (number != null) {
                numbers.add(number)
            }
        }
        sanitizeNumbers(numbers)

        this.winningNumbers = numbers
    }

    private fun sanitizeNumber(number: Int?){
        require(number != null) {
            "[ERROR] All entries must be a number."
        }
        require(number >= LOWEST_NUMBER && number <= HIGHEST_NUMBER) {
            "[ERROR] All numbers must be between ${LOWEST_NUMBER} and ${HIGHEST_NUMBER} ($number)."
        }
    }

    private fun sanitizeNumbers(numbers: MutableList<Int>){
        require(numbers.size == numbers.toSet().size) {
            "[ERROR] All numbers must be unique"
        }
        require(numbers.size == 6) {
            "[ERROR] There must be exactly 6 winning numbers."
        }
    }

    fun setBonusNumber(input: String) {
        val bonusNumber = input.toIntOrNull()

        sanitizeBonusNumber(bonusNumber)
        if (bonusNumber != null) {
            this.bonusNumber = bonusNumber
        }
    }

    private fun sanitizeBonusNumber(bonusNumber: Int?){
        require(bonusNumber != null) {
            "[ERROR] Bonus number must be a number."
        }
        require(bonusNumber >= LOWEST_NUMBER && bonusNumber <= HIGHEST_NUMBER) {
            "[ERROR] All numbers must be between ${LOWEST_NUMBER} and ${HIGHEST_NUMBER} ($bonusNumber)."
        }
        require(!winningNumbers.contains(bonusNumber)) {
            "[ERROR] Bonus number cannot be one of the winning numbers."
        }
    }
}