package util

import view.OutputView

inline fun safeRun(block: () -> Unit) {
    try{
        block()
    } catch(e: IllegalArgumentException){
        OutputView.printErrorMessage(e.message ?: "An error has occurred.")
    }

}