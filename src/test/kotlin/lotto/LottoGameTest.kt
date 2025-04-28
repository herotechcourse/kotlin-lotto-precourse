package lotto

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertEquals

class LottoGameTest {
    @Test
    fun `LottoGame - Purchase Amount Test`() {
        val lottoGame = LottoGame()
        val amount = 7000
        val lottos = lottoGame.purchase(amount)
        assertEquals(7, lottos.size)
    }

    @Test
    fun `LottoGame - Each Lotto should have 6 numbers`() {
        val lottoGame = LottoGame()
        val amount = 3000
        val lottos = lottoGame.purchase(amount)
        lottos.forEach { lotto ->
            assertEquals(6, lotto.getNumbers().size)
        }
    }

    @Test
    fun `LottoGame - getResult Test`() {
        val lottoGame = LottoGame()
        val lottos = listOf(
            Lotto(listOf(1, 2, 3, 4, 5, 6)),    
            Lotto(listOf(1, 2, 3, 4, 5, 7)),    
            Lotto(listOf(1, 2, 3, 4, 8, 9)),  
            Lotto(listOf(1, 2, 3, 7, 8, 9)), 
            Lotto(listOf(5, 6, 7, 8, 9, 10))   
        )
        val winning = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val bonusNumber = 7
        val result = lottoGame.getResult(lottos, winning, bonusNumber)

        assertEquals(1, result[LottoPrize.FIRST.ordinal])   // 1 ticket with 6 matches
        assertEquals(1, result[LottoPrize.SECOND.ordinal])  // 1 ticket with 5 matches + bonus
        assertEquals(1, result[LottoPrize.FOURTH.ordinal])  // 1 ticket with 4 matches
        assertEquals(1, result[LottoPrize.FIFTH.ordinal])   // 1 ticket with 3 matches
        assertEquals(0, result[LottoPrize.THIRD.ordinal])   // no ticket with 5 matches without bonus
    }
}
