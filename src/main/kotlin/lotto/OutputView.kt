package lotto

import camp.nextstep.edu.missionutils.Randoms
import java.text.DecimalFormat


class OutputView {
    fun generateTickets(purchase: String): ArrayList<List<Int>> {
        println()
        println(SHOW_TICKETS)
        val ticketCnt = purchase.toInt() / 1000
        val ticketList = ArrayList<List<Int>>()
        for (i in 0 until ticketCnt) {
            ticketList.add(i, makeRandomTicket())
        }
        return ticketList
    }

    fun makeRandomTicket(): List<Int> {
        val pickSixNumber = Randoms.pickUniqueNumbersInRange(1, 45, 6)
        val sortedSixNumber = pickSixNumber.sorted()
        showEachTickets(sortedSixNumber)
        return sortedSixNumber.toList()
    }

    fun showEachTickets(pickSixNumber: List<Int>) {
        println(pickSixNumber)
    }

    fun showWinningStat() {
        println()
        println(SHOW_WINNING)
        println("---")
        Prize.getResultMatch()
    }

    fun showProfitRate(profitRate: Double) {
        println(SHOW_TOTAL + changeDecimalFormat(profitRate) + "%.")
    }

    fun changeDecimalFormat(profitRate: Double): String {
        val roundTotenth = kotlin.math.round(profitRate * 100) / 100 //nearest tenth
        val decimal = DecimalFormat("#,##0.0")
        return decimal.format(roundTotenth)
    }


    companion object {
        const val SHOW_TICKETS = "You have purchased 8 tickets."
        const val SHOW_WINNING = "Winning Statistics"
        const val SHOW_TOTAL = "Total return rate is "
    }
}