package lotto
import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun main() {
    // 1. Get purchase amount and validate
    var numberPurchase: Int
    while (true) {
        println("Purchase amount for lottery tickets:")
        val purchaseAmount = Console.readLine()

        try {
            numberPurchase = purchaseAmount.toIntOrNull() ?: throw IllegalArgumentException("[ERROR] Invalid input. Please enter a valid number.")
            if (numberPurchase <= 0 || numberPurchase % 1000 != 0) {
                throw IllegalArgumentException("[ERROR] The purchase amount must be a positive integer and divisible by 1,000")
            }
            break
        } catch (e: IllegalArgumentException) {
            println(e.message)
        }
    }

    println("\nYou have purchased ${numberPurchase / 1000} tickets.")

    // 2. Generate lottery numbers
    val ticketAmount = numberPurchase / 1000
    val ticketList = List(ticketAmount) { Randoms.pickUniqueNumbersInRange(1, 45, 6) }
    ticketList.forEach {
        println(it)
    }

    // 3. Get winning numbers and validate
    var sortedWinningNumbers: List<Int>
    while (true) {
        println("\nPlease enter last week's winning numbers (comma separated):")
        val winningNumbers = Console.readLine() ?: ""
        try {
            val winningNumberList = winningNumbers.split(",")
                .map { it.trim().toInt() }

            val distinctWinningNumbers = winningNumberList.distinct()
            sortedWinningNumbers = distinctWinningNumbers.sorted()

            if (sortedWinningNumbers.size != 6) {
                throw IllegalArgumentException("[ERROR] Winning numbers should be 6 and should not be duplicated.")
            }

            for (number in sortedWinningNumbers) {
                if (number < 1 || number > 45) {
                    throw IllegalArgumentException("[ERROR] Each number must be between 1 and 45: '$number'")
                }
            }
            break
        } catch (e: Exception) {
            println("[ERROR] Invalid input. Please enter valid winning numbers (comma separated, integers between 1 and 45).")
        }
    }

    // 4. Get bonus number and validate
    var intBonusNumbers: Int
    while (true) {
        println("\nPlease enter the bonus number:")
        val bonusNumber = Console.readLine() ?: throw IllegalArgumentException("No input provided.")
        try {
            intBonusNumbers = bonusNumber.toInt()
            if (intBonusNumbers < 1 || intBonusNumbers > 45) {
                throw IllegalArgumentException("[ERROR] Bonus number must be between 1 and 45.")
            }
            break
        } catch (e: NumberFormatException) {
            println("[ERROR] Bonus number must be a valid integer.")
        }
    }

    // 5. Compare each ticket's numbers with the winning numbers
    val prizeList: MutableList<Int> = mutableListOf()
    ticketList.forEach {
        val ticket = Lotto(it)
        val prize = ticket.matchPrize(sortedWinningNumbers, intBonusNumbers)
        prizeList.add(prize)
    }

    // 6. Print the result statistics
    println("\nWinning Statistics")
    println("---")
    println("3 Matches (5,000 KRW) – ${prizeList.count { it == 5 }} tickets")
    println("4 Matches (50,000 KRW) – ${prizeList.count { it == 4 }} tickets")
    println("5 Matches (1,500,000 KRW) – ${prizeList.count { it == 3 }} tickets")
    println("5 Matches + Bonus Ball (30,000,000 KRW) – ${prizeList.count { it == 2 }} tickets")
    println("6 Matches (2,000,000,000 KRW) – ${prizeList.count { it == 1 }} tickets")

    //Calculate profit
    val profit = (5000 * prizeList.count { it == 5 } +
            50000 * prizeList.count { it == 4 } +
            1500000 * prizeList.count { it == 3 } +
            30000000 * prizeList.count { it == 2 } +
            2000000000 * prizeList.count { it == 1 })

    //Calculate profit rate
    val profitRate = profit.toDouble() / numberPurchase * 100
    println("Total return rate is ${profitRate}%.")
}
