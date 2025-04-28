package lotto.data.service

import camp.nextstep.edu.missionutils.Randoms

class LottoNumberService {

  fun generate(): List<Int> {
    return Randoms.pickUniqueNumbersInRange(
      LottoConstants.MIN_NUMBER,
      LottoConstants.MAX_NUMBER,
      LottoConstants.NUMBERS_PER_TICKET
    ).sorted()
  }
}




