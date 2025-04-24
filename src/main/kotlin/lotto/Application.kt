package lotto

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

// prize ranks
enum class prizeTypes {
    fifth, fourth, third, second, first
}

// lotto result
object LottoResult {
    fun match(types: prizeTypes): Lotto{
        println("Winning Statistics")
        println("---")

    }
}

fun getTickets (){

    // ticket amounts
    println("Please enter the purchase amount.")
    val input = Console.readLine().toIntOrNull()
    if (input == null || (input % 1000) != 0 ){
        throw IllegalArgumentException("Each ticket costs 1,000 KRW. Please enter a valid amount.")
    }

    // purchased tickets
    val tickets = input / 1000
    println("You have purchased $tickets tickets.")
    repeat(tickets){
        val ticketNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6).sorted()
        println(ticketNumbers)
        Lotto(ticketNumbers)  // send back ticket numbers
    }

}

fun checkWinningNumbers () {
    println("Please enter last week's winning numbers.")
    val inputNumbers = Console.readLine().split(",")

}

fun checkBonusNumbers () {
    println("Please enter a bonus number.")
    val inputBonus = Console.readLine().toIntOrNull()
}


fun main() {

    val purchasedTickets = getTickets()
    val lottoResult: Lotto = LottoResult.match()
    val profitRate = (award / input) * 100
    println("Total return rate is $profitRate%. fun")

}
