package lotto.view

interface IInputView {
    fun readPurchaseAmount(): Int
    fun readWinningNumbers(): List<Int>
    fun readBonusNumber(): Int
}