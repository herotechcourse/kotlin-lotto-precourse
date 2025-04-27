package lotto.ui

interface ConsoleIoInterface : InputReader, OutputReader {
    override fun read(): String
    override fun print(message: String)
}