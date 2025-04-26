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
        const val MIN_INCLUSIVE: Int = 1
        const val MAX_INCLUSIVE: Int = 45
        const val SIZE: Int = 6
    }
}
