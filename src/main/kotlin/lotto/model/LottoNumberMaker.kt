package lotto.model

import camp.nextstep.edu.missionutils.Randoms
import lotto.Lotto

object LottoNumberMaker {
    fun makeLottoTicket(): Lotto {
        val lottoNumbers =
            Randoms.pickUniqueNumbersInRange(LOTTO_NUMBER_START, LOTTO_NUMBER_END, LOTTO_NUMBER_COUNT).sorted()
        return Lotto(lottoNumbers)
    }

    fun makeTotalLottoTicket(ticketCount: Int): MutableList<Lotto> {
        val totalLottoTicket = mutableListOf<Lotto>()

        repeat(ticketCount) {
            totalLottoTicket.add(makeLottoTicket())
        }

        return totalLottoTicket
    }

    fun printTotalLottoTicket(lottoNumber: List<Lotto>) {
        for (ticket in lottoNumber) {
            println(ticket.getNumbers())
        }
    }
}
