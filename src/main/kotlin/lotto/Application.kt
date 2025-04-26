package lotto

import camp.nextstep.edu.missionutils.Randoms

fun main() {
    val inputView = InputView()

    val order = readPurchaseOrder(inputView)
    val tickets = generateTickets(order.getLottoCount())
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

fun generateTickets(count: Int): List<Lotto> {
    return List(count) {
        val numbers = Randoms.pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, LOTTO_COUNT)
        Lotto(numbers)
    }
}