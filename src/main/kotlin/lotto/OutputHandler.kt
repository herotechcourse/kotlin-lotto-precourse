class OutputHandler {
    fun printPurchasedLottos(lottos: List<Lotto>) {
        val lottoCount = lottos.size
        println("\nYou have purchased $lottoCount tickets.")
        lottos.forEach { println(it) }
        println()
    }
}