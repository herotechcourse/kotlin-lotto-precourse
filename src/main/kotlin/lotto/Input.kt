package lotto

import camp.nextstep.edu.missionutils.Console

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
            println(e.message)
            null
        }
    }
}
