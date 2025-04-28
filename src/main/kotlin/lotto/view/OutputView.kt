package lotto.view

import lotto.Lotto
import lotto.utils.Constant.BONUS_NUMBER_MESSAGE
import lotto.utils.Constant.LOTTO_QUANTITY_MESSAGE
import lotto.utils.Constant.LOTTO_WINNING_NUMBER_MESSAGE
import lotto.utils.Constant.PURCHASE_AMOUNT_MESSAGE

class OutputView {

    fun printAmountGuide() {
        println(PURCHASE_AMOUNT_MESSAGE)
    }

    fun printQuantity(quantity: Int) {
        println()
        println(LOTTO_QUANTITY_MESSAGE.format(quantity))
    }

    fun printLottoNumbers(lottoNumbers: List<Lotto>) =
        lottoNumbers.forEach { lottoNumber -> println(lottoNumber.getNumbers()) }

    fun printWinningNumberGuide() {
        println()
        println(LOTTO_WINNING_NUMBER_MESSAGE)
    }

    fun printBonusNumberGuide() {
        println()
        println(BONUS_NUMBER_MESSAGE)
    }
}