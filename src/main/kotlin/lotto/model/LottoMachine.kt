package lotto.model

import lotto.Lotto
import lotto.common.LottoUtil

object LottoMachine {
    private const val UNIT = 1000

    fun purchase(money: Money): List<Lotto> =
        List(money.getAmount() / UNIT) { Lotto(LottoUtil.generateNumbers()) }

    fun simulate(lottoList: List<Lotto>, winner: Winner): List<Prize> =
        lottoList.map { Prize(LottoUtil.getMatchCount(it, winner), LottoUtil.isMatchBonus(it, winner.getBonus())) }
}