
package lotto

import camp.nextstep.edu.missionutils.Randoms

class LottoGenerator {

    fun generateOne(): Lotto {
        val nums = Randoms.pickUniqueNumbersInRange(1, 45, 6).sorted()
        return Lotto(nums)
    }


    fun generate(count: Int): List<Lotto> =
        List(count) { generateOne() }
}
