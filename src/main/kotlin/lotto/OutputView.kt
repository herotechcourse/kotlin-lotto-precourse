package lotto

object OutputView {
    fun printIssuedLottos(lottos: List<Lotto>) {
        println("\nYou have purchased ${lottos.size} tickets.")
        lottos.forEach { println(it.getNumbers()) }
    }
}