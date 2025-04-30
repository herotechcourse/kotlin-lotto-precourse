package lotto.controller

object RePrompter {
    fun <T> retryPrompt(
        promptFunction: () -> T,
        rePromptMessage: String = RE_PROMPT_MESSAGE,
        maxRetry: Int = 3,
    ): T {
        for(tryCount in 0 .. maxRetry) {
            try {
                return promptFunction()
            } catch (e: Exception) {
                println("$ERROR_TAG ${e.message} $rePromptMessage\n")
            }
        }
        throw IllegalStateException("$ERROR_TAG $OVER_RE_PROMPT_TRY_MESSAGE")
    }

    private const val ERROR_TAG = "[ERROR]"
    private const val RE_PROMPT_MESSAGE = "Please try again."
    private const val OVER_RE_PROMPT_TRY_MESSAGE = "You failed 3 times. Please try again later."
}
