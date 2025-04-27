package lotto.exception

sealed class LottoException(message: String) : IllegalArgumentException(message) {
    class InvalidCount : LottoException("[ERROR] Lotto must contain exactly 6 numbers.")
    class DuplicateNumbers : LottoException("[ERROR] Lotto numbers must not contain duplicates.")
}