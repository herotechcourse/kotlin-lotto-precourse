package lotto.domain

import lotto.Lotto

interface ITicketMachine {
    fun issue(amount: Int): List<Lotto>
}