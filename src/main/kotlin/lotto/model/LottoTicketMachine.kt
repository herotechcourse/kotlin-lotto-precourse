package lotto.model

import lotto.Lotto

interface LottoTicketMachine {
    fun buyLotto(quantity: Int) : List<Lotto>
}