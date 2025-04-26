package lotto

interface InputReader {
    fun readPurchaseAmount(): PurchaseAmount
    fun readWinningNumbers(): WinningNumbers
}
