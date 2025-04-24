package lotto
import lotto.views.InputView
import camp.nextstep.edu.missionutils.Randoms

enum class LottoResults(val prize: Int, val message: String) {
    FIRST_PRIZE(prize = 2000000000, message = "6 Matches (2,000,000,000 KRW)"),
    SECOND_PRIZE(prize = 30000000, message = "5 Matches + Bonus Ball (30,000,000 KRW)"),
    THIRD_PRIZE(prize = 1500000, message = "5 Matches (1,500,000 KRW)"),
    FOURTH_PRIZE(prize = 50000, message = "4 Matches (50,000 KRW)"),
    FIFTH_PRIZE(prize = 5000, message = "3 Matches (5,000 KRW)")
}

fun generateLottoTickets(): List<List<Int>> {
    val inputView = InputView()
    val numberOfTickets = inputView.inputTickets() / 1000
    val tickets = mutableListOf<List<Int>>()

    repeat(numberOfTickets) {
        val ticket = Randoms.pickUniqueNumbersInRange(1, 45, 6).sorted()
        tickets.add(ticket)
    }

    return tickets
}

fun checkWinningTickets(tickets: List<List<Int>>, winningNumbers: List<Int>, luckyNumber: Int): List<LottoResults> {
    return tickets.mapNotNull { ticket ->
        val matchCount = ticket.count { it in winningNumbers }
        val hasLuckyNumber = luckyNumber in ticket

        when {
            matchCount == 6 -> LottoResults.FIRST_PRIZE
            matchCount == 5 && hasLuckyNumber -> LottoResults.SECOND_PRIZE
            matchCount == 5 -> LottoResults.THIRD_PRIZE
            matchCount == 4 -> LottoResults.FOURTH_PRIZE
            matchCount == 3 -> LottoResults.FIFTH_PRIZE
            else -> null // No prize
        }
    }
}

//fun claculateResults(results: List<LottoResults>) {
//    val resultCounts = LottoResults.entries.associateWith { result ->
//        results.count { it == result }
//    }
//    var totalPrize = 0
//    resultCounts.forEach { (result, count) ->
//        println("${result.message} – $count tickets")
//        totalPrize += result.prize * count
//    }
//    println("Total Prize: ${totalPrize} KRW")
//}


fun calculateResultCounts(results: List<LottoResults>): Map<LottoResults, Int> {
    return LottoResults.entries.associateWith { result ->
        results.count { it == result }
    }
}

fun displayTotalPrize(resultCounts: Map<LottoResults, Int>, numberOfTickets: Int, ticketPrice: Int = 1000) {
    var totalPrize = 0
    resultCounts.forEach { (result, count) ->
        totalPrize += result.prize * count
    }

    val totalSpent = numberOfTickets * ticketPrice
    val percentage = (totalPrize.toDouble() / totalSpent) * 100

    println("Total Prize: ${totalPrize} KRW")
    println("Earnings Percentage: ${"%.2f".format(percentage)}%")
}
//
//fun displayTotalPrize(resultCounts: Map<LottoResults, Int>, numberOfTickets: Int, ticketPrice: Int = 1000) {
//    var totalPrize = 0
//    resultCounts.forEach { (result, count) ->
//        totalPrize += result.prize * count
//    }
//
//    val totalSpent = numberOfTickets * ticketPrice
//    val percentage = (totalPrize.toDouble() / totalSpent) * 100
//
//    println("Total Prize: ${totalPrize} KRW")
//    println("Earnings Percentage: ${"%.2f".format(percentage)}%")
//}

fun displayResults(resultCounts: Map<LottoResults, Int>) {
    resultCounts.forEach { (result, count) ->
        println("${result.message} – $count tickets")
    }
}