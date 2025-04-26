package lotto.view
import camp.nextstep.edu.missionutils.Console

class InputView {
    fun purchaseAmount() : Int? {
        println("Please enter the purchase amount.")
        return Console.readLine().toIntOrNull()
    }

    fun winningNumbers(): List<Int?> {
        println("Please enter last week's winning numbers.")
        val input = Console.readLine()
        return input.split(',').map { num -> num.toIntOrNull() };
    }

    fun bonusNumber(): Int? {
        println("Please enter the bonus number.")
        return Console.readLine().toIntOrNull()
    }
}