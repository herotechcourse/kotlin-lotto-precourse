package lotto.factory

import lotto.enums.OutputType
import lotto.view.output.OutputView
import lotto.view.output.DisplayLottosOutputView
import lotto.view.output.DisplayWinningStatisticsOutputView

object OutputViewFactory {
    @Suppress("UNCHECKED_CAST")
    fun <T> createOutputView(outputType: OutputType): OutputView<T> {
        return when (outputType) {
            OutputType.LOTTOS -> DisplayLottosOutputView as OutputView<T>
            OutputType.WINNING_STATISTICS -> DisplayWinningStatisticsOutputView as OutputView<T>
        }
    }
}