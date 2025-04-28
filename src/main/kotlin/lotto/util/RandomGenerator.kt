package lotto.util

import camp.nextstep.edu.missionutils.Randoms

// Utility object for generating random lottery numbers
object RandomGenerator {

    // Generates a sorted list of 6 unique random numbers between 1 and 45
    fun generateLottoNumbers(): List<Int> {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6).sorted()
    }
}