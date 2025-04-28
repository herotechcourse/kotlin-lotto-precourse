package lotto

import camp.nextstep.edu.missionutils.Randoms

object LotteryTicketMachine {

    internal val tickets = mutableListOf<List<Int>>()
    internal val winnings = mutableMapOf<PrizeRank, Int>()
    internal val winningNumbers = mutableListOf<Int>()
    internal var bonusNumber: Int = -1

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
        for (number in numbers) {
            winningNumbers.add(number)
        }
    }

    fun validateBonusNumber(winningNumbers: List<Int>, number: Int) {
        if (number !in 1..45) {
            throw IllegalArgumentException("[ERROR] Bonus number must be between 1 and 45.")
        }
        if (number in winningNumbers) {
            throw IllegalArgumentException("[ERROR] Bonus number must not be one of the winning numbers.")
        }
        bonusNumber = number
    }

    fun evaluateTickets() {
        for (ticket in tickets) {
            val matchCount = evaluateMatchesInWinningNumbers(ticket)
            val bonusMatch = evaluateMatchWithBonusNumber(ticket)
            val matchRank = PrizeRank.entries.find {
                it.matches == matchCount && it.bonusNumber == bonusMatch
            }
            if (matchRank != null) {
                increaseRankMatches(matchRank)
            }
        }
    }

    fun evaluateMatchesInWinningNumbers(ticket: List<Int>): Int {
        var matchCount = 0
        for (number in ticket) {
            if (number in winningNumbers) {
                matchCount++
            }
        }
        return matchCount
    }

    fun evaluateMatchWithBonusNumber(ticket: List<Int>): Boolean {
        var bonusMatch = false
        if (ticket.contains(bonusNumber)) {
            bonusMatch = true
        }
        return bonusMatch
    }

    fun increaseRankMatches(rank: PrizeRank) {
        winnings[rank] = winnings.getOrDefault(rank, 0) + 1
    }
}