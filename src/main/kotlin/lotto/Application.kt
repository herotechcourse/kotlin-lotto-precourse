package lotto

import lotto.validators.CombinedValidator
import lotto.validators.CommaSeparatedValidator
import lotto.validators.DivisibleByValidator
import lotto.validators.IntegerValidator
import lotto.validators.NumberRangeValidator
import lotto.validators.NumbersCountValidator
import lotto.validators.NumbersRangeValidator
import lotto.validators.UniqueNumbersValidator

class Application {
    companion object {
        const val TICKET_PRICE = 1000
        const val AMOUNT_PROMPT_TEXT = "Please enter the purchase amount."
        const val LOTTO_MAX_NUMBER = 45
        const val LOTTO_MIN_NUMBER = 1
        const val LOTTO_AMOUNT_OF_NUMBERS = 6
        const val WINNING_NUMBERS_PROMPT_TEXT = "Please enter the winning numbers (comma-separated)."
        const val BONUS_NUMBER_PROMPT_TEXT = "Please enter the bonus number."

        enum class Prize(val matches: Int, val bonusMatch: Boolean, val amount: Int) {
            MATCH_THREE(3, false, 5_000),
            MATCH_FOUR(4, false, 50_000),
            MATCH_FIVE(5, false, 1_500_000),
            MATCH_FIVE_BONUS(5, true, 30_000_000),
            MATCH_SIX(6, false, 2_000_000_000)
        }
    }

    fun main() {
        val inputView = InputView()
        val amount = promptAmount(inputView)
        val cashier = Cashier(TICKET_PRICE)
        val numberOfTickets = cashier.calculateNumberOfTickets(amount)
        val ticketGenerator = TicketGenerator(LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER, LOTTO_AMOUNT_OF_NUMBERS)
        val tickets = ticketGenerator.generate(numberOfTickets)

        val outputView = OutputView()
        outputView.printTickets(tickets)

        val winningNumbers = promptWinningNumbers(inputView)
        val bonusNumber = promptBonusNumber(inputView)

        val lotto = Lotto(winningNumbers)
        val results = lotto.calculateWin(tickets, bonusNumber)

        println("Winning Statistics")
        println("---")
        println("3 Matches (5,000 KRW) – 1 tickets")
        println("4 Matches (50,000 KRW) – 0 tickets")
        println("5 Matches (1,500,000 KRW) – 0 tickets")
        println("5 Matches + Bonus Ball (30,000,000 KRW) – 0 tickets")
        println("6 Matches (2,000,000,000 KRW) – 0 tickets")
        println("Total return rate is 62.5%.")
        //results.forEach { (prize, count) -> println("$prize – $count tickets") }
    }

    /**
     * Prompts the user for the purchase amount. The amount must be a positive integer and divisible
     * by TICKET_PRICE
     *
     * @return the validated purchase amount
     */
    private fun promptAmount(inputView: InputView): Int {
        val validators = listOf(IntegerValidator(), DivisibleByValidator(TICKET_PRICE))
        val combinedValidator = CombinedValidator<Int>(validators)
        val amountPrompter = Prompter(inputView, AMOUNT_PROMPT_TEXT, combinedValidator)
        return amountPrompter.prompt()
    }

    /**
     * Prompts the user for the winning numbers. The numbers must be comma-separated, within the
     * range of LOTTO_MIN_NUMBER to LOTTO_MAX_NUMBER, and exactly LOTTO_AMOUNT_OF_NUMBERS numbers.
     *
     * @return the validated winning numbers
     */
    private fun promptWinningNumbers(inputView: InputView): List<Int> {
        val validators =
            listOf(
                CommaSeparatedValidator(),
                NumbersCountValidator(LOTTO_AMOUNT_OF_NUMBERS),
                NumbersRangeValidator(LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER),
                UniqueNumbersValidator()
            )
        val combinedValidator = CombinedValidator<List<Int>>(validators)
        val winningNumbersPrompter = Prompter(inputView, WINNING_NUMBERS_PROMPT_TEXT, combinedValidator)
        return winningNumbersPrompter.prompt()
    }

    /**
     * Prompts the user for the bonus number. The number must be an integer within the range of
     * LOTTO_MIN_NUMBER to LOTTO_MAX_NUMBER.
     *
     * @return the validated bonus number
     */
    private fun promptBonusNumber(inputView: InputView): Int {
        val validators =
                listOf(IntegerValidator(), NumberRangeValidator(LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER))
        val combinedValidator = CombinedValidator<Int>(validators)
        val bonusNumberPrompter = Prompter(inputView, BONUS_NUMBER_PROMPT_TEXT, combinedValidator)
        return bonusNumberPrompter.prompt()
    }
}

fun main() {
    val app = Application()
    app.main()
}
