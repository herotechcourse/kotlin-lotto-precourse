package lotto.view.input

object BonusNumberInputView : InputView {
    override fun readInput(): String {
        println("Please enter the bonus number.")

        return Console.readLine()
    }
}