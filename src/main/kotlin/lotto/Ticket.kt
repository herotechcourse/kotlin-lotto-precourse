package lotto

import camp.nextstep.edu.missionutils.Randoms

class Ticket {
    val numbers: List<Int>
    val sortedNumbers: MutableList<Int>

    constructor() {
        numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6)
        sortedNumbers = numbers.sorted().toMutableList()
    }

    constructor(list: List<Int>) {
        numbers = list
        sortedNumbers = numbers.sorted().toMutableList()
    }
}