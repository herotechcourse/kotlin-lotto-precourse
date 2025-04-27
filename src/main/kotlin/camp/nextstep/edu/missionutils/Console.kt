package camp.nextstep.edu.missionutils

object Console {
    fun readLine(): String {
        return kotlin.io.readLine() ?: throw IllegalStateException("[ERROR] Input failed.")
    }

    fun close() {
        // Needed for test framework, no operation.
    }
}
