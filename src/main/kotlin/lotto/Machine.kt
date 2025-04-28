package lotto

import camp.nextstep.edu.missionutils.Randoms

class Machine {

    fun generateTickets(count: Int): List<Ticket> {
        return List(count) {
            Ticket(Randoms.pickUniqueNumbersInRange(1, 45, 6))
        }
    }
}
