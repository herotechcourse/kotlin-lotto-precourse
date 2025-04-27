package lotto

object LotteryTicketMachine {

    fun validatePurchaseAmount(amount: Int) {
        if (amount % 1000 != 0) {
            throw IllegalArgumentException("[ERROR] Purchase amount must be divisible by 1,000.")
        }
    }
}