package lotto.model

import lotto.Lotto
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class LottoTicketTest {

    private lateinit var lottoTicket: LottoTicket
    private lateinit var lottos: List<Lotto>

    @BeforeEach
    fun setUp() {
        lottos = listOf(
            Lotto(listOf(1, 2, 3, 4, 5, 6)),
            Lotto(listOf(7, 8, 9, 10, 11, 12))
        )
        lottoTicket = LottoTicket(lottos)
    }

    @Test
    @DisplayName("Test number of lottos in LottoTicket")
    fun getLottosCount() {
        assertThat(lottoTicket.getLottosCount()).isEqualTo(2)
    }

    @Test
    @DisplayName("Test returning all lotto numbers in LottoTicket")
    fun getLottoTicketNumbers() {
        val expectedNumbers = listOf(
            listOf(1, 2, 3, 4, 5, 6),
            listOf(7, 8, 9, 10, 11, 12)
        )

        assertThat(lottoTicket.getLottoTicketNumbers()).isEqualTo(expectedNumbers)
    }
}
