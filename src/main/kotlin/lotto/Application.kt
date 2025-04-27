package lotto

fun main() {
    val inputView = InputView()
    val outputView = OutputView()
    val validator = Validator()
    val lottoGenerator = LottoGenerator()
    val validPurchaseAmount = readAndValidatePurchaseAmount(inputView, validator)
    val numberOfTickets = calculateNumberOfTickets(validPurchaseAmount)
    val purchasedTickets = lottoGenerator.getTickets(numberOfTickets)
    outputView.printHeader("You have purchased $numberOfTickets tickets.")
    outputView.printListOfTickets(purchasedTickets)
    val winningNumbers = readAndValidateWinningNumbers(inputView, validator)
    //outputView.printListOfItems(winningNumbers)
}
fun readAndValidatePurchaseAmount(inputView: InputView, validator: Validator): Int {
    while (true) {
        try {
            var purchaseAmount = inputView.read("Please enter the purchase amount.")
            return validator.isPurchaseAmountValid(purchaseAmount)
            break
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
fun readAndValidateWinningNumbers(inputView: InputView, validator: Validator): List<Int> {
    while (true) {
        try {
            var winningNumbersToCheck = inputView.read("Please enter last week's winning numbers.")
            return validator.isWinningNumbersValid(winningNumbersToCheck)
            break
        }
        catch (e: IllegalArgumentException)
        {
            println("[ERROR] ${e.message}")
        }
    }
}
