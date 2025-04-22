package lotto.business

import camp.nextstep.edu.missionutils.Randoms
import lotto.Lotto

class LottoService {

    companion object {
        fun generateLottoTickets(numberOfTickets: Long): List<Lotto>{
            val lottoTickets = ArrayList<Lotto>()
            for (i in 1 .. numberOfTickets) {
                lottoTickets.add(generateSingleLottoTicket())
            }
            return lottoTickets
        }

        fun generateSingleLottoTicket(): Lotto {
            val randomTicketSequence = Randoms.pickUniqueNumbersInRange(1, 45, 6)
            return Lotto(randomTicketSequence)
        }
    }
}