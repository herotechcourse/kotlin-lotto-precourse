package lotto.service

import lotto.domain.PurchaseAmount
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

    companion object {
        private const val START_INCLUSIVE = 1
        private const val END_INCLUSIVE = 45

        @JvmStatic
        fun givePurchaseAmountAndTicketCount(): List<Pair<Int, Int>> {
            return listOf(8000 to 8, 9000 to 9, 1000 to 1)
        }
    }
}