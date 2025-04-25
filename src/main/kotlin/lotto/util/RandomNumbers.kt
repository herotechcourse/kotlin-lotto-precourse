package lotto.util

import camp.nextstep.edu.missionutils.Randoms

object RandomNumbers {
    fun generate(start: Int, end: Int, numbers: Int): List<Int> = Randoms.pickUniqueNumbersInRange(start, end, numbers)
}