package lotto.view

import lotto.Lotto

class OutputView {
    fun printPurchaseLottoAmountPrompt() {
        println(PURCHASE_LOTTO_AMOUNT_PROMPT_MESSAGE)
    }

    fun printIssuedLottoCountMessage(count: Int) {
        println(String.format(ISSUED_LOTTO_COUNT_MESSAGE, count))
    }

    fun printIssuedLottoNumbers(lottos: List<Lotto>) {
        lottos.forEach{
            lotto -> println(lotto.numbers().sorted())
        }
    }

    companion object {
        const val PURCHASE_LOTTO_AMOUNT_PROMPT_MESSAGE = "Please enter the purchase amount."
        const val ISSUED_LOTTO_COUNT_MESSAGE = "You have purchased %d tickets."
    }
}