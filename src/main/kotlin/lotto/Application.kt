package lotto

fun main() {
    try {
        val purchaseAmount = InputView.readPurchaseAmount()
        println("Purchase Amount: $purchaseAmount") // TEMP: Check it works
    } catch (e: IllegalArgumentException) {
        println(e.message)
    }
}
