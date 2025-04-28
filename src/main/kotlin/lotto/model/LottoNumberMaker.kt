package lotto.model

import camp.nextstep.edu.missionutils.Randoms
import lotto.Lotto

object LottoNumberMaker {
    fun makeOneTicket(): Lotto {
        val lottoNumbers =
            Randoms.pickUniqueNumbersInRange(LOTTO_NUMBER_START, LOTTO_NUMBER_END, LOTTO_NUMBER_COUNT).sorted()
        return Lotto(lottoNumbers)
    }

    fun makeTotalTicket(ticketCount: Int): MutableList<Lotto> {
        val totalLottoTicket = mutableListOf<Lotto>()

        repeat(ticketCount) {
            totalLottoTicket.add(makeOneTicket())
        }

        return totalLottoTicket
    }

    fun printTotalTicket(lottoNumber: List<Lotto>) {
        for (ticket in lottoNumber) {
            println(ticket.getNumbers())
        }
    }
}
