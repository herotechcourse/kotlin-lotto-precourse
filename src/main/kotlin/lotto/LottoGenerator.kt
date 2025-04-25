package lotto

import camp.nextstep.edu.missionutils.Randoms

class LottoGenerator {

    fun createLottoTicket(): Lotto {
        val numbers = Randoms.pickUniqueNumbersInRange(
            LottoConstants.MIN_NUMBER, LottoConstants.MAX_NUMBER,
            LottoConstants.NUMBERS_PER_TICKET
        ).sorted()
        return Lotto(numbers)
    }
}