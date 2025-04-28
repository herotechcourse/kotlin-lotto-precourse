package lotto

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertEquals

class WinningNumbersTest {

    @Test
    fun `should match lotto ticket with winning numbers`() {
        val winningNumbers = WinningNumbers(listOf(1, 2, 3, 4, 5, 6), 7)
        val ticket = Lotto(listOf(1, 2, 3, 4, 5, 6))

        val rank = winningNumbers.match(ticket)

        assertEquals(Rank.FIRST, rank)
    }
}

class LottoResultTest {

    @Test
    fun `should calculate lotto results according to statistics`() {
        // 결과를 리스트로 생성하고 LottoResult 객체를 생성합니다.
        val results = listOf(Rank.FIRST, Rank.SECOND, Rank.THIRD, Rank.FOURTH)
        val lottoResult = LottoResult(results)

        // 각 등수별로 맞은 티켓 수를 세고 그것이 기대되는 값과 일치하는지 확인합니다.
        assertEquals(1, lottoResult.count(Rank.FIRST))
        assertEquals(1, lottoResult.count(Rank.SECOND))

        // 각 등수의 'description'을 출력하여 형식이 정확한지 확인합니다.
        assertEquals("6 Matches (2,000,000,000 KRW)", Rank.FIRST.description())
        assertEquals("5 Matches + Bonus Ball (30,000,000 KRW)", Rank.SECOND.description())
        assertEquals("5 Matches (1,500,000 KRW)", Rank.THIRD.description())
        assertEquals("4 Matches (50,000 KRW)", Rank.FOURTH.description())
    }
}
