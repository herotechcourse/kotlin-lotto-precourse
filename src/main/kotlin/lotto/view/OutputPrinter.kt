package lotto

interface OutputPrinter {
    fun printPurchasedTickets(lottos: Lottos): Unit
    fun printLottoResult(lottos: Lottos): Unit
    fun printProfitRate(profitRate: Any): Unit
}
