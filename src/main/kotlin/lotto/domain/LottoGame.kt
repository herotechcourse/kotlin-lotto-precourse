package lotto.domain

import lotto.utils.Constant.LOTTO_COST

class LottoGame {
    fun getQuantity(amount: Int): Int = amount / LOTTO_COST

}
