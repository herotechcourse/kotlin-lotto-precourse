package lotto
import lotto.InputValidation.WinningNumbersValidation
import camp.nextstep.edu.missionutils.Console
import lotto.InputValidation.AmountValidation
import lotto.InputValidation.BonusNumberValidation



private val amountValidator = AmountValidation()
private val winningNumbersvalidator = WinningNumbersValidation()
private val bonusNumberValidation = BonusNumberValidation()

fun main() {

    println("Purchase amount for lottery tickets: ")
    try {
        val amount = InputPurchaseAmount()

        val purchaseAmount = amountValidator.NullCheckNumber(amount)
        amountValidator.ValidateAmount(purchaseAmount)


    println("Winning numbers (comma-separated):")
    val numbers = InputWinningNumbers()
    winningNumbersvalidator.NullCheckWinningNumber(numbers)
    val winningNumbers = winningNumbersvalidator.SplitNumbersIntoList(numbers)
    val lottoVariable = Lotto(winningNumbers)

    println("Bonus number:")
    val bonus_no = InputBonusNumber()
    val bonus_number = amountValidator.NullCheckNumber(bonus_no)
    bonusNumberValidation.ValidateBonusNumberInRange1to45(bonus_number)
    bonusNumberValidation.ValidateBonusNumberUniqueness(bonus_number,winningNumbers)

    val numberOfTickets = lottoVariable.CalculateNumberOfTickets(purchaseAmount)
    val tickets = lottoVariable.GenerateLottoTickets(numberOfTickets)
    lottoVariable.PrintLottoTickets(tickets, numberOfTickets)
    } catch (e: IllegalArgumentException) {
        println(e.message)}
}

fun InputPurchaseAmount() : String{
    val amount = Console.readLine()
    return amount
}

fun InputWinningNumbers() : String{
    val winning_numbers = Console.readLine()
    return winning_numbers
}

fun InputBonusNumber(): String{
    val bonus_number = Console.readLine()
    return bonus_number
}