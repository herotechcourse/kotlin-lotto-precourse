package lotto.lottogenerator

import lotto.Lotto
import lotto.LottoNumber

class ManualLottoGenerator(val numbers: MutableList<List<Int>>) : LottoGenerator {

    override fun generate(): Lotto {
        return Lotto(
            numbers.removeFirst()
                .sorted()
                .map { (LottoNumber(it)) })
    }
}
