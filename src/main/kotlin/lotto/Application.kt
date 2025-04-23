package lotto

import camp.nextstep.edu.missionutils.Console

fun main() {
    val inputView = InputView()

    println(inputView.getAmount())
    println(inputView.getWinningNumbers())
    println(inputView.getBonusNumber())
}
