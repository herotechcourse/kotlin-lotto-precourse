package lotto.util

import camp.nextstep.edu.missionutils.Randoms

object RandomNumberGenerator {

    private const val START_NUMBER = 1
    private const val END_NUMBER = 45
    private const val COUNT = 6

    fun generateRandomNumbers(): List<Int> {
        return Randoms.pickUniqueNumbersInRange(START_NUMBER, END_NUMBER, COUNT)
    }
}