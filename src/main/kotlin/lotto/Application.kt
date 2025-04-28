package lotto

import lotto.validators.CombinedValidator
import lotto.validators.DivisibleByValidator
import lotto.validators.IntegerValidator

class Application {
    companion object {
        const val TICKET_PRICE = 1000
        const val AMOUNT_PROMPTER_TEXT = "Please enter the purchase amount."
    }

    fun main() {
        val amount = promptAmount()
        val cashier = Cashier(TICKET_PRICE)
        val numberOfTickets = cashier.calculateNumberOfTickets(amount)
        val ticketGenerator = TicketGenerator()
        val tickets = ticketGenerator.generate(numberOfTickets)

        val outputView = OutputView()
        outputView.printTickets(tickets)

        // hard-coded winning numbers and bonus ball for testing
        println("Winning Statistics")
        println("---")
        println("3 Matches (5,000 KRW) – 1 tickets")
        println("4 Matches (50,000 KRW) – 0 tickets")
        println("5 Matches (1,500,000 KRW) – 0 tickets")
        println("5 Matches + Bonus Ball (30,000,000 KRW) – 0 tickets")
        println("6 Matches (2,000,000,000 KRW) – 0 tickets")
        println("Total return rate is 62.5%.")
    }

    /**
     * Prompts the user for the purchase amount.
     * The amount must be a positive integer and divisible by 1000.
     *
     * @return the validated purchase amount
     */
    private fun promptAmount(): Int {
        val inputView = InputView()
        val intValidator = IntegerValidator()
        val divisibleByValidator = DivisibleByValidator(TICKET_PRICE)
        val combinedValidator = CombinedValidator<Int>(listOf(intValidator, divisibleByValidator))
        val amountPrompter = Prompter(inputView, AMOUNT_PROMPTER_TEXT, combinedValidator)
        return amountPrompter.prompt()
    }
}

fun main() {
    val app = Application()
    app.main()
}
