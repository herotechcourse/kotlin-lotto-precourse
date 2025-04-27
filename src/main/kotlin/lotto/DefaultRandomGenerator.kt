package lotto

import camp.nextstep.edu.missionutils.Randoms
import lotto.Consts.END_NUMBER
import lotto.Consts.LOTTO_NUMBER_SIZE
import lotto.Consts.START_NUMBER

class DefaultRandomGenerator : RandomGenerator {

    override fun nextSortedUniqueNumbers() =
        Randoms.pickUniqueNumbersInRange(START_NUMBER, END_NUMBER, LOTTO_NUMBER_SIZE)
            .sorted()
}