package lotto.core

import lotto.Lotto
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
 class LottoGameTest {

  // Test evaluateTicket()
  // 1.  Returns the correct prize for a given ticket
  //   - 6 matching numbers → should return Prize.FIRST
  //   - 5 matching numbers + bonus number → should return Prize.SECOND
  //   - 5 matching numbers without bonus number → should return Prize.THIRD
  //   - 4 matching numbers → should return Prize.FOURTH
  //   - 3 matching numbers → should return Prize.FIFTH
  //   - Less than 3 matching numbers → should return Prize.NONE

  private val winningTicket = Lotto(listOf(1, 2, 3, 4, 5, 6))
  private val bonusNumber = 7
  private val lottoGame = LottoGame(winningTicket, bonusNumber)

@Test
 fun testEvaluateTicket_SixMatches() {
  val ticket = Lotto(listOf(1,2,3,4,5,6))
  val result = lottoGame.evaluateTicket(ticket)
  assertThat(result).isEqualTo(Prize.FIRST)
 }

  @Test
  fun testEvaluateTicket_FiveMatchesPlusBonus() {
   val ticket = Lotto(listOf(1,2,3,4,5,7))
   val result = lottoGame.evaluateTicket(ticket)
   assertThat(result).isEqualTo(Prize.SECOND)
  }

  @Test
  fun testEvaluateTicket_FiveMatches() {
   val ticket = Lotto(listOf(1,2,3,4,5,8))
   val result = lottoGame.evaluateTicket(ticket)
   assertThat(result).isEqualTo(Prize.THIRD)
  }

  @Test
  fun testEvaluateTicket_FourMatches() {
   val ticket = Lotto(listOf(1,2,3,4,8,9))
   val result = lottoGame.evaluateTicket(ticket)
   assertThat(result).isEqualTo(Prize.FOURTH)
  }

  @Test
  fun testEvaluateTicket_ThreeMatches() {
   val ticket = Lotto(listOf(1,2,3,8,9,10))
   val result = lottoGame.evaluateTicket(ticket)
   assertThat(result).isEqualTo(Prize.FIFTH)
  }

  @Test
  fun testEvaluateTicket_LessThanThreeMatches() {
   val ticket = Lotto(listOf(1,2,8,9,10,11))
   val result = lottoGame.evaluateTicket(ticket)
   assertThat(result).isEqualTo(Prize.NONE)
  }


@Test
 fun evaluateTickets() {}
}