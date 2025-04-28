package lotto

class LottoPrompt {

    companion object {

        private val messageToUser: Map<String, String> = mapOf(
            "purchaseAmount" to "Please enter the purchase amount.",
            "winningNumbers" to "Please enter last week's winning numbers.",
            "bonusNumber" to "Please enter the bonus number.",
            "PRINT_PURCHASED_TICKETS" to "You have purchased [PLACEHOLDER1] tickets.",
            "PRINT_WINNING_STATISTICS_HEADER" to "Winning Statistics\n---",
            "PRINT_RETURN_RATE" to "Total return rate is [PLACEHOLDER1]%."
        )

        fun printMessageToUser(messageCode: String, placeholder: String) {
            if (messageToUser.containsKey(messageCode)) {

                println(messageToUser[messageCode]?.replace("[PLACEHOLDER1]", placeholder))
            }
            return
        }
    }
}