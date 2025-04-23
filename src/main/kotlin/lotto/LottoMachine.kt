package lotto

import camp.nextstep.edu.missionutils.Randoms

interface LottoMachine {
    fun issue(): Lotto
}

object RandomLottoMachine : LottoMachine {

    private const val MIN = 1
    private const val MAX = 45
    private const val LOTTO_SIZE = 6

    override fun issue(): Lotto {
        val numbers: List<Int> = Randoms.pickUniqueNumbersInRange(MIN, MAX, LOTTO_SIZE)

        return Lotto(numbers)
    }
}
