package lotto

import camp.nextstep.edu.missionutils.Randoms
import lotto.constant.LottoConstants
import lotto.validation.LottoValidator

class LottoMachine(money: Int) {
    private val lottos: List<Lotto>

    init {
        LottoValidator.validateAmountIsMultipleOfPrice(money)
        val numberOfLottos = calculateNumberOfLottos(money)
        lottos = generateLottos(numberOfLottos)
    }

    /** Calculates the number of lottos that can be bought with the given money. */
    private fun calculateNumberOfLottos(money: Int): Int {
        return money / LottoConstants.LOTTO_PRICE
    }

    /** Generates the specified number of Lotto tickets. */
    private fun generateLottos(count: Int): List<Lotto> {
        return List(count) { generateSingleLotto() }
    }

    /** Generates a single Lotto ticket with unique random numbers. */
    private fun generateSingleLotto(): Lotto {
        val numbers = Randoms.pickUniqueNumbersInRange(
            LottoConstants.MIN_LOTTO_NUMBER,
            LottoConstants.MAX_LOTTO_NUMBER,
            LottoConstants.LOTTO_NUMBER_COUNT
        )
        return Lotto(numbers)
    }

    /** Returns the list of generated Lotto tickets. */
    fun getLottos(): List<Lotto> {
        return lottos
    }

    /** Returns the total number of lottos generated. */
    fun getNumberOfLottos(): Int {
        return lottos.size
    }
} 