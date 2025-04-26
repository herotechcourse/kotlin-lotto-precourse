package lotto.presentation

interface OutputView {
    fun printErrorMessage(errorMessage: String?)
}

class OutputViewImpl : OutputView {
    override fun printErrorMessage(errorMessage: String?) {
        println("$ERROR_MESSAGE_PREFIX $errorMessage")
    }

    companion object {
        private const val ERROR_MESSAGE_PREFIX = "[ERROR]"
    }
}