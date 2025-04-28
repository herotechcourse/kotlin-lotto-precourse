package lotto

fun main() {
  val game = LottoGame()
  try {
    game.play()
  } catch (e: NumberFormatException) {
    println(e.message)
  } catch (e: IllegalArgumentException) {
    println(e.message)
  }
}
