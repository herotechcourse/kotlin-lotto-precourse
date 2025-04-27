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
    //outputView.printListOfItems(lottoResults)
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