package lotto.observer

interface ILottoObserver {
    /**
     * Updates the observer with the latest Lotto numbers and bonus number.
     *
     * @param lottoNumbers The list of Lotto numbers.
     * @param bonusNumber The bonus number.
     */
    fun println(message: Any?)
}