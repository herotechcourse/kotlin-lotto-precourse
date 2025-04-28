package lotto.view

import lotto.domain.PurchaseAmount
import lotto.domain.WinningNumbers

interface InputReader {
    fun readPurchaseAmount(): PurchaseAmount
    fun readWinningNumbers(): WinningNumbers
}
