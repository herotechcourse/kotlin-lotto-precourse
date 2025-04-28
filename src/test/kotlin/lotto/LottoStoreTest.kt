package lotto

import lotto.lottogenerator.ManualLottoGenerator
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll

class LottoStoreTest {

    @Test
    fun `should sell lotto tickets for purchase amount`() {
        // given
        val lottoPurchaseAmount = LottoPurchaseAmount(2000)
        val lottoNumbers = mutableListOf(
            listOf(1, 2, 3, 4, 5, 6),
            listOf(11, 12, 13, 14, 15, 16)
        )
        val lottoStore = LottoStore(ManualLottoGenerator(lottoNumbers))
        // when
        val lottoTickets = lottoStore.issueLottoTickets(lottoPurchaseAmount)
        // then
        assertAll(
            { assertThat(lottoTickets).hasSize(2) },
            { assertLottoNumbers(lottoTickets.first(), listOf(1, 2, 3, 4, 5, 6)) },
            { assertLottoNumbers(lottoTickets.last(), listOf(11, 12, 13, 14, 15, 16)) }
        )
    }

    private fun assertLottoNumbers(lotto: Lotto, lottoNumbers: List<Int>) {
        assertThat(lotto.numbers()).containsExactlyInAnyOrder(
            *lottoNumbers.map { LottoNumber(it) }.toTypedArray()
        )
    }
}
