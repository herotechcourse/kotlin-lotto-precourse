package lotto

import lotto.InputValidation.WinningNumbersValidation
import camp.nextstep.edu.missionutils.Console
import lotto.InputValidation.AmountValidation
import lotto.InputValidation.BonusNumberValidation

private val input = InputView()
private val amountValidator = AmountValidation()
private val winningNumbersvalidator = WinningNumbersValidation()
private val bonusNumberValidation = BonusNumberValidation()
private val output = OutputView()

fun main() {

    println("Purchase amount for lottery tickets: ")
    try {
        val amount = input.InputPurchaseAmount()
        val purchaseAmount = amountValidator.NullCheckNumber(amount)
        amountValidator.ValidateAmount(purchaseAmount)

        println("Winning numbers (comma-separated):")
        val numbers = input.InputWinningNumbers()
        winningNumbersvalidator.NullCheckWinningNumber(numbers)
        val winningNumbers = winningNumbersvalidator.SplitNumbersIntoList(numbers)
        val lottoVariable = Lotto(winningNumbers)

        println("Bonus number:")
        val bonus_no = input.InputBonusNumber()
        val bonus_number = amountValidator.NullCheckNumber(bonus_no)
        bonusNumberValidation.ValidateBonusNumberInRange1to45(bonus_number)
        bonusNumberValidation.ValidateBonusNumberUniqueness(bonus_number, winningNumbers)


        val numberOfTickets = lottoVariable.CalculateNumberOfTickets(purchaseAmount)
        val tickets = lottoVariable.GenerateLottoTickets(numberOfTickets)
        output.PrintLottoTickets(tickets, numberOfTickets)

        val lottoMachine = LottoMachine()
        print("\nWinning Statistics\n" + "---\n")
        var totalPrize = lottoMachine.MatchNumbers(bonus_number, tickets, winningNumbers)
        val profit = lottoMachine.ProfitCalculation(totalPrize, purchaseAmount)
        output.PrintReturnRate(profit)

    } catch (e: IllegalArgumentException) {
        println(e.message)
    }
}