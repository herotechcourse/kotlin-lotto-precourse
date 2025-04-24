package lotto


class InputHandler {
    companion object {
        const val INPUT_PURCHASE_MESSAGE = "Please enter the purchase amount."
    }

    fun readPurchaseAmount(readLine: () -> String) : Int {
        println(INPUT_PURCHASE_MESSAGE)
        return readLine().toInt()
    }
}