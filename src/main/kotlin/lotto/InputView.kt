package lotto

class InputView {
    fun getAmount(): Int? {
        println("Please enter the purchase amount.")
        val amount = readLine()
        return amount?.toIntOrNull()
    }

    fun getWinningNumbers(): List<Int?>? {
        println("Please enter last week's winning numbers")
        val winningNumbers = readLine()
        return winningNumbers?.split(",")?.map { it.toIntOrNull() }
    }

    fun getBonusNumber(): Int? {
        println("Please enter the bonus number")
        val bonus = readLine()
        return bonus?.toIntOrNull()
    }
}