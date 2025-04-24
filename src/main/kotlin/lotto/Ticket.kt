package lotto

import camp.nextstep.edu.missionutils.Randoms

class Ticket(val bonusNumber: Int) {
    val numbers: List<Int>? = Randoms.pickUniqueNumbersInRange(1, 45, 6)
    // Property declarations
    // Initializer blocks
    // Secondary constructors
    // Method declarations
    // Companion object
}