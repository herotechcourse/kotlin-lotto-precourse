package lotto.controller

import lotto.exception.InputException

object RePromptHandler {
    fun <T> run(inputAction: () -> T): T {
        while (true) {
            try {
                return inputAction()
            } catch (e: IllegalArgumentException) {
                println("${e.message} ${InputException.PLEASE_RE_TRY.message()}")
            }
        }
    }
}