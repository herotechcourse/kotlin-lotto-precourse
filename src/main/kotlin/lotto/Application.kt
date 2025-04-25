package lotto

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms
import lotto.Lotto

const val TICKET_PRICE = 1000;

fun main() {
    // Lotto Purchase Flow
    val amount: Int = promptAndTakeAmount()
    val tickets: List<Lotto> = generateLottos(amount / TICKET_PRICE)
    displayLottos(tickets)
}

fun displayLottos(lottos: List<Lotto>) {
    println("You have purchased ${lottos.size} tickets.")
    lottos.forEach { println(it.getNumbers()) }
}


fun generateLottos(count: Int) : List<Lotto> =
    List(count) { generateLotto() }

fun generateLotto() : Lotto {
    val numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6)
        .sorted()
    return Lotto(numbers)
}

fun promptAndTakeAmount() : Int {
    while (true) {
        val input = promptInput("Please enter the purchase amount.")
        val amount = parseInputToInt(input) ?: continue
        if (validateAmountOrShowError(amount)) return amount
    }
}

fun promptInput(msg: String) : String {
    println(msg)
    return Console.readLine()
}

fun parseInputToInt(input: String?) : Int? = try {
    input?.toInt()
} catch (e: NumberFormatException) {
    println("[ERROR] Input must be a number")
    null
}

fun validateAmountOrShowError(amount: Int) : Boolean = try {
    validateAmount(amount)
    true
} catch (e: IllegalArgumentException) {
    println(e.message)
    false
}

fun validateAmount(amount: Int) {
    if (amount <= 0) throw IllegalArgumentException("[ERROR] Amount must be positive.")
    if (amount % TICKET_PRICE != 0) throw IllegalArgumentException("[ERROR] Amount must be divisible by 1,000.")
}