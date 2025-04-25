package lotto.view

class OutputView {
    fun printPurchaseLottoAmountPrompt() {
        println(PURCHASE_LOTTO_AMOUNT_PROMPT_MESSAGE)
    }

    companion object {
        const val PURCHASE_LOTTO_AMOUNT_PROMPT_MESSAGE = "Please enter the purchase amount."
    }
}