package lotto.ui.console

interface ConsoleIOInterface : InputReader, OutputReader {
    override fun read(): String
    override fun print(message: String)
}