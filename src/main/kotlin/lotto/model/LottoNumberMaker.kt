package lotto.model

import camp.nextstep.edu.missionutils.Randoms

const val LOTTO_NUMBER_START = 1
const val LOTTO_NUMBER_END = 45
const val LOTTO_NUMBER_COUNT = 6

object LottoNumberMaker {
    fun makeOneLineLottoNumber(): List<Int> {
        return Randoms.pickUniqueNumbersInRange(LOTTO_NUMBER_START, LOTTO_NUMBER_END, LOTTO_NUMBER_COUNT)
    }

    fun makeTotalLottoNumber(ticketCount: Int): MutableList<List<Int>> {
        val totalLottoNumber = mutableListOf<List<Int>>()

        repeat(ticketCount) {
            totalLottoNumber.add(makeOneLineLottoNumber())
        }

        return totalLottoNumber
    }

    fun printTotalLottoNumber(lottoNumber: List<List<Int>>) {
        for (list in lottoNumber) {
            println(list)
        }
    }
}
