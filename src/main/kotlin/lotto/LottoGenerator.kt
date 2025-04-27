package lotto
import camp.nextstep.edu.missionutils.Randoms

class LottoGenerator() {
    fun generate(): Lotto {
        val numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6)
        return Lotto(numbers)
    }
}