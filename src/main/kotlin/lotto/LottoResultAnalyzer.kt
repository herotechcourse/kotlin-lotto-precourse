package lotto

class LottoResultAnalyzer {

    fun analyze(lottos: List<Lotto>, winningLotto: WinningLotto): List<LottoResultType> {
        val lottoResultTypes = mutableListOf<LottoResultType>()

        for (lotto in lottos) {
            val matchWinningLotto = lotto.matchLotto(winningLotto)
            lottoResultTypes.add(matchWinningLotto)
        }

        return lottoResultTypes
    }

}