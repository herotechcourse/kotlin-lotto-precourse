package lotto.view.input

import camp.nextstep.edu.missionutils.Console

class PurchaseAmountInputView : InputView {
    override fun readInput() = Console.readLine().toInt()
}