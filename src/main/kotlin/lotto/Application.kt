package lotto

fun main() {
    try {
        InputView().readPurchaseAmount()
    } catch (e: InputView.MaxRetryException) {
        println(e.message + " Exiting...")
        return
    }
}
