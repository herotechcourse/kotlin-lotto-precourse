package lotto

import camp.nextstep.edu.missionutils.Randoms

class RandomLottoGenerator : LottoGenerator {

    override fun generate(): Lotto {
        return Lotto(
            Randoms.pickUniqueNumbersInRange(MIN_INCLUSIVE, MAX_INCLUSIVE, SIZE)
                .sorted()
                .map { (LottoNumber(it)) })
    }

    companion object {
        private const val MIN_INCLUSIVE: Int = 1
        private const val MAX_INCLUSIVE: Int = 45
        private const val SIZE: Int = 6
    }
}
