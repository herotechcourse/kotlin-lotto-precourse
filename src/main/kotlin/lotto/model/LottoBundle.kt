package lotto.model

import lotto.Lotto
import lotto.model.generator.LottoNumberGenerator

class LottoBundle internal constructor(
    private val lottos: List<Lotto>,
    private val generator: LottoNumberGenerator
) {
    companion object {
        fun from(purchaseAmount: LottoPurchaseAmount, generator: LottoNumberGenerator): LottoBundle {
            val lottos = List(purchaseAmount.toCount()) {
                Lotto(generator.generate().sorted())
            }
            return LottoBundle(lottos, generator)
        }
    }
}