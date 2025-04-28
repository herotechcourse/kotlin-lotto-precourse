package lotto.domain.winning

import lotto.Lotto
import lotto.domain.dto.NumbersDto

class RandomLottos(private val tickets: List<Lotto>) {
    fun ticketCount(): Int = tickets.size

    fun toAllNumbersDto(): List<NumbersDto> {
        return tickets.map { ticket -> ticket.toNumbersDto() }
            .toList()
    }
}
