package lotto

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms


fun main() {
    // TODO: Implement the program

    val amount = readAmount()
    val ticketCount = amount / 1000
    println("You have purchased $ticketCount tickets.")



}

// 입력 관련 함수. 값 입력받고 복권개수 리턴
fun readAmount(): Int {
    println("Please enter the purchase amount.")
    val input = Console.readLine()
    val amount = input.toIntOrNull()
    require(amount != null && amount % 1000 == 0) {
        "[ERROR] Amount must be a multiple of 1000."
    }
    return amount
}
