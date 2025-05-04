package helpers

fun printError(e: Exception, attempt: Int, maxAttempts: Int) {
    println("[ERROR] ${e.message}. Please try again. (Attempt ${attempt + 1} of $maxAttempts)")
}
 
fun <T>withReprompt(maxAttempts:Int=5, action:()->T):T
{
    var lastError: Throwable? = null
    repeat(maxAttempts) { attempt ->
        try {
            return action()
        } catch (e: Exception) {
            lastError = e
            printError(e, attempt, maxAttempts)
        }
    }
    throw lastError ?: IllegalStateException("Unknown error occurred after $maxAttempts attempts")
}
