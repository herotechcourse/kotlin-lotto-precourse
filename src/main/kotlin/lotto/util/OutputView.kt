package lotto.util

import lotto.domain.PurchasedLotto

fun printPurchasedAmountInputPhrase() {
    println("Please enter the purchase amount.")
}

fun printUserPurchasedTicketPhrase(ticketCount: Int) {
    println("You have purchased 8 tickets.")
}

fun printAllPurchasedLottoNumbers(lottoNumbers: List<PurchasedLotto>) {
    lottoNumbers.forEach {
        println(it.lottoNumbers)
    }
}

fun printWinningNumbersInputPhrase() {
    println("Please enter last week's winning numbers.")
}

fun printBonusNumberInputPhrase() {
    println("Please enter the bonus number.")
}

fun printWinningStatisticsPhrase() {
    println("""
        Winning Statistics
        ---
    """.trimIndent())
}

fun printWinningStatics(rankStatics: Map<Rank, Int>, rateOfReturn: String) {
    val sb = StringBuilder()
    Rank.entries.forEach {
        sb.append(it.matchCount)
            .append(" Matched ")
            .append("(")
            .append(it.prize)
            .append(") - ")
            .append(rankStatics[it])
            .append(" tickets\n")
    }
    sb.append("Total return rate is ").append("${rateOfReturn}%")
    println(sb)
}