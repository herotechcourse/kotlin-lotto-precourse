package lotto.utils

import lotto.Lotto
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class InputViewTest {
 // parsePurchaseAmount
// 1. input cannot be empty
 @Test
 fun testParsePurchaseAmount_throwsExceptionIfInputIsEmpty() {
  val input = ""
  assertThrows<IllegalArgumentException> {
   InputView.parsePurchaseAmount(input)}
 }

// 2. input must be a number
 @Test
 fun testParsePurchaseAmount_throwsExceptionIfInputIsNotANumber() {
  val input = "abc"
  assertThrows<NumberFormatException> {
   InputView.parsePurchaseAmount(input)}
 }
// 3. input must be divisible by 1000
 @Test
 fun testParsePurchaseAmount_throwsExceptionIfInputIsNotDivisibleBy1000() {
  val input = "1001"
  assertThrows<IllegalArgumentException> {
   InputView.parsePurchaseAmount(input)}
 }

// 4. input must be greater than 0
 @Test
 fun testParsePurchaseAmount_throwsExceptionIfInputIsLessThan0() {
  assertThrows<IllegalArgumentException> {
   InputView.parsePurchaseAmount("-1")}
 assertThrows<IllegalArgumentException> {
   InputView.parsePurchaseAmount("0")}
 }

 // 5. purchase valid input
 @Test
 fun testParsePurchaseAmount_returnsValidAmount() {
  val amount = InputView.parsePurchaseAmount("3000")
  assertEquals(3000, amount)
 }

 // testParseWinningTicket
 // 1. Winning numbers must be 6 numbers
 @Test
 fun testParseWinningTicket_throwExceptionIfNotSixNumbers() {
  assertThrows<IllegalArgumentException>{
   InputView.parseWinningTicket(listOf(1,2,3,4,5,6,7))
  }
  assertThrows<IllegalArgumentException>{
   InputView.parseWinningTicket(listOf(1,2,3,4,5))
  }

 }

 // 2. Numbers must be unique
 @Test
 fun testParseWinningTicket_throwExceptionIfNotUnique() {
  assertThrows<IllegalArgumentException> {
   InputView.parseWinningTicket(listOf(1,1,3,4,5,6,7))
  }
 }

 // 3. Numbers must be in range 1-45
 @Test
 fun testParseWinningTicket_throwExceptionIfNotInRange() {
  assertThrows<IllegalArgumentException> {
   InputView.parseWinningTicket(listOf(1,2,3,4,5,46))
  }
  assertThrows<IllegalArgumentException> {
   InputView.parseWinningTicket(listOf(1,2,3,4,5,6,0))
  }
  assertThrows<IllegalArgumentException> {
   InputView.parseWinningTicket(listOf(50,2,3,4,5,6))
  }
 }

 // 4. Parse valid winning ticket
 @Test
 fun testParseWinningTicket_returnsValidLotto() {
  val lotto = InputView.parseWinningTicket(listOf(1, 2, 3, 4, 5, 6))
  val expected = Lotto(listOf(1, 2, 3, 4, 5, 6))

  assertThat(lotto.display()).isEqualTo(expected.display())
 }

 // Parse bonus number
 // 1. Input cannot be empty
 @Test
 fun testParseBonusNumber_throwExceptionIfEmpty() {
  val input = "";
  assertThrows<IllegalArgumentException>{InputView.parseBonusNumber(input)}
 }

 // 2. Input must be a number
 @Test
 fun testParseBonusNumber_throwExceptionIfNotANumber() {
  val input = "r";
  assertThrows<IllegalArgumentException>{InputView.parseBonusNumber(input)}
 }

 // 3. Bonus must be in range 1-45
 @Test
 fun testParseBonusNumber_throwExceptionIfNotInRanger() {
  assertThrows<IllegalArgumentException>{InputView.parseBonusNumber("0")}
  assertThrows<IllegalArgumentException>{InputView.parseBonusNumber("46")}
 }

 // 4. Parse a valid input
 @Test
 fun testParseBonusNumber_returnValidNumber() {
  val bonusNumber = InputView.parseBonusNumber("1")
  assertEquals(1, bonusNumber)
 }
}