package lotto.model 
import camp.nextstep.edu.missionutils.Randoms

enum class LottoPrize(val match: Int, val isBonus: Boolean, val prize: Int) {
    FIRST(6, false, 2000000000),
    SECOND(5, true, 30000000),
    THIRD(5, false, 1500000),
    FOURTH(4, false, 50000),
    FIFTH(3, false, 5000);

    companion object {
        fun from(match: Int, isBonus: Boolean): LottoPrize? {
            return values().find { prize -> (prize.match == match && prize.isBonus == isBonus) }
        }
    }
}

class LottoGame() {
    fun purchase(amount: Int): List<Lotto> {
        val count = amount / 1000
        return List(count) {
            val numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6)
            Lotto(numbers)
        }
    }

    fun getResult(lottos: List<Lotto>, winningLotto: Lotto, bonusNumber: Int): List<Int> {
        val result = List(LottoPrize.values().size) { 0 }

        for(lotto in lottos) {
            val match = lotto.match(winningLotto)    
            val isBonus = false

            if(match == 5) {
                isBonus = lotto.isBonusContain(bonusNumber)
            }

            val prize = LottoPrize.from(match, isBonus)
            if(prize != null) {
                result[prize.ordinal] += 1
            }
        }

        return result
    }
}
