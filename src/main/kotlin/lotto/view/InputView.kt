package lotto.view

import camp.nextstep.edu.missionutils.Console
import lotto.MIN_RANGE
import lotto.view.OutputView

object InputView {

  // TODO: implement reprompting of invalid input
  fun returnSpend() : Int {
    OutputView.promptUser("Please enter the amount of money you want to spend.")
    val input = Console.readLine().trim().toIntOrNull()
    ?: throw IllegalArgumentException("[ERROR] spending amount must be a valid number.")
    require(input % 1000 == 0) { "[ERROR] spending amount must be divisible by 1,000." }
    require(input < 100001) { "[ERROR] spending amount must not be greater than 100,000 to avoid game overload." }
    return input
    }

  // returns winning list of inputted numbers, only parsing errors are handled for now
  fun returnWinningTicket(): List<Int> {
    OutputView.promptUser("Please enter the winning numbers.")
    val input = Console.readLine()?.trim()
      ?: throw IllegalArgumentException("[ERROR] winning numbers should be a valid number separated by ','.")
    require(input.contains(",")) { "[ERROR] winning numbers must be separated by commas." }
    val numbers = input.split(",").map { it.trim().toIntOrNull()}
      if(numbers.any{it == null}) {
        throw IllegalArgumentException("[ERROR] winning numbers should not be null.")
      }
    val parsed = numbers.filterNotNull()
    return parsed
  }


  fun returnBonusNumber(): Int {
    OutputView.promptUser("Please enter the bonus number.")
    val input = Console.readLine().trim().toIntOrNull()
      ?: throw IllegalArgumentException("[ERROR] bonus number was not a valid number.")
      require(input in MIN_RANGE..lotto.MAX_RANGE) { "[ERROR] bonus number must be between $MIN_RANGE and ${lotto.MAX_RANGE}." }
    return input
  }
}
