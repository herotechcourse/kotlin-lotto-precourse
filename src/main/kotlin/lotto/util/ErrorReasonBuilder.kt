package lotto.util

class ErrorReasonBuilder {
    private val reasons = mutableListOf<String>()

    fun require(condition: Boolean, reason: String): ErrorReasonBuilder {
        if (!condition) {
            reasons.add(reason)
        }
        return this
    }

    fun getReasons(): List<String> {
        return reasons.toList()
    }

    fun inEmpty(): Boolean {
        return reasons.isEmpty()
    }
}
