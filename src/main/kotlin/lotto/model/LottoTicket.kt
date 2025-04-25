package lotto.model

import lotto.Lotto

class LottoTicket (private val lottos: List<Lotto>){
    fun getLottosCount(): Int = lottos.size
    fun getLottoTicketNumbers() : List<List<Int>> =  lottos.map { it.getNumbers()}
}
