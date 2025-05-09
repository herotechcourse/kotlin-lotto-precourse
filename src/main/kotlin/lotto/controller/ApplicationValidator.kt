package lotto.controller

import lotto.view.InputReader
import lotto.view.OutputPrinter

class ApplicationValidator(private val input: InputReader, private val output: OutputPrinter) {
    fun <RAW, VALUE> extractOrThrow(raw: RAW, validate: (RAW) -> ValidatedResult<VALUE>): VALUE {
        val result: ValidatedResult<VALUE> = validate(raw)

        return when (result) {
            is ValidatedResult.Success -> result.value
            is ValidatedResult.Failure ->
                throw IllegalArgumentException(result.reasons.joinToString(", "))
        }
    }

    fun <RAW, VALUE> extractOrRetry(input: () -> RAW , validate: (RAW) -> ValidatedResult<VALUE>, repeatCount: Int = DEFAULT_REPEAT_COUNT): VALUE {
        repeat(repeatCount) {
            val result: ValidatedResult<VALUE> = validate(input())
            when (result) {
                is ValidatedResult.Success -> return result.value
                is ValidatedResult.Failure -> output.printErrors(result.reasons)
            }
            if (it != repeatCount - 1) {
                output.printTryAgain()
            }
        }
        throw IllegalArgumentException(createRepeatOverMessage(repeatCount))
    }

    companion object {
        private const val DEFAULT_REPEAT_COUNT: Int = 3

        private fun createRepeatOverMessage(count: Int) = "You failed $count times. Please try again later."
    }
}
