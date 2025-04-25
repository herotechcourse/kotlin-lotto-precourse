package lotto

data class WinningNumbersDto(val winningNumbers: List<Int>) {
    init {
        require(winningNumbers.size == 6) { ExceptionMessage.INVALID_LOTTO_NUMBER_SIZE.errorMessage }
        require(winningNumbers.toSet().size == winningNumbers.size) { ExceptionMessage.DUPLICATE_LOTTO_NUMBER.errorMessage }
        winningNumbers.forEach {
            require(it in 1..45) { ExceptionMessage.INVALID_LOTTO_NUMBER_RANGE.errorMessage }
        }
    }
}