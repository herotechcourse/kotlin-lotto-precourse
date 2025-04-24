package lotto
import lotto.InputValidation.WinningNumbersValidation
import camp.nextstep.edu.missionutils.Console
import lotto.InputValidation.AmountValidation

private val amountValidator = AmountValidation()
private val winningNumbersvalidator = WinningNumbersValidation()

fun main() {

    println("Purchase amount for lottery tickets: ")
    val amount = InputPurchaseAmount()
    val purchaseAmount = amountValidator.NullCheckAmount(amount)
    amountValidator.ValidateAmount(purchaseAmount)

    println("Winning numbers (comma-separated):")
    val numbers = InputWinningNumbers()
    winningNumbersvalidator.NullCheckWinningNumber(numbers)
    val winningNumbers = winningNumbersvalidator.SplitNumbersIntoList(numbers)
    winningNumbersvalidator.SizeOfWinningNumberValidation(winningNumbers)
    winningNumbersvalidator.ValidateWinningNumberInRange1to45(winningNumbers)
    winningNumbersvalidator.UniqueWinningNumbersValidation(winningNumbers)
}

fun InputPurchaseAmount() : String{
    val amount = Console.readLine()
    return amount
}

fun InputWinningNumbers() : String{
    val winning_numbers = Console.readLine()
    return winning_numbers
}
