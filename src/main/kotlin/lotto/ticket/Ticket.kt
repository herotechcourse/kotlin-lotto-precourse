package lotto.ticket

import camp.nextstep.edu.missionutils.Randoms
import lotto.HIGHEST_NUMBER
import lotto.LOWEST_NUMBER

class Ticket {
    var numbers = Randoms.pickUniqueNumbersInRange(LOWEST_NUMBER, HIGHEST_NUMBER, 6)
}