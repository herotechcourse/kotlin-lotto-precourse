package lotto

import camp.nextstep.edu.missionutils.Randoms

class RandomLottoNumberGenerator : LottoNumberGenerator {
    override fun generateNumbers(): List<Int> {
        return Randoms.pickUniqueNumbersInRange(START_NUMBER, END_NUMBER, PICK_NUMBER).sorted()
    }

    companion object {
        private const val START_NUMBER = 1
        private const val END_NUMBER = 45
        private const val PICK_NUMBER = 6
    }
}