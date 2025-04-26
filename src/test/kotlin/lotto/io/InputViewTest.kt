package lotto.io

import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.assertThrows

class InputViewTest {

 class TestIO : IOInterface {
  private val inputs = mutableListOf<String>()
  val outputs = mutableListOf<String>()

  override fun print(content: String) {
   outputs.add(content)
  }

  override fun read(): String {
   return if (inputs.isNotEmpty()) inputs.removeAt(0) else ""
  }

  fun addInput(vararg input: String) {
   inputs.addAll(input)
  }
 }

 @Test
 fun `should read valid purchase amount`() {
  val testIO = TestIO()
  testIO.addInput("3000")
  val inputView = InputView(testIO)

  val amount = inputView.readPurchaseAmount()

  assertThat(amount).isEqualTo(3000)
 }

 @Test
 fun `should throw error for invalid purchase amount`() {
  val testIO = TestIO()
  testIO.addInput("abc", "-1000", "1500", "3000")
  val inputView = InputView(testIO)

  val amount = inputView.readPurchaseAmount()

  assertThat(amount).isEqualTo(3000)
  assertThat(testIO.outputs).contains(
   "[ERROR] Please enter a valid number.",
   "[ERROR] Purchase amount must be greater than 0.",
   "[ERROR] Purchase amount must be divisible by 1000."
  )
 }

 @Test
 fun `should read valid winning numbers`() {
  val testIO = TestIO()
  testIO.addInput("1, 2, 3, 4, 5, 6")
  val inputView = InputView(testIO)

  val numbers = inputView.readWinningNumbers()

  assertThat(numbers).containsExactly(1, 2, 3, 4, 5, 6)
 }

 @Test
 fun `should throw error for invalid winning numbers`() {
  val testIO = TestIO()
  testIO.addInput("1, 2, 3, 4, 5", "1, 2, 3, 4, 5, 5", "1, 2, 3, 4, 5, 46", "1, 2, 3, 4, 5, 6")
  val inputView = InputView(testIO)

  val numbers = inputView.readWinningNumbers()

  assertThat(numbers).containsExactly(1, 2, 3, 4, 5, 6)
  assertThat(testIO.outputs).contains(
   "[ERROR] Please enter exactly 6 numbers.",
   "[ERROR] Winning numbers must be unique.",
   "[ERROR] Winning numbers must be between 1 and 45."
  )
 }

 @Test
 fun `should read valid bonus number`() {
  val testIO = TestIO()
  testIO.addInput("7")
  val inputView = InputView(testIO)

  val bonusNumber = inputView.readBonusNumber()

  assertThat(bonusNumber).isEqualTo(7)
 }

 @Test
 fun `should throw error for invalid bonus number`() {
  val testIO = TestIO()
  testIO.addInput("0", "46", "7")
  val inputView = InputView(testIO)

  val bonusNumber = inputView.readBonusNumber()

  assertThat(bonusNumber).isEqualTo(7)
  assertThat(testIO.outputs).contains(
   "[ERROR] Bonus number must be between 1 and 45."
  )
 }
}