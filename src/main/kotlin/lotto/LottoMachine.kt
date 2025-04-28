package lotto

import camp.nextstep.edu.missionutils.Randoms

class LottoMachine {
    fun createTickets(amount: Int): List<Lotto> {
        require(amount % 1000 == 0) { "[ERROR] Amount must be divisible by 1000." }

        val count = amount / 1000
        return List(count) {
            val numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6)
            Lotto(numbers)  // Lotto 안에서 정렬되니까 여기선 생략 가능

        }
    }
}
//구매 금액 바탕으로 티켓을 생성하는 역할
