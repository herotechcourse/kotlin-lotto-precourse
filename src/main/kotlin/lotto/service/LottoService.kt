package lotto.service

import lotto.controller.response.PurchasedTicketsDto
import lotto.domain.LottoGenerator
import lotto.domain.PurchaseAmount
import lotto.domain.winning.RandomLottos

class LottoService {
    fun createRandomLotto(amount: Int): RandomLottos {
        val ticketAmount = PurchaseAmount(amount).toTicketAmount()
        val randomLottos = LottoGenerator.generate(ticketAmount)

        return RandomLottos(randomLottos)
    }

    fun createPurchasedDto(randomLotto: RandomLottos): PurchasedTicketsDto {
        val ticketCount = randomLotto.ticketCount()
        val purchasedTicketsDto = randomLotto.toAllNumbersDto()

        return PurchasedTicketsDto(ticketCount, purchasedTicketsDto)
    }
}