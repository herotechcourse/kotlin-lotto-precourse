package lotto

import camp.nextstep.edu.missionutils.Randoms

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6) { "[ERROR] Lotto must contain exactly 6 numbers." }
        require(numbers.distinct().size == 6) { "[ERROR] Lotto numbers must be unique." }
        require(numbers.all { it in 1..45 }) { "[ERROR] Lotto numbers must be between 1 and 45." }
    }

    fun getNumbers():List<Int>{
        return numbers.sorted()
    }

companion object {
    fun createLottoList(count: Int): List<Lotto> {
        //val randomLotto: List<Int> = listOf()
        val randomLotto = mutableListOf<Lotto>()
        for (i in 1..count) {
            val RandomlottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6)
            val RandomlottoNumberssort = RandomlottoNumbers.sorted()
            randomLotto.add(Lotto(RandomlottoNumberssort))
        }
        return randomLotto
    }
}

    fun correctNumbers(lottolist: List<Int>, lottocorrectlist: List<Int>, bonusnumber: Int): Int {
        val matchCount = lottolist.count { it in lottocorrectlist }
        val hasBonus = lottolist.contains(bonusnumber)

        if (matchCount == 6) {
            return 7
        }
        if (matchCount == 5 && hasBonus) {
            return 6
        }
        return matchCount
    }

}