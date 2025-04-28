package lotto.view
import camp.nextstep.edu.missionutils.Console
object InputView {
    fun readPurchaseAmount(): String{
        println("Please enter purchase amount:")
        return Console.readLine().trim()

    }
    fun readWinningNumbers(): String{
        println("Please enter last week's winning numbers:")
        return Console.readLine().trim()

    }
    fun readBonusNumbers(): String{
        println("Please enter the bonus numbers:")
        return Console.readLine().trim()

    }

}