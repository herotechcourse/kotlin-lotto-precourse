package lotto

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun main() {
    val purchaseAmount = readPurchaseAmount()
    val ticketCount = purchaseAmount / 1_000
    println("${ticketCount}개를 구매했습니다.")

    val tickets = generateTickets(ticketCount)
    tickets.forEach { println(it) }
}

fun readPurchaseAmount(): Int {
    println("구매 금액을 입력해 주세요.")
    val input = Console.readLine().orEmpty().trim()
    val amount = input.toIntOrNull()
        ?: throw IllegalArgumentException("[ERROR] 숫자 형식이 올바르지 않습니다.")
    require(amount >= 1_000 && amount % 1_000 == 0) {
        "[ERROR] 구매 금액은 1,000원 단위여야 합니다."
    }
    return amount
}

fun generateTickets(count: Int): List<List<Int>> =
    List(count) {
        Randoms.pickUniqueNumbersInRange(1, 45, 6).sorted()
    }
