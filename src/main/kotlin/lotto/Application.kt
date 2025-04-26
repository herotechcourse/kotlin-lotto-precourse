package lotto

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun main() {
    try {
        playGame()
    } catch (e: IllegalArgumentException) {
        println(e.message)
    }
}

fun playGame() {
    println("Please enter the purchase amount.")

    val money = try {
        Console.readLine().trim().toInt()
    } catch (e: NumberFormatException) {
        throw IllegalArgumentException("[ERROR] Please enter a valid purchase amount.")
    }
    val ticketCount = money / 1000

    println("You have purchased $ticketCount tickets. ")

    val lottoList = mutableListOf<Lotto>()

    for (ticket in 1..ticketCount) {
        val numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6)
        val lotto = Lotto(numbers)
        lottoList.add(lotto)
        println(lotto.toString())
    }

    println("Please enter last week's winning numbers.")
    val winningNumbersString = Console.readLine()
    val winningNumbers: List<Int> = winningNumbersString.split(",").map { it.toInt() }

    println("Please enter the bonus number.")
    val bonusNumber = Console.readLine().trim().toInt()

    println("Winning Statistics")
    println("---")

    getLottoResult(money, winningNumbers, bonusNumber, lottoList)

}

/**
 * 3 Matches (5,000 KRW) – 1 tickets
 * 4 Matches (50,000 KRW) – 0 tickets
 * 5 Matches (1,500,000 KRW) – 0 tickets
 * 5 Matches + Bonus Ball (30,000,000 KRW) – 0 tickets
 * 6 Matches (2,000,000,000 KRW) – 0 tickets
 */
fun getLottoResult(
    money: Int,
    winningNumbers: List<Int>,
    bonusNumber: Int,
    lottoList: List<Lotto>
) {

    var match3 = 0
    var match4 = 0
    var match5 = 0
    var match5Bonus = 0
    var match6 = 0

    lottoList.forEach { lotto ->
        val hit = lotto.getHitNumberResult(winningNumbers)
        val bonusHit = if (lotto.containsBonus(bonusNumber)) 1 else 0

        when {
            hit == 6 -> match6++
            hit == 5 && bonusHit == 1 -> match5Bonus++
            hit == 5 -> match5++
            hit == 4 -> match4++
            hit == 3 -> match3++
        }
    }

    val totalIncome =
        match3 * 5000 + match4 * 50000 + match5 * 1500000 + match5Bonus * 30000000 + match6 * 2000000000

    val rate = if (totalIncome != 0) {
        val r = totalIncome.toDouble() / money
        String.format("%.1f", r * 100).toDouble()
    } else {
        0.0
    }

    println("3 Matches (5,000 KRW) – $match3 tickets")
    println("4 Matches (50,000 KRW) – $match4 tickets")
    println("5 Matches (1,500,000 KRW) – $match5Bonus tickets")
    println("5 Matches + Bonus Ball (30,000,000 KRW) – $match5 tickets")
    println("6 Matches (2,000,000,000 KRW) – $match6 tickets")
    println("Total return rate is $rate%.")
}