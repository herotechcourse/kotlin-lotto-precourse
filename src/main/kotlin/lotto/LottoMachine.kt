import lotto.Lotto

import camp.nextstep.edu.missionutils.Randoms

class LottoMachine {
    fun generateLottoNumbers(): List<Int> {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6)
    }

    fun generateLottos(count: Int): List<Lotto> {
        return List(count) { Lotto(generateLottoNumbers()) }
    }
}