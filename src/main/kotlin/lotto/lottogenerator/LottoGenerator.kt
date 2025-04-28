package lotto.lottogenerator

import lotto.Lotto

fun interface LottoGenerator {

    fun generate(): Lotto
}
