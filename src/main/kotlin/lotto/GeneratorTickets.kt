package lotto

import camp.nextstep.edu.missionutils.Randoms

object GeneratorTickets {
    fun generate(): Lotto {
        val numbers =
            Randoms.pickUniqueNumbersInRange(Constants.MIN_NUMBER, Constants.MAX_NUMBER, Constants.LOTTO_NUMBER_COUNT)
        return Lotto(numbers)
    }
}