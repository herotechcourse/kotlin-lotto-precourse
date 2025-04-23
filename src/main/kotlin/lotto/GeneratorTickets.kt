package lotto

import camp.nextstep.edu.missionutils.Randoms

object GeneratorTickets {
    fun generate(): Lotto {
        val numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6)
        return Lotto(numbers)
    }
}