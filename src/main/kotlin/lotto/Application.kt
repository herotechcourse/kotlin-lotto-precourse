package lotto

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

class Application {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val purchaseAmount = InputView().purchaseAmount()
            val tickets = Application().generateLottoTickets(purchaseAmount)
            OutputView().displayTickets(tickets)
            val winningNumbers = InputView().inputWinningNumbers()
            InputView().inputBonusNumbers(winningNumbers)
        }
    }

    private fun generateLottoTickets(purchaseAmount: Long): List<Lotto> {
        val quantityOfTickets = (purchaseAmount / 1000).toInt()
        val tickets = mutableListOf<Lotto>()
        repeat(quantityOfTickets) {
            val numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6).sorted()
            tickets.add(Lotto(numbers))
        }
        return tickets
    }
}

class InputView {
    fun purchaseAmount(): Long {
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
        if (purchaseLotto <= 0L) {
            throw IllegalArgumentException("[ERROR] Amount cannot be zero and negative")
        }
        if (purchaseLotto % 1000L != 0L) {
            throw IllegalArgumentException("[ERROR] Amount must be a multiply of 1000")
        }
    }

    fun inputWinningNumbers(): List<Byte> {
        println("\nPlease enter last week's winning numbers.")
        val input = Console.readLine()

        if (input.isBlank()) {
            throw IllegalArgumentException("[ERROR] Input cannot be empty")
        }
        try {
            val winningNumbers = input.split(",").map { it.trim().toByte() }
            validateWinningNumbers(winningNumbers)
            return winningNumbers
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException("[ERROR] Invalid number format. Please enter valid numbers.")
        }
    }

    private fun validateWinningNumbers(winningNumbers: List<Byte>) {
        if (winningNumbers.isEmpty()) {
            throw IllegalArgumentException("[ERROR] Winning Numbers cannot be empty")
        }
        if (winningNumbers.size != 6) {
            throw IllegalArgumentException("[ERROR] Winning Numbers should have 6 numbers")
        }
        if (winningNumbers.distinct().size != 6) {
            throw IllegalArgumentException("[ERROR] Winning Numbers must not be duplicated")
        }
        if (winningNumbers.any { it < 1 || it > 45 }) {
            throw IllegalArgumentException("[ERROR] Winning Numbers should between 1 - 45")
        }
    }

    fun inputBonusNumbers(winningNumbers: List<Byte>): Byte {
        println("\nPlease enter the bonus numbers.")
        val input = Console.readLine()

        if (input.isBlank()) {
            throw IllegalArgumentException("[ERROR] Input cannot be empty")
        }
        try {
            val bonusNumbers = input.toByte()
            validateBonusNumbers(bonusNumbers, winningNumbers)
            return bonusNumbers
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException("[ERROR] Invalid number format. Please enter valid numbers.")
        }
    }

    private fun validateBonusNumbers(bonusNumbers: Byte, winningNumbers: List<Byte>) {
        if (bonusNumbers < 1 || bonusNumbers > 45) {
            throw IllegalArgumentException("[ERROR] Bonus Numbers should between 1 - 45")
        }
        if (winningNumbers.contains(bonusNumbers)) {
            throw IllegalArgumentException("[ERROR] Bonus Number must not be the same as any of the Winning Numbers")
        }
    }
}

class OutputView {
    fun displayTickets(tickets: List<Lotto>) {
        println("\nYou have purchased ${tickets.size} tickets.")
        for (ticket in tickets) {
            println(ticket)
        }
    }
}