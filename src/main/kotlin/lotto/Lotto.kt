package lotto

class Lotto(private val numbers: List<Int>) {

    val inputView = InputView()
    val outputView = OutputView()


    init {
        require(numbers.size == 6) { "[ERROR] Lotto must contain exactly 6 numbers." }
    }

    // TODO: Implement additional functions
    fun run(ticketList: ArrayList<List<Int>>, purchase: String) {
        println()
        val bonusNum = inputView.bonusNumber()
        compareWinningNum(ticketList, bonusNum)
        outputView.showWinningStat()
        outputView.showProfitRate(profitRate(purchase, sumOfMoney()))
    }

    fun compareWinningNum(arrList: ArrayList<List<Int>>, bonus: Int) {
        for (i in 0 until arrList.size) {
            val compare = eachCompare(arrList[i])
            if (compare == 5 && matchBonus(arrList[i], bonus)) {
                makeWinnerMap("bonus")
            } else {
                makeWinnerMap(compare.toString())
            }
        }
    }

    fun eachCompare(list: List<Int>): Int {
        val union = list + numbers
        val interSection = union.groupBy { it }.filter { it.value.size > 1 }.flatMap { it.value }.distinct()
        if (interSection.isEmpty()) return 0
        else {
            return interSection.size //return size ex) "6" "5" or
        }
    }

    fun matchBonus(arrList: List<Int>, bonus: Int): Boolean {
        return arrList.contains(bonus)
    }

    fun makeWinnerMap(winner: String) {
        Prize.entries.forEach {
            if (it.matchType == winner) it.cnt += 1
        }
    }

    fun sumOfMoney(): Int {
        var total = 0
        Prize.entries.forEach {
            total += it.cnt * Prize.getMoney(it.matchType)
        }
        return total
    }

    fun profitRate(purchase: String, sumMoney: Int): Double {
        val rate = (sumMoney / purchase.toDouble()) * 100
        return rate
    }
}
