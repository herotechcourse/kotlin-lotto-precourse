package lotto

class OutputView {
    fun printResult (lottos: List<Lotto>) {
        println()
        println("You have purchased ${lottos.size} tickets.")

        lottos.forEach { lotto ->
            println(lotto.getNumbers().sorted())
        }
        println()
    }

    fun printStatics (result: Array<Int>, total: Double) {
        println()
        println("Winning Statistics")
        println("---")
        println("3 Matches (5,000 KRW) – ${result[0]} tickets")
        println("4 Matches (50,000 KRW) – ${result[1]} tickets")
        println("5 Matches (1,500,000 KRW) – ${result[2]} tickets")
        println("5 Matches + Bonus Ball (30,000,000 KRW) – ${result[3]} tickets")
        println("6 Matches (2,000,000,000 KRW) – ${result[4]} tickets")
        val formatted = String.format("%.1f", total)
        println("Total return rate is ${formatted}%.")
    }
}