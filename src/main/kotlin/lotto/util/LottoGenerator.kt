package lotto.util

import camp.nextstep.edu.missionutils.Randoms
import lotto.config.LOTTO_COUNT
import lotto.config.MAX_LOTTO_NUMBER
import lotto.config.MIN_LOTTO_NUMBER

fun generateLottoNumbers(): List<Int> {
    return Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER, LOTTO_COUNT);
}

fun main() {
    val lottoNumbers = generateLottoNumbers()
    println("Generated Lotto Numbers: $lottoNumbers")
}