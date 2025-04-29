package lotto

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms


// 입력 관련 함수. 값 입력받고 복권개수 리턴
fun readAmount(): Int {
    println("Please enter the purchase amount.")
    val input = Console.readLine()
    val amount = input.toIntOrNull()
    require(amount != null && amount >= 1000) {
        "[ERROR] Purchase mount must be equal or upper that 1000."
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

    Lotto(numbers)

    return numbers
}

// enter bonus number
fun readBonusNumber(): Int {
    println("Please enter the bonus number.")
    val input = Console.readLine()
    val number = input.toIntOrNull()

    // 보너스넘버 적절성 체크
    require(number != null && number in 1..45) {
        "[ERROR] Bonus number must be between 1 and 45."
    }
    return number
}



// 결과 비교 및 수익 계산 (enum 사용)
fun checkResults(
    tickets: List<Lotto>,
    winning: List<Int>,
    bonus: Int
): Map<Rank, Int> {
    val results = mutableMapOf<Rank, Int>()

    Rank.entries.forEach { results[it] = 0 }

    tickets.forEach { ticket ->
        val numbers = ticket.getNumbers()
        val matchCount = numbers.count { it in winning }
        val hasBonus = bonus in numbers

        val rank = Rank.of(matchCount, hasBonus)
        if (rank != Rank.NONE) {
            results[rank] = results[rank]!! + 1
        }
    }

    return results
}

// 등수 관리 enum
enum class Rank(
    val matchCount: Int,
    val matchBonus: Boolean,
    val prizeMoney: Int,
    val message: String
) {
    FIRST(6, false, 2_000_000_000, "6 Matches (2,000,000,000 KRW)"),
    SECOND(5, true, 30_000_000, "5 Matches + Bonus Ball (30,000,000 KRW)"),
    THIRD(5, false, 1_500_000, "5 Matches (1,500,000 KRW)"),
    FOURTH(4, false, 50_000, "4 Matches (50,000 KRW)"),
    FIFTH(3, false, 5_000, "3 Matches (5,000 KRW)"),
    NONE(0, false, 0, "");

    companion object {
        fun of(matchCount: Int, hasBonus: Boolean): Rank {
            return when {
                matchCount == 6 -> FIRST
                matchCount == 5 && hasBonus -> SECOND
                matchCount == 5 -> THIRD
                matchCount == 4 -> FOURTH
                matchCount == 3 -> FIFTH
                else -> NONE
            }
        }
    }
}

fun main() {
    // TODO: Implement the program

    val amount = readAmount()
    val ticketCount = amount / 1000
    println("You have purchased $ticketCount tickets.")

    val tickets = generateTickets(ticketCount)
    tickets.forEach { println(it.getNumbers().sorted()) }   // 생성된 티켓들 내용 출력

    val winningNumbers = readWinningNumbers()
    val bonusNumber = readBonusNumber()

    println("\nWinning Statistics")
    println("---")

    val result = checkResults(tickets, winningNumbers, bonusNumber)
    val totalPrize = result.entries.sumOf { it.key.prizeMoney * it.value }

    // 무조건 5등~1등 모두 출력 (0장이어도)
    listOf(Rank.FIFTH, Rank.FOURTH, Rank.THIRD, Rank.SECOND, Rank.FIRST)
        .forEach { rank ->
            val count = result[rank] ?: 0
            println("${rank.message} - $count tickets")
        }

    val rate = if (amount == 0) 0.0 else totalPrize.toDouble() / amount * 100
    println("Total return rate is ${"%.1f".format(rate)}%.")

}
