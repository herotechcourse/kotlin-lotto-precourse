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