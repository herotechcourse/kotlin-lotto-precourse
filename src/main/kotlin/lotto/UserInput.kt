package lotto

import lotto.constants.HIGHEST_NUMBER
import lotto.constants.LOWEST_NUMBER
import lotto.constants.TICKET_COST

class UserInput {

    init {
        require(TICKET_COST > 0) {
            "[Error] TICKET_COST ($TICKET_COST) must be greater than zero."
        }
        require(LOWEST_NUMBER < HIGHEST_NUMBER) {
            "[Error] LOWEST_NUMBER ($LOWEST_NUMBER) must be smaller than HIGHEST_NUMBER ($HIGHEST_NUMBER)."
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
        "Purchase amount".sanitizePositiveNumber(purchaseAmount)
        if (purchaseAmount != null) {
            require(purchaseAmount >= TICKET_COST) {
                "[ERROR] Purchase amount must be equal or greater than $TICKET_COST."
            }
            require(purchaseAmount % TICKET_COST == 0) {
                "[ERROR] Purchase amount must be a multiple of $TICKET_COST."
            }
        }
    }

    fun setWinningNumbers(input: String) {
        val winningNumbers = input.split(",").map { it.trim() }
        this.winningNumbers = sanitizeWinningNumbers(winningNumbers)
    }

    private fun sanitizeWinningNumbers(splitNumbers: List<String>): MutableList<Int> {
        val numbers = sanitizeSplitNumbers(splitNumbers)
        sanitizeNumbers(numbers)
        return numbers
    }

    private fun sanitizeSplitNumbers(splitNumbers: List<String>): MutableList<Int> {
        val numbers = mutableListOf<Int>()
        for (splitNumber in splitNumbers) {
            val number = splitNumber.toIntOrNull()
            sanitizeSplitNumber(number)
            if (number != null) {
                numbers.add(number)
            }
        }
        return numbers
    }

    private fun sanitizeSplitNumber(number: Int?) {
        "All numbers".sanitizePositiveNumber(number)
        "All numbers".sanitizeRangeOfNumbers(number)
    }

    private fun sanitizeNumbers(numbers: MutableList<Int>) {
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

    private fun sanitizeBonusNumber(bonusNumber: Int?) {
        "Bonus number".sanitizePositiveNumber(bonusNumber)
        "Bonus number".sanitizeRangeOfNumbers(bonusNumber)
        if (bonusNumber != null) {
            require(!winningNumbers.contains(bonusNumber)) {
                "[ERROR] Bonus number cannot be one of the winning numbers."
            }
        }
    }

    private fun String.sanitizePositiveNumber(number: Int?) {
        require(number != null) {
            "[ERROR] $this must be a number."
        }
        require(number > 0) {
            "[ERROR] $this must be greater than zero."
        }
    }

    private fun String.sanitizeRangeOfNumbers(number: Int?) {
        if (number != null) {
            require(number >= LOWEST_NUMBER && number <= HIGHEST_NUMBER) {
                "[ERROR] $this must be between $LOWEST_NUMBER and $HIGHEST_NUMBER."
            }
        }
    }
}