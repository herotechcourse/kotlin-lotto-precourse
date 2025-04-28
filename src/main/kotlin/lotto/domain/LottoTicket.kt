package lotto.domain

import camp.nextstep.edu.missionutils.Randoms

class LottoTicket(inputNumbers: List<Int>) {
    val numbers: List<Int> = inputNumbers.sorted()

    init {
        require(inputNumbers.size == 6) { "[ERROR] Lotto must contain exactly 6 numbers." }
    }

    companion object {
        fun createRandom(): LottoTicket {
            val nums = Randoms.pickUniqueNumbersInRange(1, 45, 6)
            return LottoTicket(nums)
        }
    }
}
