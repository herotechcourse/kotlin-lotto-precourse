package lotto.view

import lotto.Lotto
import lotto.model.LottoPrice
import lotto.model.LottoPrice.*
import lotto.model.LottoWinningResult
import lotto.utils.Constant.BONUS_NUMBER_MESSAGE
import lotto.utils.Constant.LOTTO_QUANTITY_MESSAGE
import lotto.utils.Constant.LOTTO_WINNING_NUMBER_MESSAGE
import lotto.utils.Constant.MATCH_PRIZE_BONUS_MESSAGE
import lotto.utils.Constant.MATCH_PRIZE_MESSAGE
import lotto.utils.Constant.PRICE_RATE_MESSAGE
import lotto.utils.Constant.PURCHASE_AMOUNT_MESSAGE
import lotto.utils.Constant.WINNING_STATISTICS_HEADER_MESSAGE

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

    fun printLottoWinningResults(lottoWinningResult: LottoWinningResult) {
        println()
        println(WINNING_STATISTICS_HEADER_MESSAGE)

        LottoPrice.entries.forEach { reward ->
            printMatchCount(reward, lottoWinningResult)
        }

        println(PRICE_RATE_MESSAGE.format(lottoWinningResult.rate))
    }

    private fun printMatchCount(reward: LottoPrice, lottoWinningResult: LottoWinningResult) {
        val matchCount = when(reward) {
            FIFTH -> lottoWinningResult.lottoMatchResult.threeMatching
            FOURTH -> lottoWinningResult.lottoMatchResult.fourMatching
            THIRD -> lottoWinningResult.lottoMatchResult.fiveMatching
            SECOND -> lottoWinningResult.lottoMatchResult.fiveMatchingWithBonus
            FIRST -> lottoWinningResult.lottoMatchResult.sixMatching
        }
        val message = if (reward == SECOND) MATCH_PRIZE_BONUS_MESSAGE else MATCH_PRIZE_MESSAGE
        println(message.format(reward.matchedCount, reward.formattedPrice(), matchCount))
    }
}