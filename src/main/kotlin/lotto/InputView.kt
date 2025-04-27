import camp.nextstep.edu.missionutils.Console

object InputView {
    fun readAmount(): Int {
        println("Please enter the purchase amount.")
        return Console.readLine().orEmpty().toIntOrNull() ?: throw IllegalArgumentException()
    }

    fun readWinningNumbers(): List<Int> {
        println("Please enter last week's winning numbers.")
        return Console.readLine().orEmpty()
            .split(",")
            .map { it.toInt() }
    }

    fun readBonusNumber(): Int {
        println("Please enter the bonus number.")
        return Console.readLine().orEmpty().toInt()
    }
}