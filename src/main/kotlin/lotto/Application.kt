package lotto

import camp.nextstep.edu.missionutils.Randoms

fun main() {
        val lotteryMachine = LotteryMachine()

    while (amount == null || amount < 1000) {
        println("Please enter the amount you want to spend:")
        amount = readlnOrNull()?.toIntOrNull()

        if (amount == null || amount < 1000) {
            println("Invalid amount. Please enter a valid number greater than or equal to 1000.")
        }
    }
    val numberOfTickets = amount / 1000
    println("You can buy $numberOfTickets ticket(s).")

    repeat(numberOfTickets) {
        val ticket = Randoms.pickUniqueNumbersInRange(1, 45, 6)
            .sorted()

        println("You entered: $amount")
    }
}