package lotto

import camp.nextstep.edu.missionutils.Console
import lotto.domain.model.Lotties
import lotto.domain.model.Money
import lotto.domain.model.WinningNumbers
import lotto.domain.service.*
import lotto.view.InputHandler
import lotto.view.OutputHandler

fun main() {
    val inputHandler = InputHandler()
    val outputHandler = OutputHandler()
    val randomNumberGenerator = RandomNumberGenerator()

    val lottoApplication = createLottoApplication(inputHandler, outputHandler, randomNumberGenerator)
    lottoApplication.run()
}

fun createLottoApplication(inputHandler : InputHandler, outputHandler: OutputHandler, randomNumberGenerator: RandomNumberGenerator): LottoApplication {
    val money = readMoney(inputHandler)

    return LottoApplication(
        inputHandler = inputHandler,
        outputHandler = outputHandler,
        randomNumberGenerator = randomNumberGenerator,
        money = money
    )
}

fun readMoney(inputHandler: InputHandler): Money {
    val amount = inputHandler.readPurchaseAmount({ Console.readLine() })
    return Money(amount)
}

class LottoApplication(
    private val inputHandler: InputHandler,
    private val outputHandler: OutputHandler,
    private val randomNumberGenerator: RandomNumberGenerator,
    private val money: Money,
) {
    private val lottoMachine = LottoMachine(
        lottoGenerator = LottoGenerator(randomNumberGenerator),
        money = money
    )

    fun run() {
        val lotties = issueLotties()
        val winningNumbers = readWinningNumbers()
        val result = calculateResults(lotties, winningNumbers)

        printStatistics(result)
    }

    private fun issueLotties(): Lotties {
        val lotties = lottoMachine.issueLotties()
        outputHandler.printLotties(lotties.value)
        return lotties
    }

    private fun readWinningNumbers(): WinningNumbers {
        val winningNumbers = inputHandler.readWinningNumbers({ Console.readLine() })
        val bonusNumber = inputHandler.readBonusNumbers({ Console.readLine() }, winningNumbers)
        return lottoMachine.createWinningNumbers(winningNumbers, bonusNumber)
    }

    private fun calculateResults(
        lotties: Lotties,
        winningNumbers: WinningNumbers
    ): WinResult {
        return lottoMachine.calculateResult(lotties, winningNumbers)
    }

    private fun printStatistics(result: WinResult) {
        val statistics = Statistics()
        outputHandler.printStatistics(result, statistics.calculateTotalReturnRate(money, result))
    }
}
