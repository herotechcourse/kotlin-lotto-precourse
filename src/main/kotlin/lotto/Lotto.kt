package lotto
import lotto.views.InputView

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6) { "[ERROR] Lotto must contain exactly 6 numbers." }
    }
    val inputView = InputView()
    val tickets = inputView.inputTickets()
    val winningNumbers = inputView.inputWinningNumber()
    val singleNumber = inputView.inputSingleNumber(winningNumbers)

    // TODO: Implement additional functions
}
