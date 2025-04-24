package lotto

import camp.nextstep.edu.missionutils.Console

fun main() {
    println("Please enter the purchase amount.")
    val money = Console.readLine().toIntOrNull()

    // 가격에 맞게 티켓 구매

    println("Please enter last week's winning numbers.")
    val numbs = Console.readLine()

    println("Please enter the bonus number.")
    val bonus = Console.readLine().toIntOrNull()
}
