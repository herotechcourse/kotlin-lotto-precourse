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

    val winningNumbers = readWinningNumbers()
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

// enter last week's winning numbers
fun readWinningNumbers(): List<Int> {
    println("Please enter last week's winning numbers.")
    val input = Console.readLine()
    val numbers = input.split(",").mapNotNull { it.trim().toIntOrNull() }

    // 입력한 숫자가 6개인지, 중복 여부 체크
    require(numbers.size == 6 && numbers.toSet().size == 6) {
        "[ERROR] You must enter 6 unique numbers."
    }
    // 입력한 숫자가 1..45 사이에 있는지 체크
    require(numbers.all { it in 1..45 }) {
        "[ERROR] Lotto numbers must be between 1 and 45."
    }
    return numbers
}
