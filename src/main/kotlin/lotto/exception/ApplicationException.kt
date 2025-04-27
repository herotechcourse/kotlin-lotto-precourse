package lotto.exception

class ApplicationException(private val errorCode: ErrorCode) : IllegalArgumentException() {
    override val message: String
        get() = errorCode.getMessage()
}
