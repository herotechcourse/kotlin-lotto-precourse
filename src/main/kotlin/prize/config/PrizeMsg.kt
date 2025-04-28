package prize.config

internal const val PRIZE_INTRO = "Winning Statistics\n---"


fun beginPrizeStat() {
    println(PRIZE_INTRO)
}

fun printReturnRate(percentage: Double){
    println("Total return rate is ${percentage}%.")
}