package lotto

import camp.nextstep.edu.missionutils.Randoms

fun main() {
    val inputView = InputView()
    val outputView = OutputView()

    val order = readPurchaseOrder(inputView)
    val tickets = generateTickets(order.getLottoCount())
    outputView.printTickets(tickets)

    val winningNumbers = readWinningNumbers(inputView)
    val bonusNumbers = readBonusNumber(inputView)

    Rank.values().sortedBy { it.matchedCount }.forEach { rank ->
        val matchedCount = tickets.count { ticket ->
            ticket.getNumbers().intersect(winningNumbers.toSet()).size == rank.matchedCount
        }
        val bonusMatched = tickets.count { ticket ->
            ticket.getNumbers().intersect(winningNumbers.toSet()).size == rank.matchedCount && ticket.getNumbers().contains(bonusNumbers)
        }
        if (rank.bonus) {
            println("${rank.matchedCount} Matches + Bonus Ball (${rank.getPrizeMoneyInKRW()}) – ${matchedCount + bonusMatched} tickets")
        } else {
            println("${rank.matchedCount} Matches (${rank.getPrizeMoneyInKRW()}) – ${matchedCount} tickets")
        }
    }
}

fun readPurchaseOrder(inputView: InputView): Order {
    while (true) {
        try {
            val purchaseAmount = inputView.readPurchaseAmount().toInt()
            return Order(purchaseAmount)
        } catch (e: NumberFormatException) {
            println("[ERROR] Purchase amount must be a valid number.")
        } catch (e: IllegalArgumentException) {
            println(e.message)
        }
    }
}

fun readWinningNumbers(inputView: InputView): List<Int> {
    while (true) {
        try {
            val winningNumbers = inputView.readWinningNumbers().split(",").map { it.trim().toInt() }
            require(winningNumbers.size == LOTTO_COUNT) { "[ERROR] Winning numbers must contain exactly $LOTTO_COUNT numbers." }
            require(winningNumbers.all { it in MIN_NUMBER..MAX_NUMBER }) { "[ERROR] Winning numbers must be between $MIN_NUMBER and $MAX_NUMBER." }
            return winningNumbers
        } catch (e: NumberFormatException) {
            println("[ERROR] Winning numbers must be valid integers.")
        } catch (e: IllegalArgumentException) {
            println(e.message)
        }
    }
}

fun readBonusNumber(inputView: InputView): Int {
    while (true) {
        try {
            val bonusNumber = inputView.readBonusNumber().toInt()
            require(bonusNumber in MIN_NUMBER..MAX_NUMBER) { "[ERROR] Bonus number must be between $MIN_NUMBER and $MAX_NUMBER." }
            // TODO: Check if the bonus number is unique and not in the winning numbers
            return bonusNumber
        } catch (e: NumberFormatException) {
            println("[ERROR] Bonus number must be a valid integer.")
        } catch (e: IllegalArgumentException) {
            println(e.message)
        }
    }
}

fun generateTickets(count: Int): List<Lotto> {
    return List(count) {
        val numbers = Randoms.pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, LOTTO_COUNT)
        Lotto(numbers)
    }
}