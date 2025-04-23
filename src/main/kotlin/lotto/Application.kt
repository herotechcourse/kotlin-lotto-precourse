package lotto

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

// prize ranks
enum class prizeTypes {
    fifth, fourth, third, second, first
}

fun main() {

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
    }

}
