package lotto

import camp.nextstep.edu.missionutils.Randoms

const val TICKET_PRICE = 1000;

fun main() {
    val purchaseAmount = promptPurchaseAmount()
    val tickets = generateLottos(purchaseAmount / TICKET_PRICE)
    val (winning, bonus) = promptWinningAndBonusNumbers()
    val prizeRanks = determinePrizeRanks(tickets, winning, bonus)
    val profitRate = calculateProfitRate(prizeRanks, purchaseAmount)
    OutputView.printPurchasedTickets(tickets)
    OutputView.printWinningStatistics(prizeRanks)
    OutputView.printProfitRate(profitRate)
}

fun calculateProfitRate(prizeRanks: List<PrizeRank?>, purchaseAmount: Int): Float {
    val rankCounts = countPrizeRanks(prizeRanks)
    val totalWinnings = rankCounts.entries.sumOf { (rank, count) ->
        rank.prizeAmount * count
    }
    val profitRate = if (purchaseAmount == 0) 0f else (totalWinnings.toFloat() / purchaseAmount) * 100
    return profitRate
}

fun countPrizeRanks(prizeRanks: List<PrizeRank?>): Map<PrizeRank, Int> {
    return prizeRanks
        .filterNotNull()
        .groupingBy { it }
        .eachCount()
}

fun determinePrizeRanks(tickets: List<Lotto>, winning: Lotto, bonus: Int): List<PrizeRank?> {
    val winningNumbers = winning.getNumbers().toSet()

    return tickets.map { ticket ->
        PrizeRank.findByMatch(
            matchCount = ticket.matchCount(winningNumbers),
            bonusMatch = ticket.contains(bonus)
        )
    }
}

fun promptWinningAndBonusNumbers(): Pair<Lotto, Int> {
    while(true) {
        var input = InputView.readWinningNumbers()
        val numbers = parseCommaSeparatedNumbers(input) ?: continue
        if (!validateWinningOrShowError(numbers)) continue
        input = InputView.readBonusNumber()
        val bonus = parseInputToInt(input) ?: continue
        if (validateBonusOrShowError(bonus, numbers)) return Pair(Lotto(numbers), bonus)
    }
}

fun validateBonusOrShowError(bonus: Int, numbers: List<Int>) : Boolean = try {
    validateBonus(bonus, numbers)
    true
} catch (e: IllegalArgumentException) {
    OutputView.printError(e.message ?: "Unknown Error")
    false
}

fun validateBonus(bonus: Int, numbers: List<Int>)  {
    if (bonus in numbers) throw IllegalArgumentException("Bonus can't be included in winning numbers.")
    if (bonus !in 1 .. 41) throw IllegalArgumentException("Bonus must be between 1 and 45.")
}

fun validateWinningOrShowError(numbers: List<Int>) : Boolean = try {
    validateWinning(numbers)
    true
} catch (e: IllegalArgumentException) {
    OutputView.printError(e.message ?: "Unknown Error")
    false
}

fun validateWinning(numbers: List<Int>) {
    if (numbers.size != 6) throw IllegalArgumentException("Please input exactly 6 comma-separated numbers.")
    if (numbers.distinct().size != 6) throw IllegalArgumentException("Numbers must not contain duplicates.")
    if (!numbers.all { it in 1..45 }) throw IllegalArgumentException("Numbers must be between 1 and 45.")
}

fun parseCommaSeparatedNumbers(input: String): List<Int>? = try {
    input?.split(",")?.map { it.trim() }?.map { it.toInt() }
} catch (e: NumberFormatException) {
    OutputView.printError("Input must be a number")
    null
}

fun generateLottos(count: Int) : List<Lotto> =
    List(count) { generateLotto() }

fun generateLotto() : Lotto {
    val numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6)
        .sorted()
    return Lotto(numbers)
}

fun promptPurchaseAmount() : Int {
    while (true) {
        val input = InputView.readPurchaseAmount()
        val amount = parseInputToInt(input) ?: continue
        if (validateAmountOrShowError(amount)) return amount
    }
}

fun parseInputToInt(input: String?) : Int? = try {
    input?.toInt()
} catch (e: NumberFormatException) {
    OutputView.printError("Input must be a number")
    null
}

fun validateAmountOrShowError(amount: Int) : Boolean = try {
    validateAmount(amount)
    true
} catch (e: IllegalArgumentException) {
    OutputView.printError(e.message ?: "Unknown Error")
    false
}

fun validateAmount(amount: Int) {
    if (amount <= 0) throw IllegalArgumentException("Amount must be positive.")
    if (amount % TICKET_PRICE != 0) throw IllegalArgumentException("Amount must be divisible by 1,000.")
}