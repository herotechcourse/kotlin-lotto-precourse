package lotto.domain

import camp.nextstep.edu.missionutils.Randoms
import lotto.Lotto

class PurchasedLotto(val lottoNumbers: List<Int>) {
    fun countMatchedNumbersWithWinningNumbers(winningNumbers: Lotto): Int {
        return lottoNumbers.count { it in winningNumbers.getNumbers() }
    }

    fun isMatchedWithBonusNumber(bonusNumber: Int): Boolean {
        return bonusNumber in lottoNumbers
    }

    companion object {
        fun generateLottoNumbers(ticketCount: Int): List<PurchasedLotto> {
            return List(ticketCount) { createPurchasedLotto() }
        }

        private fun createPurchasedLotto(): PurchasedLotto {
            val numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6)
            numbers.sort()
            return PurchasedLotto(numbers)
        }
    }
}