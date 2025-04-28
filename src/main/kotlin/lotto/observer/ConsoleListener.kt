package lotto.observer

object ConsoleListener: ILottoListener {
    override fun notify(message: Any?) {
        println(message)
    }
}