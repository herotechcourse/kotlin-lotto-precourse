package lotto

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms
import lotto.Util.ENTER_PURCHASE_AMOUNT
import lotto.Util.PURCHASE_AMOUNT

fun main() {

    println(ENTER_PURCHASE_AMOUNT)
    val money = Console.readLine().trim().toInt()
    val ticketCount = money / 1000

    println("You have purchased $ticketCount tickets. ")

    val lottoNumberList = mutableListOf<List<Int>>()

    for (ticket in 1..ticketCount) {
        val numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6)
        lottoNumberList.add(numbers)
        println(numbers)
    }

//    println(lottoNumberList)

    println("Please enter last week's winning numbers.")


    val winningNumbersString = Console.readLine()
    val winningNumbers: List<Int> = winningNumbersString.split(",").map { it.toInt() }

    println("Please enter the bonus number.")
    val bonusNumber = Console.readLine().trim().toInt()
//    println("$winningNumbers $bonusNumber") // [1, 2, 3, 4, 5, 6]


    println("Winning Statistics")
    println("---")

    getLottoResult(money, winningNumbers, bonusNumber, lottoNumberList)

}

/**
 * 3 Matches (5,000 KRW) – 1 tickets
 * 4 Matches (50,000 KRW) – 0 tickets
 * 5 Matches (1,500,000 KRW) – 0 tickets
 * 5 Matches + Bonus Ball (30,000,000 KRW) – 0 tickets
 * 6 Matches (2,000,000,000 KRW) – 0 tickets
 */
fun getLottoResult(money: Int, winningNumbers: List<Int>, bonusNumber: Int, lottoNumberList: List<List<Int>>) {

    var hit = 0
    var bonusHit = 0

    var match3 = 0
    var match4 = 0
    var match5 = 0
    var match5_bonus = 0
    var match6 = 0


    lottoNumberList.forEach { numberList ->
        numberList.forEach { number ->
            if (number in winningNumbers) {
                hit += 1
            }
            if (number == bonusNumber) {
                bonusHit += 1
            }
        }
//         println("$numberList 의  $hit")

        if (hit == 6) {
            match6 += 1
        } else if (hit == 5 && bonusHit == 1) {
            match5_bonus += 1
        } else if (hit == 5) {
            match5 += 1
        } else if (hit == 4) {
            match4 += 1
        } else if (hit == 3) {
            match3 += 1
        }

        hit = 0
        bonusHit = 0
    }


    val totalIncome = match3*5000 + match4*50000 + match5*1500000 + match5_bonus*30000000 + match6*2000000000
    println(totalIncome)

    var rate = if (totalIncome != 0) {
        val r = totalIncome.toDouble() / money
        String.format("%.1f", r * 100).toDouble()
    } else {
        0.0
    }

    println(rate)

    println("3 Matches (5,000 KRW) – $match3 tickets")
    println("4 Matches (50,000 KRW) – $match4 tickets")
    println("5 Matches (1,500,000 KRW) – $match5_bonus tickets")
    println("5 Matches + Bonus Ball (30,000,000 KRW) – $match5 tickets")
    println("6 Matches (2,000,000,000 KRW) – $match6 tickets")
    println("Total return rate is $rate%.")

}