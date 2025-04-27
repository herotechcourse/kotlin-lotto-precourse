package lotto

class PurchaseService(private val inputView: LottoInputView, private val outputView: LottoOutputView) {

    fun getTicketCount(): Int {
        val userInput = inputView.getPurchaseAmount()
        val amount = parseAmount(userInput)
        validateAmount(amount)
        return calculateTicketCount(amount)
    }

    private fun parseAmount(userInput: String): Int {
        return userInput.toIntOrNull() ?: throw IllegalArgumentException("Invalid input. Please enter a valid number.")
    }

    private fun calculateTicketCount(amount: Int): Int {
        val ticketCount = amount / 1000
        outputView.showTicketCount(ticketCount)
        return ticketCount
    }

    private fun validateAmount(amount: Int) {
        if (amount < 1000) {
            throw IllegalArgumentException("Amount must be at least 1,000 KRW.")
        }
        if (amount % 1000 != 0) {
            throw IllegalArgumentException("Amount must be divisible by 1,000 KRW.")
        }
    }
}