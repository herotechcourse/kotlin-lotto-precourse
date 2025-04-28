package lotto

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun main() {
    // TODO: Implement the program

    val amount = readAmount()
    val ticketCount = amount / 1000
    println("You have purchased $ticketCount tickets.")

    val tickets = generateTickets(ticketCount)
    tickets.forEach { println(it.getNumbers().sorted()) }   // 생성된 티켓들 내용 출력

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

// 티켓 생성. 복권 수 만큼 복권 생성
fun generateTickets(count: Int): List<Lotto> {
    return List(count) {
        val numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6)
        Lotto(numbers)
    }
}
