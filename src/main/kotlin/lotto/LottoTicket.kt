package lotto

import camp.nextstep.edu.missionutils.Randoms

class LottoTicket private constructor(val numbers: List<Int>) {

    companion object {
        fun generate(): LottoTicket {
            val numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6).sorted()
            return LottoTicket(numbers)
        }
    }
}
