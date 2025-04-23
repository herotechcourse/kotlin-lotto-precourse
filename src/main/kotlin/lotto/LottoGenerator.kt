package lotto

import camp.nextstep.edu.missionutils.Randoms


class LottoGenerator {

    fun generateLotto(): Lotto {
        val randomNumbers = Randoms.pickUniqueNumbersInRange(LOTTO_NUMBER_MIN, LOTTO_NUMBER_MAX, LOTTO_NUMBER_COUNT)
        return Lotto(randomNumbers)
    }
}