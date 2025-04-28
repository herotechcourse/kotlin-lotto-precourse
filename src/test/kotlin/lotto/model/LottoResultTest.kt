package lotto.model

import lotto.Lotto
import lotto.enums.LottoRank
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class LottoResultTest {

    private lateinit var lottoResult: LottoResult
    private lateinit var winningLotto: WinningLotto

    @BeforeEach
    fun setUp() {
        lottoResult = LottoResult()
        winningLotto = WinningLotto.create("1,2,3,4,5,6")
        winningLotto.addBonusNumber("7")
    }

    @Test
    @DisplayName("LottoResult getRankResults Test")
    fun lottoResultCreateTest() {
        val rankResults = lottoResult.getRankResults()

        for (rank in LottoRank.values()) {
            assertThat(rankResults).containsKey(rank)
            assertThat(rankResults[rank]).isEqualTo(0)
        }
    }

    @Test
    @DisplayName("Fifth Prize Winning Test")
    fun winningLottoCompareTest_5th() {
        val lottoTicket = LottoTicket(
            listOf(
                Lotto(listOf(1, 2, 3, 8, 9, 10))
            )
        )

        lottoResult.compare(lottoTicket, winningLotto)
        val results = lottoResult.getRankResults()

        assertThat(results[LottoRank.FIFTH]).isEqualTo(1)
    }

    @Test
    @DisplayName("Fourth Prize Winning Test")
    fun winningLottoCompareTest_4th() {
        val lottoTicket = LottoTicket(
            listOf(
                Lotto(listOf(1, 2, 3, 4, 9, 10))
            )
        )

        lottoResult.compare(lottoTicket, winningLotto)
        val results = lottoResult.getRankResults()

        assertThat(results[LottoRank.FOURTH]).isEqualTo(1)
    }

    @Test
    @DisplayName("Third Prize Winning Test")
    fun winningLottoCompareTest_3rd() {
        val lottoTicket = LottoTicket(
            listOf(
                Lotto(listOf(1, 2, 3, 4, 5, 10))
            )
        )

        lottoResult.compare(lottoTicket, winningLotto)
        val results = lottoResult.getRankResults()

        assertThat(results[LottoRank.THIRD]).isEqualTo(1)
    }

    @Test
    @DisplayName("Second Prize Winning Test")
    fun winningLottoCompareTest_2nd() {
        val lottoTicket = LottoTicket(
            listOf(
                Lotto(listOf(1, 2, 3, 4, 5, 7))
            )
        )

        lottoResult.compare(lottoTicket, winningLotto)
        val results = lottoResult.getRankResults()

        assertThat(results[LottoRank.SECOND]).isEqualTo(1)
    }

    @Test
    @DisplayName("First Prize Winning Test")
    fun winningLottoCompareTest_1st() {
        val lottoTicket = LottoTicket(
            listOf(
                Lotto(listOf(1, 2, 3, 4, 5, 6))
            )
        )

        lottoResult.compare(lottoTicket, winningLotto)
        val results = lottoResult.getRankResults()

        assertThat(results[LottoRank.FIRST]).isEqualTo(1)
    }
}
