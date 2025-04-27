package lotto

import camp.nextstep.edu.missionutils.Randoms

import lotto.Constants.LOTTO_MAX_NUMBER
import lotto.Constants.LOTTO_MIN_NUMBER
import lotto.Constants.LOTTO_NUMBER_COUNT

object TicketMachine {

    fun issueTickets(count: Int): List<Lotto> = List(count) {
        Lotto(
            Randoms.pickUniqueNumbersInRange(
                LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER, LOTTO_NUMBER_COUNT
            ).sorted()
        )
    }
}

