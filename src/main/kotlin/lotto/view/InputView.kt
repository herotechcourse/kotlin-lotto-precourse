package lotto.view

import camp.nextstep.edu.missionutils.Console
import lotto.utils.Validator

object InputView {
  fun readPurchaseAmount(): Int {
    println("please enter the purchase amount.")
    return Validator.validateAmount(Console.readLine())
  }
  fun readWinningNumbers(): List<Int>{
    println("please enter last week's winning numbers.")
    return Validator.validateWinningNumbers(Console.readLine())
  }

  fun readBonusNumber(): Int {
    println("please enter the bonus number")
    return Validator.validateBonusNumber(Console.readLine())
  }
}