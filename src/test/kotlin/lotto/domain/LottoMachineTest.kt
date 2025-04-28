package lotto.domain

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest
import camp.nextstep.edu.missionutils.test.NsTest
import lotto.Lotto
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class LottoMachineTest : NsTest() {

    private lateinit var lottoMachine: LottoMachine
    private lateinit var player: Player

    @BeforeEach
    fun setup() {
        lottoMachine = LottoMachine()
        player = Player()
    }


    @Test
    fun `should create the right number of tickets based on purchase`() {
        assertRandomUniqueNumbersInRangeTest(
            {
                run("5000", "1,2,3,4,5,6", "7")

                lottoMachine.buyTickets(player)
                lottoMachine.submitWinningData()
                lottoMachine.showWinningStats(player)
                assertThat(player.lottoTickets).hasSize(5)
            },
            listOf(1, 2, 3, 4, 5, 6),
            listOf(7, 8, 9, 10, 11, 12),
            listOf(13, 14, 15, 16, 17, 18),
            listOf(19, 20, 21, 22, 23, 24),
            listOf(25, 26, 27, 28, 29, 30)
        )
    }


    @Test
    fun `should correctly count ranks`() {
        val winningLotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val bonusNumber = 7
        val winningDraw = WinningDraw(winningLotto, bonusNumber)
        val tickets = listOf(
            Lotto(listOf(1, 2, 3, 4, 5, 6)),   // 6 matches -> MATCH_SIX
            Lotto(listOf(1, 2, 3, 4, 5, 7)),   // 5 + bonus -> MATCH_BONUS
            Lotto(listOf(1, 2, 3, 4, 5, 10)),  // 5 matches -> MATCH_FIVE
            Lotto(listOf(1, 2, 3, 4, 10, 11)), // 4 matches -> MATCH_FOUR
            Lotto(listOf(1, 2, 3, 10, 11, 12)),// 3 matches -> MATCH_THREE
            Lotto(listOf(1, 2, 10, 11, 12, 13))// less than 3 matches -> no prize
        )
        val player = Player(
            moneySpent = 6000,
            lottoTickets = tickets
        )
        val rankCounts = Calculator.getRankDetails(player, winningDraw)
        assertEquals(1, rankCounts[LottoRank.MATCH_SIX]?.first)    // First
        assertEquals(1, rankCounts[LottoRank.MATCH_BONUS]?.first)  // Second
        assertEquals(1, rankCounts[LottoRank.MATCH_FIVE]?.first)   // Third
        assertEquals(1, rankCounts[LottoRank.MATCH_FOUR]?.first)   // Fourth
        assertEquals(1, rankCounts[LottoRank.MATCH_THREE]?.first)  // Fifth
    }


    @Test
    fun `should correctly calculate profit percentage`() {
        assertRandomUniqueNumbersInRangeTest(
            {
                run("1000", "9,24,27,29,31,41", "1")

                lottoMachine.buyTickets(player)
                lottoMachine.submitWinningData()
                lottoMachine.showWinningStats(player)

                assertThat(player.returnRate).isEqualTo(500.0)
            },
            listOf(9, 24, 27, 30, 35, 36)
        )
    }

    @Test
    fun `Calculator should correctly calculate total prize`() {
        val resultMap = mapOf(
            LottoRank.MATCH_THREE to (2 to LottoRank.MATCH_THREE.prizeMoney),
            LottoRank.MATCH_FOUR to (1 to LottoRank.MATCH_FOUR.prizeMoney)
        )

        val totalPrize = Calculator.calculateRankEarnings(resultMap)

        assertEquals(2 * LottoRank.MATCH_THREE.prizeMoney + LottoRank.MATCH_FOUR.prizeMoney, totalPrize)
    }
    
    override fun runMain() {
    }
}


