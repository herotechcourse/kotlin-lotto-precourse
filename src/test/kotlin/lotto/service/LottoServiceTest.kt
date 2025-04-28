package lotto.service

import lotto.enums.LottoRank
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class LottoServiceTest {

    private lateinit var lottoService: LottoService

    @BeforeEach
    fun setUp() {
        lottoService = LottoService()
    }

    @Test
    @DisplayName("Test creating a LottoTicket after entering purchase money")
    fun createLottoTicketTest() {
        val purchaseMoney = "5000"

        val lottoTicket = lottoService.createLottoTicket(purchaseMoney)

        assertThat(lottoTicket.getLottosCount()).isEqualTo(5)
    }

    @Test
    @DisplayName("Test creating WinningLotto and adding bonus number")
    fun createWinningLottoAndAddBonusTest() {
        val winningNumber = "1,2,3,4,5,6"
        val bonusNumber = "7"

        val winningLotto = lottoService.createWinningLotto(winningNumber)
        lottoService.addBonusNumber(winningLotto, bonusNumber)

        assertThat(winningLotto.getNumbers()).containsExactlyInAnyOrder(1, 2, 3, 4, 5, 6)
        assertThat(winningLotto.getBonusNum()).isEqualTo(7)
    }

    @Test
    @DisplayName("Test creating LottoResult")
    fun compareLottoTest() {
        val purchaseMoney = "100000"
        val lottoTicket = lottoService.createLottoTicket(purchaseMoney)
        val winningLotto = lottoService.createWinningLotto("1,2,3,4,5,6")
        lottoService.addBonusNumber(winningLotto, "7")

        val lottoResult = lottoService.compareLotto(lottoTicket, winningLotto)

        val rankResults: Map<LottoRank, Int> = lottoResult.getRankResults()
        assertThat(rankResults).isNotNull()
    }
}
