package lotto

import lotto.generator.NumbersGenerator

class LottoTicketMachine {

    fun purchase(count: Int, numbersGenerator: NumbersGenerator): List<Lotto> {
        val lottoTickets = mutableListOf<Lotto>()
        repeat(count) {
            lottoTickets.add(Lotto(numbersGenerator.generate()))
        }
        return lottoTickets
    }

}