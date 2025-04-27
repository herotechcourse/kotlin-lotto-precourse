package lotto.integeration

import lotto.data.repo.LottoRepositoryImpl
import lotto.data.service.LottoNumberService
import lotto.domain.model.WinningNumbers
import lotto.domain.usecases.CalculateResultUseCase
import lotto.domain.usecases.ComputeProfitUseCase
import lotto.domain.usecases.PurchaseLottoUseCase
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LottoIntegrationTest {

    @Test
    fun `full flow - purchase, win, and calculate profit`() {
        val service = LottoNumberService()
        val repository = LottoRepositoryImpl(service)

        val purchaseUseCase = PurchaseLottoUseCase(repository)
        val calculateResultUseCase = CalculateResultUseCase(repository)
        val computeProfitUseCase = ComputeProfitUseCase()

        val purchaseAmount = 10000 // buy 10 tickets
        purchaseUseCase.run(purchaseAmount)

        val winningNumbers = WinningNumbers(listOf(1, 2, 3, 4, 5, 6), 7)
        val ranks = calculateResultUseCase.run(winningNumbers)
        val profitRate = computeProfitUseCase.run(ranks, purchaseAmount)

        assertEquals(10, ranks.size)
        println("Profit Rate: $profitRate%")
    }
}
