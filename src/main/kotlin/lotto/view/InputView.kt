package lotto.view

import camp.nextstep.edu.missionutils.Console

class InputView {
    fun readPurchaseLottoAmount(): String = Console.readLine()

    fun readWinningNumbers() : String = Console.readLine()

    fun readBonusNumber() : String = Console.readLine()
}