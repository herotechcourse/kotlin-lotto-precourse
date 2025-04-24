package lotto

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

// prize ranks
enum class prizeTypes {
    fifth, fourth, third, second, first
}

// lotto result
object LottoResult {

    fun printResults (types: prizeTypes): Lotto {
        println("Winning Statistics")
        println("---")
    }
}

fun getTickets (): List<Lotto> {

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

fun checkWinningNumbers (): List<Int> {
    println("Please enter last week's winning numbers.")
    val inputWinningNumbers = Console.readLine().split(",").map{ it.trim().toIntOrNull() }
    if (inputWinningNumbers == null || inputWinningNumbers.size !== 6) throw IllegalArgumentException("Please enter 6 valid winning numbers.")
    require( inputWinningNumbers.all{ it in 1..45}) {"[ERROR] Please enter the correct numbers between 1 to 45."}
    return inputWinningNumbers
}

fun checkBonusNumbers (inputNumbers: List<Int>): Int {
    println("Please enter a bonus number.")
    val inputBonus = Console.readLine().toIntOrNull()
    if (inputBonus == null || !(inputBonus in 1..45)) throw IllegalArgumentException("Please enter a valid number between 1 and 45.")
    if (inputNumbers.contains(inputBonus)) throw IllegalArgumentException("Please enter a separate bonus number.")

    return inputBonus
}

fun match(purchasedtickets, inputNumbers: List<Int>, inputBonus: Int){

    purchasedtickets.forEach {ticket ->


    }


}


fun main() {

    val (purchasedTickets, purchaseAmount) = getTickets()
    val lottoResult =
    val profitRate = (award / input) * 100
    println("Total return rate is $profitRate%. fun")

}
