package lotto
import camp.nextstep.edu.missionutils.Randoms

class LottoMachine {
    fun generateTickets(count: Int): List<Lotto> {
        return List(count) {
            Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6))
        }
    }

    private fun generateRandomNumbers(): List<Int> {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6)
    }
}