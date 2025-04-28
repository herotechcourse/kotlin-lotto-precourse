package lotto.model

import camp.nextstep.edu.missionutils.Randoms
import lotto.Lotto
import lotto.Lotto.Companion.LOTTO_NUMBER_COUNT
import lotto.Lotto.Companion.LOTTO_NUMBER_MAXIMUM
import lotto.Lotto.Companion.LOTTO_NUMBER_MINIMUM
import lotto.util.Validator

class LottoStore {
    companion object {
        const val MAX_BUY_PRICE = 100_000;
        const val LOTTO_PRICE = 1_000;

        fun makeLottoTicket(purchaseMoney: String) : LottoTicket {
            validateInput(purchaseMoney)
            val lottoTicketCount = purchaseMoney.toInt() / LOTTO_PRICE
            val lottos = makeLottos(lottoTicketCount)
            return LottoTicket(lottos)
        }

        private fun makeLottos(lottoTicketCount: Int): List<Lotto> {
            return List(lottoTicketCount) { Lotto(makeRandomNumber()) }
        }

        private fun validateInput (purchaseMoney: String){
            Validator.isEmptyInput(purchaseMoney)
            Validator.isDigitString(purchaseMoney)
            val number = Validator.isInteger(purchaseMoney)
            Validator.isNumberWithinRange(number, LOTTO_PRICE, MAX_BUY_PRICE)
            Validator.isDivisibleBy(number, LOTTO_PRICE)
        }

        private fun makeRandomNumber() : List<Int> {
            val randomNumber = Randoms.pickUniqueNumbersInRange(
                LOTTO_NUMBER_MINIMUM,
                LOTTO_NUMBER_MAXIMUM,
                LOTTO_NUMBER_COUNT
            ).toList()
            return randomNumber.sorted()
        }
    }
}
