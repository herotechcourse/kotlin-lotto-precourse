package lotto.model

import camp.nextstep.edu.missionutils.Randoms

object LottoNumberMaker {
    fun makeOneLineLottoNumber(): List<Int> {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6)
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