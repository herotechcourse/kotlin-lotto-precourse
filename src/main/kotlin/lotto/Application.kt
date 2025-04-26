package lotto
fun main() {
    val inputView = InputView()

    readPurchaseOrder(inputView)
}

fun readPurchaseOrder(inputView: InputView): Order {
    while (true) {
        try {
            val purchaseAmount = inputView.readPurchaseAmount().toInt()
            return Order(purchaseAmount)
        } catch (e: NumberFormatException) {
            println("[ERROR] Purchase amount must be a valid number.")
        } catch (e: IllegalArgumentException) {
            println(e.message)
        }
    }
}