package lotto

class LottoResultAnalyzer {

    fun analyze(lottos: List<Lotto>, winningLotto: WinningLotto): List<LottoResultType> {
        val lottoResultTypes = mutableListOf<LottoResultType>()

        for (lotto in lottos) {
            lottoResultTypes.add(lotto.matchLotto(winningLotto))
        }

        return lottoResultTypes
    }

}