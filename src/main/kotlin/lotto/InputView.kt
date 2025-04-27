package lotto

class InputView {
    fun readPurchaseAmount(): String {
        println(RequestMessages.AMOUNT)
        return readln()
    }

    companion object RequestMessages {
        const val AMOUNT = "Please enter the purchase amount."
    }
}