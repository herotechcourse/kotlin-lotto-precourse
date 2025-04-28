package lotto

class LottoResult () {
    enum class Prize (val price: Int) {
        FIFTH (5000),
        FOURTH (50000),
        THIRD (1500000),
        SECOND (30000000),
        FIRST (2000000000)
    }
    fun calculateStatics(winningNum: List<Int>, bonusNum: Int, tickets: List<Lotto>) : Array<Int> {
        val result = Array(5) {0}
        for (ticket in tickets) {
            val numMatch = winningNum.count { it in ticket.getNumbers() }
            val bonusMatch = bonusNum in ticket.getNumbers()
            if (numMatch == 6) result[4]++
            if (numMatch == 5 && bonusMatch) result[3]++
            if (numMatch == 5 && !bonusMatch) result[2]++
            if (numMatch == 4) result[1]++
            if (numMatch == 3) result[0]++
        }
        return result
    }

    fun calculateTotal(result: Array<Int>, amount: Int) : Double {
        val prizes = Prize.values()
        val total = result.indices.sumOf { i ->
            prizes[i].price * result[i]
        }
        val percentage = total.toDouble() * 100 / amount
        val res = String.format("%.1f", percentage)
        return res.toDouble()
    }
}