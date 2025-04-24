package lotto

class OutputValidator () {
    fun validatePrintPurchase (input: String) {
        require(!input.isBlank()) { LottoMessages.blankInput }
        require(input > "1") { LottoMessages.smallThanOne }
    }
}
