package lotto.util

inline fun <T> runCatchingRepeatedly(block: () -> T): T {
    while (true) {
        try {
            return block()
        } catch (e: IllegalArgumentException) {
            println(e.message)
        } catch (e: IllegalStateException) {
            println(e.message)
        }
    }
}
