package lotto

private val input = InputView()
private val output = OutputView()

fun main() {

    println("Purchase amount for lottery tickets: ")
    try {
        //Take in input - purchase amount,winning numbers and bonus number
        val purchaseAmount = input.InputPurchaseAmount()
        val (winningNumbers, lottoVariable) = input.InputWinningNumbers()
        val bonus_number = input.InputBonusNumber(winningNumbers)

        //Calculate number of tickets and generate the tickets
        val numberOfTickets = lottoVariable.CalculateNumberOfTickets(purchaseAmount)
        val tickets = lottoVariable.GenerateLottoTickets(numberOfTickets)
        output.PrintLottoTickets(tickets, numberOfTickets)

        //Compare the tickets to the winning numbers and calculate the total prize money
        val lottoMachine = LottoMachine()
        print("\nWinning Statistics\n" + "---\n")
        var totalPrize = lottoMachine.MatchNumbers(bonus_number, tickets, winningNumbers)
        val profit = lottoMachine.ProfitCalculation(totalPrize, purchaseAmount)
        output.PrintReturnRate(profit)

    } catch (e: IllegalArgumentException) {
        println(e.message)
    }
}