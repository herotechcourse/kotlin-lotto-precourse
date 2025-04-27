package lotto.model

import camp.nextstep.edu.missionutils.Randoms
import lotto.LotteryConstants
import lotto.Lotto

class LottoGenerator {
    fun generate(count: Int): List<Lotto> {
        val lottoList = mutableListOf<Lotto>()

        repeat(count) {
            val numbers = Randoms.pickUniqueNumbersInRange(
                LotteryConstants.MIN_NUMBER,
                LotteryConstants.MAX_NUMBER,
                LotteryConstants.LOTTO_NUMBER_COUNT
            )
            lottoList.add(Lotto(numbers))
        }

        return lottoList
    }
}