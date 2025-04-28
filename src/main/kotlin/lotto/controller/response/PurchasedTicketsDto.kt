package lotto.controller.response

import lotto.domain.dto.NumbersDto

data class PurchasedTicketsDto(val ticketCount: Int, val tickets: List<NumbersDto>)
