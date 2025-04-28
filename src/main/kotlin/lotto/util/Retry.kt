package lotto.util

import lotto.observer.ILottoObserver
import lotto.observer.LottoObserver

/**
 * Executes [block], catching any IllegalArgumentException to re-prompt the user.
 */
fun <T> retry(observer: ILottoObserver = LottoObserver, block: () -> T): T {
    while (true) {
        try {
            return block()
        } catch (e: IllegalArgumentException) {
            observer.println(e.message ?: "[ERROR]: Invalid input.")
        }
    }
}