package lotto

import camp.nextstep.edu.missionutils.Console
import lotto.Consts.ERROR_PREFIX

class Input {

    fun <T> enterNumber(block: (String) -> T): T {
        while (true) {
            isRun(block)?.let { return it }
        }
    }

    private fun <T> isRun(block: (String) -> T): T? {
        return try {
            block(Console.readLine())
        } catch (e: IllegalArgumentException) {
            println("$ERROR_PREFIX ${e.message}")
            null
        }
    }
}
