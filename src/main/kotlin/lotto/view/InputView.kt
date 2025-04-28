package lotto.view

import camp.nextstep.edu.missionutils.Console
import lotto.UserInput

class InputView {
    companion object {
        fun promptPurchaseAmount(userInput: UserInput) {
            println("Please enter the purchase amount.")
            val purchaseAmount = Console.readLine()
            userInput.setPurchaseAmount(purchaseAmount)
            println()
        }

        fun promptWinningNumbers(userInput: UserInput) {
            println("Please enter last week's winning numbers.")
            val winningNumbers = Console.readLine()
            userInput.setWinningNumbers(winningNumbers)
            println()
        }

        fun promptBonusNumber(userInput: UserInput) {
            println("Please enter the bonus number.")
            val bonusNumber = Console.readLine()
            userInput.setBonusNumber(bonusNumber)
            println()
        }
    }
}