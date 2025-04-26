package lotto

import lotto.generator.RandomNumbersGenerator

class LottoTicketMachine {

    fun purchase(count: Int, numbersGenerator: RandomNumbersGenerator): List<Lotto> {
        val lottoTickets = mutableListOf<Lotto>()
        repeat(count) {
            lottoTickets.add(Lotto(numbersGenerator.generate()))
        }
        return lottoTickets
    }

}