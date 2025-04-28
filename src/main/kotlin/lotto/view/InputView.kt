package lotto.view
import camp.nextstep.edu.missionutils.Console

object InputView {
    fun readPurchaseAmount(): String {
        println("Please enter the purchase amount.")
        return Console.readLine()
    }

    fun readLottoNumbers(): String {
        println("Please enter last week's winning numbers.")
        return Console.readLine()
    }

    fun readBonusNumber(): String {
        println("Please enter the bonus number.")
        return Console.readLine()
    }
}