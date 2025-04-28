package lotto

import camp.nextstep.edu.missionutils.Randoms

object LotteryTicketMachine {

    internal val tickets = mutableListOf<List<Int>>()
    internal val winnings = mutableMapOf<PrizeRank, Int>()

    init {
        initWinnings()
    }

    fun initWinnings() {
        for (rank in PrizeRank.entries) {
            winnings[rank] = 0
        }
    }

    fun validatePurchaseAmount(amount: Int) {
        if (amount % 1000 != 0) {
            throw IllegalArgumentException("[ERROR] Purchase amount must be divisible by 1,000.")
        }
    }

    fun generateTickets(purchaseAmount: Int) {
        validatePurchaseAmount((purchaseAmount))
        val numberOfTickets = purchaseAmount / 1000
        repeat(numberOfTickets) {
            this.tickets.add(Randoms.pickUniqueNumbersInRange(1, 45, 6).sorted())
        }
    }

    fun validateAmountOfNumbers(numbers: List<Int>) {
        if (numbers.size != 6) {
            throw IllegalArgumentException("[ERROR] Exactly 6 winning numbers must be provided.")
        }
    }

    fun validateUniqueness(numbers: List<Int>) {
        if (numbers.distinct().size != numbers.size) {
            throw IllegalArgumentException("[ERROR] Winning numbers must be unique.")
        }
    }

    fun validateRange(numbers: List<Int>) {
        if (numbers.any { it !in 1..45}) {
            throw IllegalArgumentException("[ERROR] Winning numbers must be between 1 and 45.")
        }
    }

    fun validateWinningNumbers(numbers: List<Int>) {
        validateAmountOfNumbers(numbers)
        validateUniqueness(numbers)
        validateRange(numbers)
    }

    fun validateBonusNumber(winningNumbers: List<Int>, bonusNumber: Int) {
        if (bonusNumber !in 1..45) {
            throw IllegalArgumentException("[ERROR] Bonus number must be between 1 and 45.")
        }
        if (bonusNumber in winningNumbers) {
            throw IllegalArgumentException("[ERROR] Bonus number must not be one of the winning numbers.")
        }
    }

}