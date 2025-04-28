package lotto.service

import lotto.Lotto
import lotto.domain.PurchaseAmount
import lotto.domain.prize.PrizeResult
import lotto.domain.prize.Rank
import lotto.domain.winning.BonusNumber
import lotto.domain.winning.RandomLottos
import lotto.domain.winning.WinningNumbers
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

class LottoServiceTest {
    private val testService = LottoService()

    @ParameterizedTest
    @MethodSource("givePurchaseAmountAndTicketCount")
    @DisplayName("[Success] generate random Lottery tickets exactly based on entered purchase amount")
    fun `test generating random Lottery tickets based on purchase amount`(purchases: Pair<Int, Int>) {
        val purchaseAmount = PurchaseAmount(purchases.first)
        val randomLottos = testService.createRandomLotto(purchaseAmount)

        Assertions.assertThat(randomLottos.ticketCount()).isEqualTo(purchases.second)
    }

    @Test
    @DisplayName("[Success] each lotto ticket should contain exactly 6 numbers")
    fun `test containing number count`() {
        val purchaseAmount = PurchaseAmount(8000)
        val randomLottos = testService.createRandomLotto(purchaseAmount)

        randomLottos.tickets().forEach { lotto ->
            Assertions.assertThat(lotto.numbers()).hasSize(6)
        }
    }

    @Test
    @DisplayName("[Success] each number in a ticket should be between $START_INCLUSIVE and $END_INCLUSIVE")
    fun `test containing number in valid range`() {
        val purchaseAmount = PurchaseAmount(3000)
        val randomLottos = testService.createRandomLotto(purchaseAmount)

        randomLottos.tickets().forEach { lotto ->
            Assertions.assertThat(lotto.numbers()).allMatch { number ->
                number in START_INCLUSIVE..END_INCLUSIVE
            }
        }
    }

    @Test
    @DisplayName("[Success] service should correctly calculate prize statistics based on winning numbers")
    fun `test counting of the rank`() {
        val winningNumbers = WinningNumbers.from("1, 2, 3, 4, 5, 6")
        val bonusNumber = BonusNumber.from(7, winningNumbers)

        val tickets = listOf(
            Lotto(FIRST_PRIZE_TICKET), // FIRST
            Lotto(SECOND_PRIZE_TICKET), // SECOND
            Lotto(THIRD_PRIZE_TICKET), // THIRD
            Lotto(FOURTH_PRIZE_TICKET), // FOURTH
            Lotto(FIFTH_PRIZE_TICKET), // FIFTH
            Lotto(NO_PRIZE_TICKET) // NONE
        )
        val randomLottos = RandomLottos(tickets)
        val prizeResult = testService.calculatePrizeStatistics(randomLottos, winningNumbers, bonusNumber)

        Assertions.assertThat(prizeResult.count(Rank.FIRST)).isEqualTo(EXPECTED_COUNT_PER_RANK)
        Assertions.assertThat(prizeResult.count(Rank.SECOND)).isEqualTo(EXPECTED_COUNT_PER_RANK)
        Assertions.assertThat(prizeResult.count(Rank.THIRD)).isEqualTo(EXPECTED_COUNT_PER_RANK)
        Assertions.assertThat(prizeResult.count(Rank.FOURTH)).isEqualTo(EXPECTED_COUNT_PER_RANK)
        Assertions.assertThat(prizeResult.count(Rank.FIFTH)).isEqualTo(EXPECTED_COUNT_PER_RANK)
    }


    @Test
    @DisplayName("[Success] create statistics dto with profit rate correctly")
    fun `test creating safe statistics dto`() {
        val purchaseAmount = PurchaseAmount(8000)
        val prizeResult = PrizeResult.create()

        prizeResult.addRankBy(6, false)

        val statisticsDto = testService.createStatisticsDto(purchaseAmount, prizeResult)
        val expectedProfitRate = ((2_000_000_000.0 / 8000) * 100).toFloat()

        Assertions.assertThat(statisticsDto.profitRate).isEqualTo(expectedProfitRate)
        Assertions.assertThat(statisticsDto.resultDtos).isNotEmpty
    }

    companion object {
        private const val START_INCLUSIVE = 1
        private const val END_INCLUSIVE = 45

        @JvmStatic
        fun givePurchaseAmountAndTicketCount(): List<Pair<Int, Int>> {
            return listOf(8000 to 8, 9000 to 9, 1000 to 1)
        }

        private val FIRST_PRIZE_TICKET = listOf(1, 2, 3, 4, 5, 6)
        private val SECOND_PRIZE_TICKET = listOf(1, 2, 3, 4, 5, 7)
        private val THIRD_PRIZE_TICKET = listOf(1, 2, 3, 4, 5, 45)
        private val FOURTH_PRIZE_TICKET = listOf(1, 2, 3, 4, 44, 45)
        private val FIFTH_PRIZE_TICKET = listOf(1, 2, 3, 43, 44, 45)
        private val NO_PRIZE_TICKET = listOf(1, 2, 42, 43, 44, 45)
        private const val EXPECTED_COUNT_PER_RANK = 1
    }
}