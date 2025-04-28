package lotto

import camp.nextstep.edu.missionutils.Randoms
import lotto.utils.Constants

object LottoGenerator {

    private fun countFromAmount(amount: Int): Int {
        require(amount % Constants.MINIMUM_PURCHASE_AMOUNT == 0) {
            "[ERROR] Purchase amount must be divisible by ${Constants.MINIMUM_PURCHASE_AMOUNT}."
        }
        return amount / Constants.MINIMUM_PURCHASE_AMOUNT
    }

    fun generate(amount: Int): List<Lotto> {
        return List(countFromAmount(amount)) {
            val randomNumbers = Randoms.pickUniqueNumbersInRange(
                Constants.MINIMUM_VALID_NUMBER,
                Constants.MAXIMUM_VALID_NUMBER,
                Constants.LOTTO_NUMBER_COUNT
            )
            Lotto(randomNumbers)
        }
    }
}