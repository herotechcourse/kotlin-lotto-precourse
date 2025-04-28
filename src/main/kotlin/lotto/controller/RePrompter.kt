package lotto.controller

object RePrompter {
    fun <T> retryPrompt(
        promptFunction: () -> T,
        rePromptMessage: String = RE_PROMPT_MESSAGE,
        maxRetry: Int = 3,
    ): T {
        var lastException: Exception? = null
        for(tryCount in 0 .. maxRetry) {
            try {
                return promptFunction()
            } catch (e: Exception) {
                println(e.message+" "+rePromptMessage+"\n")
                lastException = e
            }
        }
        throw lastException ?: IllegalStateException("Unexpected error occurred.")
    }

    private const val RE_PROMPT_MESSAGE = "Please try again."
}
