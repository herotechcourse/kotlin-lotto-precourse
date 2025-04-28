package lotto.util

import lotto.domain.PurchasedLotto

fun printPurchasedAmountInputPhrase() {
    println("Please enter the purchase amount.")
}

fun printUserPurchasedTicketPhrase(ticketCount: Int) {
    println()
    println("You have purchased $ticketCount tickets.")
}

fun printAllPurchasedLottoNumbers(lottoNumbers: List<PurchasedLotto>) {
    lottoNumbers.forEach {
        println(it.lottoNumbers)
    }
}

fun printWinningNumbersInputPhrase() {
    println()
    println("Please enter last week's winning numbers.")
}

fun printBonusNumberInputPhrase() {
    println()
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
    Rank.entries
        .filter { it != Rank.NONE}
        .forEach {
        val descriptionOfRank = rankDescription(it)
        val formattedPrize = formatPrize(it.prize)
        sb.append("$descriptionOfRank ($formattedPrize KRW) - ${rankStatics[it]} tickets \n")
    }
    sb.append("Total return rate is ").append("${rateOfReturn}%")
    println(sb)
}

fun rankDescription(rank: Rank): String? {
    return when (rank) {
        Rank.SECOND -> "5 Matches + Bonus Ball"
        Rank.NONE -> null
        else -> "${rank.matchCount} Matches "
    }
}

fun formatPrize(prize: Int): String {
    return String.format("%,d", prize)
}