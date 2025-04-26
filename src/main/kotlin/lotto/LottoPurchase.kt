package lotto

import camp.nextstep.edu.missionutils.Randoms

class LottoPurchase(amount: Int) {
    private val amount: Int
    private val lottoNums: Int
    private val lottos: List<Lotto>

    init {
        require(amount % 1000 == 0) { "[Error] Amount must be divisible by 1,000 KRW." }
        this.amount = amount
        this.lottoNums = amount / 1000
        this.lottos = List(lottoNums) { Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6)) }
    }

    fun getAmount(): Int {
        return amount
    }

    fun getLottos() : List<Lotto> {
        return lottos
    }
}