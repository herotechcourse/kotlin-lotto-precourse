package lotto

fun main() {
    try {
        val app = LottoApplication()
        app.run()
    } catch (e: IllegalArgumentException) {
        println(e.message)
    }
}