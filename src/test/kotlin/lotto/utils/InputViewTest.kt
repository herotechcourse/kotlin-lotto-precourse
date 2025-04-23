package lotto.utils

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class InputViewTest {
 // readPurchaseAmount
// 1. input cannot be empty
 @Test
 fun testReadPurchaseAmount_throwsExceptionIfInputIsEmpty() {
  val input = ""
  assertThrows<IllegalArgumentException> {
   InputView.parsePurchaseAmount(input)}
 }

// 2. input must be a number
 @Test
 fun testReadPurchaseAmount_throwsExceptionIfInputIsNotANumber() {
  val input = "abc"
  assertThrows<NumberFormatException> {
   InputView.parsePurchaseAmount(input)}
 }
// 3. input must be divisible by 1000
 @Test
 fun testReadPurchaseAmount_throwsExceptionIfInputIsNotDivisibleBy1000() {
  val input = "1001"
  assertThrows<IllegalArgumentException> {
   InputView.parsePurchaseAmount(input)}
 }

// 4. input must be greater than 0
 @Test
 fun testReadPurchaseAmount_throwsExceptionIfInputIsLessThan0() {
  assertThrows<IllegalArgumentException> {
   InputView.parsePurchaseAmount("-1")}
 assertThrows<IllegalArgumentException> {
   InputView.parsePurchaseAmount("0")}
 }

}