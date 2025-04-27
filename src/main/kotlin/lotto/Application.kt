package lotto

fun main() {
    val inputView = InputView()
    val outputView = OutputView()
    val validator = Validator()
    val lottoGenerator = LottoGenerator()
    val game = LottoGame()

    val validPurchaseAmount = readAndValidatePurchaseAmount(inputView, validator)
    val numberOfTickets = calculateNumberOfTickets(validPurchaseAmount)
    val purchasedTickets = lottoGenerator.getTickets(numberOfTickets)

    outputView.printHeader("You have purchased $numberOfTickets tickets.")
    outputView.printListOfTickets(purchasedTickets)

    val winningNumbers = readAndValidateWinningNumbers(inputView, validator)
    val bonusNumber = readAndValidateBonusNumber(inputView, validator, winningNumbers)
    val lottoResults = game.checkAllTickets(purchasedTickets, winningNumbers, bonusNumber)
    var profitRate = calculateProfitRate(lottoResults, validPurchaseAmount)

    val numberOfTicketsOfEachRank = countTicketsOfEachRank(lottoResults)
    outputView.printHeader("Winning Statistics\n" + "---")
    outputView.printResults(numberOfTicketsOfEachRank)
    outputView.printMessage("Total return rate is $profitRate%.")
}
fun readAndValidatePurchaseAmount(inputView: InputView, validator: Validator): Int {
    while (true) {
        try {
            val purchaseAmount = inputView.read("Please enter the purchase amount.")
            return validator.isPurchaseAmountValid(purchaseAmount)
        }
        catch (e: IllegalArgumentException)
        {
            println("[ERROR] ${e.message}")
        }
    }
}
fun calculateNumberOfTickets(money: Int): Int
{
    var numberOfTickets = money / 1000
    return numberOfTickets
}
fun readAndValidateWinningNumbers(inputView: InputView, validator: Validator,): List<Int> {
    while (true) {
        try {
            val winningNumbersToCheck = inputView.read("Please enter last week's winning numbers.")
            return validator.isWinningNumbersValid(winningNumbersToCheck)
        }
        catch (e: IllegalArgumentException)
        {
            println("[ERROR] ${e.message}")
        }
    }
}
fun readAndValidateBonusNumber(inputView: InputView, validator: Validator, winningNumbers: List<Int>): Int {
    while (true) {
        try {
            val bonusNumberToCheck = inputView.read("Please enter the bonus number.")
            return validator.isBonusNumberValid(bonusNumberToCheck, winningNumbers)
        }
        catch (e: IllegalArgumentException)
        {
            println("[ERROR] ${e.message}")
        }
    }
}
fun calculateTotalEarnings(ranks: List<Rank>): Int {
    var totalEarnings = 0
    for (rank in ranks)
    {
        totalEarnings = totalEarnings + rank.prizeMoney
    }
    return totalEarnings
}
fun calculateProfitRate(ranks: List<Rank>, spentAmount: Int): Double {
    var totalEarnings = calculateTotalEarnings(ranks)
    var profitRate = 0.0
    if (spentAmount <= 0) return 0.0
    if (totalEarnings > 0)
    {
        profitRate = totalEarnings.toDouble() / spentAmount * 100
    }
    return profitRate
}
fun countTicketsOfEachRank(ranks: List<Rank>): List<Int> {
    var firstCount = 0
    var secondCount = 0
    var thirdCount = 0
    var fourthCount = 0
    var fifthCount = 0
    for (rank in ranks) {
        if (rank == Rank.FIRST) { firstCount++ }
        if (rank == Rank.SECOND) { secondCount++ }
        if (rank == Rank.THIRD) { thirdCount++ }
        if (rank == Rank.FOURTH) { fourthCount++ }
        if (rank == Rank.FIFTH) { fifthCount++ }
    }
    return listOf(fifthCount, fourthCount, thirdCount, secondCount, firstCount)
}