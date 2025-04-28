package lotto.observer

object LottoObserver : ILottoObserver {
    private val listeners: MutableList<ILottoListener> = mutableListOf()

    init {
        listeners.add(ConsoleListener)
    }

    override fun println(message: Any?) {
        listeners.forEach { it.notify(message) }
    }
}