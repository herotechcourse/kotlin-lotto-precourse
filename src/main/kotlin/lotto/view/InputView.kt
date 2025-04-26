package lotto.view

object InputView {

    private const val INPUT_PURCHASE_AMOUNT_MESSAGE = "Please enter the purchase amount."

    fun readPurchaseAmount(): String {
        println(INPUT_PURCHASE_AMOUNT_MESSAGE)
        return readln()
    }
}
