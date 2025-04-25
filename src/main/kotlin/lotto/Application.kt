package lotto

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

// prize ranks
enum class prizeTypes (val matchCount: Int, val hasBonus: Boolean, val rewards: Int) {
    NONE(0, false, 0),
    FIFTH(3, false, 5000),
    FOURTH(4, false, 50000),
    THIRD(5, false, 1500000),
    SECOND(5, true, 30000000),
    FIRST(6, false, 2000000000)

    // check prize rank
    companion object{
        fun match (matchCount: Int, hasBonus: Boolean): prizeTypes {
            if (matchCount == 5 && hasBonus) {return SECOND}
            return values().first{ it.matchCount == matchCount && !it.hasBonus }
            // PrizeRank.FIFTH(3, false, 5_000)
        }
    }

}

fun getTickets (): Pair<List<Lotto>, Int> {

    // ticket amounts
    println("Please enter the purchase amount.")
    val input = Console.readLine().toIntOrNull()
    if (input == null || (input % 1000) != 0 ){
        throw IllegalArgumentException("Each ticket costs 1,000 KRW. Please enter a valid amount.")
    }

    // purchased tickets
    val ticketAmounts = input / 1000
    println("You have purchased $ticketAmounts tickets.")

    val purchasedTickets = mutableListOf<Lotto>()

    repeat(ticketAmounts){
        val ticketNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6).sorted()
        println(ticketNumbers)
        purchasedTickets.add(Lotto(ticketNumbers))
    }

    return Pair(purchasedTickets, input) // pass to main

}

fun getWinningNumbers (): List<Int> {
    println("Please enter last week's winning numbers.")
    val inputWinningNumbers = Console.readLine().split(",").map{ it.trim().toIntOrNull() }
    if (inputWinningNumbers.any {it == null}) throw IllegalArgumentException("Please enter valid winning numbers.")
    val winningNumbers = inputWinningNumbers.filterNotNull() // verify each element and then convert the collection type
    require(winningNumbers.size == 6)  {"[ERROR] There must be 6 winning numbers."}
    require( winningNumbers.all{ it in 1..45}) {"[ERROR] Please enter the correct numbers between 1 to 45."}
    return winningNumbers
}

fun getBonusNumbers (winningNumbers: List<Int>): Int {
    println("Please enter a bonus number.")
    val inputBonus = Console.readLine().toIntOrNull()
    if (inputBonus == null || !(inputBonus in 1..45)) throw IllegalArgumentException("Please enter a valid number between 1 and 45.")
    if (winningNumbers.contains(inputBonus)) throw IllegalArgumentException("Please enter a separate bonus number.")

    return inputBonus
}

// matching result
fun match(purchasedtickets: List<Lotto>, winningNumbers: List<Int>, inputBonus: Int): Map<prizeTypes, Int> {

    val results = mutableMapOf<prizeTypes, Int>()
    // empty map
    // Int = how many tickets match the prize rank

    prizeTypes.values().forEach { it -> results[it] = 0 }
    // prizeTypes.values() returns an array: [FIRST, SECOND, THIRD, FOURTH, FIFTH, NONE]

    purchasedtickets.forEach {ticket ->
        val matchCount = ticket.matchedNumbersCount(winningNumbers)
        val hasBonus = ticket.includedBonusNumber(inputBonus)
        val rank = prizeTypes.match(matchCount, hasBonus)  // e.g. prizeTypes.FIFTH(3, false, 5_000)

        if (rank != prizeTypes.NONE) { results[rank] = (results[rank] ?: 0) + 1}
        // use Elvis operator
        // results[rank] = results.getOrDefault(rank, 0) + 1 set default entry as 0
    }

    return results

}

// calculate prize
fun finalResult(results: Map<prizeTypes, Int>): Int{
    var finalPrize = 0
    for ((key, value) in results) {
        val prize = key.rewards * value
        finalPrize += prize
    }
    return finalPrize
}

// printing results
fun print (results: Map<prizeTypes, Int>, finalPrize: Int, purchaseAmount: Int){
    println("Winning Statistics")
    println("---")
    print("3 Matches (5,000 KRW) - ${results[prizeTypes.FIFTH]} ticket")
    print("4 Matches (50,000 KRW) - ${results[prizeTypes.FOURTH]} ticket")
    print("5 Matches (1,500,000 KRW) - ${results[prizeTypes.THIRD]} ticket")
    print("5 Matches + Bonus Ball (30,000,000 KRW) - ${results[prizeTypes.SECOND]} ticket")
    print("6 Matches (2,000,000,000 KRW) - ${results[prizeTypes.FIRST]} ticket")
    val returnRate = (finalPrize.toDouble() / purchaseAmount) * 100
    println("Total return rate is $returnRate %.")
}

fun main() {

    val (purchasedTickets, purchaseAmount) = getTickets()
    val winningNumbers = getWinningNumbers()
    val inputBonus = getBonusNumbers(winningNumbers)
    val results = match(purchasedTickets, winningNumbers, inputBonus)
    val finalPrize = finalResult(results)
    print(results, finalPrize, purchaseAmount)

}
