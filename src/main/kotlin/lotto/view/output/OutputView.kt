package lotto.view.output

interface OutputView<T> {
    fun display(model: T)
}