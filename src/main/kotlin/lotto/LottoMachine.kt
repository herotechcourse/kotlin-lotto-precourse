package lotto
import camp.nextstep.edu.missionutils.Randoms

class LottoMachine {
    fun generateTickets(count: Int): List<Lotto> {
        return List(count) {
            Lotto(generateRandomNumbers())
        }
    }

    private fun generateRandomNumbers(): List<Int> {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6)
    }
}