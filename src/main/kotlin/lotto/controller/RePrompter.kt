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
                println(e.message+" "+rePromptMessage+"\n")
            }
        }
        throw IllegalStateException(OVER_RE_PROMPT_TRY_MESSAGE)
    }

    private const val RE_PROMPT_MESSAGE = "Please try again."
    private const val OVER_RE_PROMPT_TRY_MESSAGE = "[ERR] You failed 3 times. Please try again later."
}
