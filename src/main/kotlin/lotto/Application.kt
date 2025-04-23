package lotto

import camp.nextstep.edu.missionutils.Console

fun main() {

    // purchase ticket
    println("Please enter the purchase amount.")
    val input = Console.readLine().toIntOrNull()
    if (input == null || (input % 1000) !== 0 ){
        throw IllegalArgumentException("Each ticket costs 1,000 KRW. Please enter a valid amount.")
    }

    val ticketNumbers = input / 1000
    println("You have purchased $ticketNumbers tickets.")

}
