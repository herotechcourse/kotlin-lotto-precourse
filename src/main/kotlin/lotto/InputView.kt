package lotto

import camp.nextstep.edu.missionutils.Console

// Input view for handling user inputs
class InputView {
    fun readPurchaseAmount(): Int {
        println("Enter purchase amount (must be divisible by 1,000): ")
        return Console.readLine().toIntOrNull()
            ?.takeIf { it % 1000 == 0 }
            ?: throw IllegalArgumentException("[ERROR] Purchase amount must be divisible by 1,000.")
    }

    fun readWinningNumbers(): List<Int> {
        println("Enter 6 winning numbers (space-separated): ")
        return Console.readLine()
            ?.split(" ")
            ?.map { it.toIntOrNull() }
            ?.filterNotNull()
            ?.distinct()
            ?.takeIf { it.size == 6 && it.all { num -> num in 1..45 } }
            ?: throw IllegalArgumentException("[ERROR] Invalid winning numbers input.")
    }

    fun readBonusNumber(): Int {
        println("Enter bonus number: ")
        return Console.readLine()?.toIntOrNull()
            ?.takeIf { it in 1..45 }
            ?: throw IllegalArgumentException("[ERROR] Invalid bonus number input.")
    }
}
