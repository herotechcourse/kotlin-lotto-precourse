package lotto


class WinningStatistics(val tickets: List<Lotto>, val winningNumbers: WinningNumbers) {

    val mapPrizeNumber = Lotto.Prize.entries.associateWith { 0 }.toMutableMap()

    fun getMapPrize() {

        for (ticket in tickets) {
            val prize = ticket.checkPrize(winningNumbers)
            mapPrizeNumber[prize] = (mapPrizeNumber[prize] ?: 0) + 1
            // println("${ticket.getTicket()}: ${prize.namePrize}")
        }
        //return mapPrizeNumber
    }

    fun getMoneyEach(): Map<String, Int> {
        val moneyPrizeALl = mutableMapOf<String, Int>()
        for ((prize, number) in mapPrizeNumber) {
            if (prize != Lotto.Prize.NOPRIZE) {
                moneyPrizeALl[prize.namePrize] = number
            }
        }
        return  moneyPrizeALl
    }

    fun getTotalMoney(): Int {
        var totalMoney = 0
        for ((prize, number) in mapPrizeNumber) {
            totalMoney += prize.valuePrize * number
        }
        return totalMoney
    }
}

