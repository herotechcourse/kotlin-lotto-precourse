package lotto.support

import lotto.view.OutputView

object RetryHelper {
    fun <T> retry(action: () -> T): T {
        while (true) {
            try {
                return action()
            } catch (e: IllegalArgumentException) {
                OutputView.printErrorMessage(e.message)
            }
        }
    }
}
