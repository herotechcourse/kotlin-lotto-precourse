package lotto

import camp.nextstep.edu.missionutils.Randoms

class Random(private val noOfTickets: Int) {
    // 2. Generate Random number for the number of tickets purchased
    fun generateTickets(): MutableList<MutableList<Int>> {
        val tickets: MutableList<MutableList<Int>> = mutableListOf()
        repeat(noOfTickets) {
            val randomNumber = Randoms.pickUniqueNumbersInRange(Input.RANDOM_MIN_VALUE, Input.RANDOM_MAX_VALUE, Input.LOTTO_MAX_SIZE)
            randomNumber.sort()
            tickets.add(randomNumber)
        }
        return tickets
    }
}