package lotto

import lotto.generator.RandomNumbersGenerator

class LottoTicketMachine {

    fun purchase(count: Int, randomNumbersGenerator: RandomNumbersGenerator): List<Lotto> {
        val lottoTickets = mutableListOf<Lotto>()
        repeat(count) {
            lottoTickets.add(Lotto(randomNumbersGenerator.generate().sorted()))
        }
        return lottoTickets
    }

}