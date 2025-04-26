package lotto

class OutputValidator () {
    fun validatePrintPurchase (input: String) {
        require(!input.isBlank()) { LottoMessages.blankInput }
        input.toIntOrNull() ?: throw IllegalArgumentException( LottoMessages.invalidWinningNumbers)
        require(input > "1") { LottoMessages.smallThanOne }
        require(input.toInt() % 1000 == 0) { LottoMessages.divisibleByThousand }
    }

    fun validatePrintResults (winningResults: List<TicketResults>) {
        winningResults.forEach {
            require(it.prize != Prize.NO_PRIZE) { LottoMessages.invalidResults }
            if (it.prize == Prize.SECOND) { require(it.hasBonus) { LottoMessages.mustHaveBonus } }
        }
    }
}