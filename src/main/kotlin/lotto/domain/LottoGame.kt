package lotto.domain

import camp.nextstep.edu.missionutils.Randoms
import lotto.Lotto
import lotto.model.LottoMatchResult
import lotto.model.LottoMatchCount
import lotto.utils.Constant.FIFTH_PRICE
import lotto.utils.Constant.FIRST_PRICE
import lotto.utils.Constant.FOURTH_PRICE
import lotto.utils.Constant.LOTTO_COST
import lotto.utils.Constant.LOTTO_SIZE
import lotto.utils.Constant.MAX_LOTTO_NUMBER
import lotto.utils.Constant.MIN_LOTTO_NUMBER
import lotto.utils.Constant.SECOND_PRICE
import lotto.utils.Constant.THIRD_PRICE

class LottoGame {
    fun getQuantity(amount: Int): Int = amount / LOTTO_COST

    fun issueLottoTickets(quantity: Int): List<Lotto> = List(quantity) {
        Lotto(
            Randoms.pickUniqueNumbersInRange(
                MIN_LOTTO_NUMBER,
                MAX_LOTTO_NUMBER,
                LOTTO_SIZE,
            ).sorted()
        )
    }

    fun result(lottos: List<Lotto>, winningNumber: Lotto, bonusNumber: Int, ): List<LottoMatchCount> = lottos.map { lotto ->
        val matchedCount = lotto.getNumbers().count { it in winningNumber.getNumbers() }
        val hasBonus = bonusNumber in lotto.getNumbers()
        LottoMatchCount(matchedCount = matchedCount, hasBonus = hasBonus)
    }

    fun match(lottoMatchCounts: List<LottoMatchCount>): LottoMatchResult =
        lottoMatchCounts.fold(LottoMatchResult()) { result, lottoResult ->
            result.updateMatchResult(lottoResult)
        }

    private fun LottoMatchResult.updateMatchResult(lottoMatchCount: LottoMatchCount): LottoMatchResult {
        return when (lottoMatchCount.matchedCount) {
            6 -> copy(sixMatching = sixMatching + 1)
            5 -> {
                if (lottoMatchCount.hasBonus) copy(fiveMatchingWithBonus = fiveMatchingWithBonus + 1)
                else copy(fiveMatching = fiveMatching + 1)
            }
            4 -> copy(fourMatching = fourMatching + 1)
            3 -> copy(threeMatching = threeMatching + 1)
            else -> this
        }
    }

    fun calculateRate(lottoMatchResult: LottoMatchResult, purchaseAmount: Int): Float {
        return (calculatePrice(lottoMatchResult).toFloat() / purchaseAmount * 100)
    }

    private fun calculatePrice(lottoMatchResult: LottoMatchResult): Int {
        return lottoMatchResult.sixMatching * FIRST_PRICE +
                lottoMatchResult.fiveMatchingWithBonus * SECOND_PRICE +
                lottoMatchResult.fiveMatching * THIRD_PRICE +
                lottoMatchResult.fourMatching * FOURTH_PRICE +
                lottoMatchResult.threeMatching * FIFTH_PRICE
    }
}
