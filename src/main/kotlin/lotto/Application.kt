package lotto

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms
import lotto.Lotto

const val TICKET_PRICE = 1000;

fun main() {
    // Lotto Purchase Flow
    val amount: Int = promptAndTakeAmount()
    val tickets: List<Lotto> = generateLottos(amount / TICKET_PRICE)
    val answers: Pair<Lotto, Int> = promptAndTakeWinningAndBonus()
    //displayLottos(tickets)
}

fun promptAndTakeWinningAndBonus(): Pair<Lotto, Int> {
    while(true) {
        var input = promptInput("Please enter last week's winning numbers.")
        val numbers = parseCommaSeparatedNumbers(input) ?: continue
        if (!validateWinningOrShowError(numbers)) continue
        input = promptInput("Please enter the bonus number.")
        val bonus = parseInputToInt(input) ?: continue
        if (validateBonusOrShowError(bonus, numbers)) return Pair(Lotto(numbers), bonus)
    }
}

fun validateBonusOrShowError(bonus: Int, numbers: List<Int>) : Boolean = try {
    validateBonus(bonus, numbers)
    true
} catch (e: IllegalArgumentException) {
    println(e.message)
    false
}

fun validateBonus(bonus: Int, numbers: List<Int>)  {
    //if (bonus in numbers) throw IllegalArgumentException("[ERROR] Bonus can't be included in winning numbers.")
    //if (!(bonus in 1 .. 41)) throw IllegalArgumentException("[ERROR] Bonus must be between 1 and 45.")
}

fun validateWinningOrShowError(numbers: List<Int>) : Boolean = try {
    validateWinning(numbers)
    true
} catch (e: IllegalArgumentException) {
    println(e.message)
    false
}

fun validateWinning(numbers: List<Int>) {
    if (numbers.size != 6) {
        throw IllegalArgumentException("[ERROR] Please input exactly 6 comma-separated numbers.")
    }
    if (numbers.distinct().size != 6) {
        throw IllegalArgumentException("[ERROR] Numbers must not contain duplicates.")
    }
    if (!numbers.all { it in 1..45 }) {
        throw IllegalArgumentException("[ERROR] Numbers must be between 1 and 45.")
    }
}

fun parseCommaSeparatedNumbers(input: String): List<Int>? = try {
    input?.split(",")?.map { it.trim() }?.map { it.toInt() }
} catch (e: NumberFormatException) {
    println("[ERROR] Input must be a number")
    null
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