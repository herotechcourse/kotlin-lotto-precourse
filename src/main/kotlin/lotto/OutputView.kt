package lotto

// Output view for displaying the results
class OutputView {
    fun printResult(statistics: Map<Prize, Int>, returnRate: Double) {
        statistics.forEach { (prize, count) ->
            println("${prize.name}: $count tickets")
        }
        println("Return rate: ${"%.2f".format(returnRate)}%")
    }
}
