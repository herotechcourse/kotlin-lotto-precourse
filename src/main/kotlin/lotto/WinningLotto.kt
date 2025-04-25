package lotto

import camp.nextstep.edu.missionutils.Randoms

class WinningLotto(val winner: List<Int>, val bonusNum: Int) {
    init {
        require(winner.size == 6) { "[ERROR] Lotto must contain exactly 6 numbers." }
        require(bonusNum > 0 && bonusNum <= 45)
    }

    fun compareTicket(ticket: Lotto): Int {
        //return how many numbers they have in common
    }
}