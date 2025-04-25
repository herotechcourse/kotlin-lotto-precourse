package lotto

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

class Application {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val purchaseAmount = Application().purchaseAmount()
            val tickets = Application().generateLottoTickets(purchaseAmount)
            Application().displayTickets(tickets)
        }
    }

    private fun purchaseAmount(): Long {
        println("Please enter the purchase amount.")
        val input = Console.readLine()?.trim()
        val purchaseLotto = input?.toLongOrNull()
        validatePurchaseAmount(purchaseLotto)
        return purchaseLotto!!
    }

    private fun validatePurchaseAmount(purchaseLotto: Long?) {
        if (purchaseLotto == null) {
            throw IllegalArgumentException("[ERROR] Amount cannot be empty and must be a valid number")
        }
        if (purchaseLotto == 0L) {
            throw IllegalArgumentException("[ERROR] Amount cannot be zero")
        }
        if (purchaseLotto % 1000L != 0L) {
            throw IllegalArgumentException("[ERROR] Amount must be a multiply of 1000")
        }
    }

    private fun generateLottoTickets(purchaseAmount: Long): List<Lotto> {
        val quantityOfTickets = (purchaseAmount / 1000).toInt()
        val tickets = mutableListOf<Lotto>()
        repeat (quantityOfTickets) {
            val numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6).sorted()
            tickets.add(Lotto(numbers))
        }
        return tickets
    }

    private fun displayTickets(tickets: List<Lotto>) {
        println("\nYou have purchased ${tickets.size} tickets.")
        for (ticket in tickets) {
            println(ticket)
        }
    }
}
