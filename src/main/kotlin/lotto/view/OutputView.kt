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

    fun printWinningNumbersInputPrompt() {
        println(WINNING_NUMBERS_INPUT_PROMPT)
    }

    fun printBonusNumberInputPrompt() {
        println(BONUS_NUMBER_INPUT_PROMPT)
    }

    fun printWinningStatisticsIntroMessage() {
        println(WINNING_STATISTICS_HEADER)
        println(STATISTICS_SEPARATOR)
    }

    companion object {
        const val PURCHASE_LOTTO_AMOUNT_PROMPT_MESSAGE = "Please enter the purchase amount."
        const val ISSUED_LOTTO_COUNT_MESSAGE = "You have purchased %d tickets."
        const val WINNING_NUMBERS_INPUT_PROMPT = "Please enter last week's winning numbers."
        const val BONUS_NUMBER_INPUT_PROMPT = "Please enter the bonus number."
        const val WINNING_STATISTICS_HEADER = "Winning Statistics"
        const val STATISTICS_SEPARATOR = "---"
    }
}