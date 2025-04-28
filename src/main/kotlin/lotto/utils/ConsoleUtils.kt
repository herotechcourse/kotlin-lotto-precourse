package lotto.utils

import camp.nextstep.edu.missionutils.Console

fun readLineFromConsole(prompt : String) : String {
    println(prompt)
    return Console.readLine()
}