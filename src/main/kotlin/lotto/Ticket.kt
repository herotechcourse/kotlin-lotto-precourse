package lotto

import camp.nextstep.edu.missionutils.Randoms

class Ticket {
    val numbers: List<Int> = Randoms.pickUniqueNumbersInRange(1, 45, 6)
    val sortedNumbers: MutableList<Int> = numbers.sorted().toMutableList()
}