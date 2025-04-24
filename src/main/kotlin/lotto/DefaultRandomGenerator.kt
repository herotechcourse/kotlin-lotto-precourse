package lotto

import camp.nextstep.edu.missionutils.Randoms

class DefaultRandomGenerator : RandomGenerator {

    override fun nextSortedUniqueNumbers() =
        Randoms.pickUniqueNumbersInRange(START_NUMBER, END_NUMBER, COUNT)
            .sorted()

    companion object {
        private const val START_NUMBER = 1
        private const val END_NUMBER = 45
        private const val COUNT = 6
    }
}