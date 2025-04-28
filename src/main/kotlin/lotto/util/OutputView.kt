package lotto.util

import lotto.domain.PurchasedLotto

fun printPurchasedAmountInputPhrase() {
    println("Please enter the purchase amount.")
}

fun printUserPurchasedTicketPhrase(ticketCount: Int) {
    println("You have purchased $ticketCount tickets.")
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
        val formattedPrize = String.format("%,d", it.prize)
        sb.append("""
            ${it.matchCount} Matched ($formattedPrize KRW) - ${rankStatics[it]} tickets
        """.trimIndent()).append("\n")
    }
    sb.append("Total return rate is ").append("${rateOfReturn}%")
    println(sb)
}