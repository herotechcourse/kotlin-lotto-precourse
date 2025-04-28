package lotto

import service.InputProcessingService
import service.LottoMatchService
import util.safeRun
import view.InputView
import view.OutputView

fun main() {
    val tickets = readTickets()
    val winningNumbers = readWinningNumbers()
}

private fun readTickets(): Tickets =
    readValidInput(
        prompt = {OutputView.promptPurchaseAmount()},
        parser = { input ->
            val amount =InputProcessingService.validateInputInteger(input)
                .also { InputProcessingService.validatePurchaseAmount(it) }

            Tickets(amount).also { t ->
                OutputView.printTicketCount(t.ticketCount)
                OutputView.printTickets(t.lottos.map { it.numbers })
            }
        }
    )

private fun readWinningNumbers(): WinningNumbers {
    val numbers: List<Int> = readValidInput(
        prompt = {OutputView.promptWinningNumbers()},
        parser ={ input -> InputProcessingService.splitWinningNumbers(input)
        }
    )

    val bonus : Int = readValidInput(
        prompt = {OutputView.promptBonusNumber()},
        parser = { input -> InputProcessingService.validateInputInteger(input)
            .also{ InputProcessingService.validateNumberInLottoRange(it)}
            .also { InputProcessingService.validateBonusNumber(it, numbers)}
        }
    )

    return WinningNumbers(numbers, bonus)

}

private fun <T> readValidInput(prompt:() -> Unit, parser: (String) -> T): T {
    var result: T? = null

    while (result ==null){
        safeRun{
            prompt()
            result = parser(InputView.getInput())
        }
    }

    return result!!
}