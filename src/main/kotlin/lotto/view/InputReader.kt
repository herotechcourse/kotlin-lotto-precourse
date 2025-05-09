package lotto.view

interface InputReader {
    fun readPurchaseAmount(): String
    fun readWinningNumbers(): List<String>
    fun readBonusNumber(): String
}
