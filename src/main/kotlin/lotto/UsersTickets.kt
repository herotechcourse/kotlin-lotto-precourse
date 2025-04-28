package lotto

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms


class UsersTickets {

    private val purchaseAmount: Int
    private var numbers: List<List<Int>>

    init {
        purchaseAmount = requestPurchaseAmount()
        numbers = generateLottoTickets(purchaseAmount / LottoConfiguration.TICKET_PRICE)
    }

    private fun isDivideWithoutRemainderBy(number: Int, by: Int): Boolean {
        val result = number / by
        return result * by == number
    }

    private fun getPurchaseAmountErrorMessage(purchaseAmount: String): String {
        val attributeName = "Purchase amount"
        val errorMessage = when {
            purchaseAmount.isBlank() -> LottoError.get(attributeName, "isEmpty")
            purchaseAmount.any { !it.isDigit() } -> LottoError.get(attributeName, "notDigit")
            !isDivideWithoutRemainderBy(purchaseAmount.toInt(), LottoConfiguration.TICKET_PRICE) -> LottoError.get(attributeName, "%1000")
            else -> ""
        }
        return errorMessage
    }

    private fun checkPurchaseAmount(purchaseAmount: String): Boolean {
        val errorMessage = getPurchaseAmountErrorMessage(purchaseAmount)
        if (errorMessage.isBlank()) {
            return true
        }
        println(errorMessage)
        return false
    }

    private fun requestPurchaseAmount(): Int {
        LottoPrompt.printMessageToUser("purchaseAmount", "")
        var purchaseAmount = Console.readLine()
        while (!checkPurchaseAmount(purchaseAmount)) {
            purchaseAmount = Console.readLine()
        }
        return purchaseAmount.toInt()
    }

    fun getPurchasedAmount(): Int {
        return purchaseAmount
    }


    private fun generateLottoTickets(purchaseAmount: Int): List<List<Int>> {
        LottoPrompt.printMessageToUser("PRINT_PURCHASED_TICKETS", purchaseAmount.toString())
        val lottoTickets: MutableList<List<Int>> = mutableListOf()
        for (i in 0..<purchaseAmount) {
            val ticket = Randoms.pickUniqueNumbersInRange(1, 45, LottoConfiguration.NUMBER_AMOUNT)
            lottoTickets.add(i, ticket)
            println(LottoConfiguration.getTicketInfoFormat(ticket))
        }
        println()
        return lottoTickets.toList()
    }

    fun getLottoTickets(): List<List<Int>> {
        return numbers
    }

}