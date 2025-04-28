package lotto.service

import lotto.controller.response.PurchasedTicketsDto
import lotto.controller.response.statistics.StatisticsDto
import lotto.domain.LottoGenerator
import lotto.domain.PurchaseAmount
import lotto.domain.prize.PrizeResult
import lotto.domain.winning.BonusNumber
import lotto.domain.winning.RandomLottos
import lotto.domain.winning.WinningDeterminer
import lotto.domain.winning.WinningNumbers

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

    fun calculatePrizeStatistics(lottos: RandomLottos, winningNumber: WinningNumbers, bonus: BonusNumber): PrizeResult {
        val prizeResult = PrizeResult.create()
        lottos.tickets().forEach { randomLotto ->
            val matchCount = WinningDeterminer.determineMatchCount(randomLotto, winningNumber)
            val bonusMatch = WinningDeterminer.determineBonusMatch(randomLotto, bonus)
            prizeResult.addRankBy(matchCount, bonusMatch)
        }
        prizeResult.removeExcludedPrize()

        return prizeResult
    }

    fun createStatisticsDto(purchaseAmount: PurchaseAmount, prizeResult: PrizeResult): StatisticsDto {
        return StatisticsDto(prizeResult.toPrizeResultDto(), prizeResult.calculateProfitRate(purchaseAmount))
    }
}