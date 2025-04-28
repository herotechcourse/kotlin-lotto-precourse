package lotto.view.output

interface OutputView<in T> {
    fun display(model: T)
}