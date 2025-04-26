package lotto

fun main() {
    // TODO: Implement the program
    val inputView = InputView()
    val validator = Validator()
    var validPurchaseAmount: Int? = null
    while (true) {
        try {
            var purchaseAmount = inputView.read("Please enter the purchase amount.")
            validPurchaseAmount = validator.isPurchaseAmountValid(purchaseAmount)
        }
        catch (e: IllegalArgumentException)
        {
            println("[ERROR] ${e.message}")
        }

        //println(validPurchaseAmount)
    }
}
