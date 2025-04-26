package lotto.domain

import WinningNumbers
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class WinningNumbersTest {

 @Test
 fun `should return SIX_MATCHES when all numbers match`() {
  val winningNumbers = WinningNumbers(
   numbers = listOf(1, 2, 3, 4, 5, 6),
   bonus = 7
  )
  val ticket = Lotto(listOf(1, 2, 3, 4, 5, 6))

  val result = winningNumbers.match(ticket)

  assertThat(result).isEqualTo(PrizeCategory.SIX_MATCHES)
 }

 @Test
 fun `should return FIVE_MATCHES_BONUS when 5 numbers and bonus match`() {
  val winningNumbers = WinningNumbers(
   numbers = listOf(1, 2, 3, 4, 5, 6),
   bonus = 7
  )
  val ticket = Lotto(listOf(1, 2, 3, 4, 5, 7))

  val result = winningNumbers.match(ticket)

  assertThat(result).isEqualTo(PrizeCategory.FIVE_MATCHES_BONUS)
 }

 @Test
 fun `should return FIVE_MATCHES when only 5 numbers match`() {
  val winningNumbers = WinningNumbers(
   numbers = listOf(1, 2, 3, 4, 5, 6),
   bonus = 7
  )
  val ticket = Lotto(listOf(1, 2, 3, 4, 5, 8))

  val result = winningNumbers.match(ticket)

  assertThat(result).isEqualTo(PrizeCategory.FIVE_MATCHES)
 }

 @Test
 fun `should return NO_MATCH when no numbers match`() {
  val winningNumbers = WinningNumbers(
   numbers = listOf(1, 2, 3, 4, 5, 6),
   bonus = 7
  )
  val ticket = Lotto(listOf(8, 9, 10, 11, 12, 13))

  val result = winningNumbers.match(ticket)

  assertThat(result).isEqualTo(PrizeCategory.NONE)
 }
}