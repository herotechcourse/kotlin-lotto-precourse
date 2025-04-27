package lotto.exception

import lotto.util.Rule

enum class ExceptionMessage {
    INSUFFICIENT_PURCHASE_AMOUNT {
        override val message: String get() = "[ERROR] Purchase amount must be at least ${Rule.LOTTO_PRICE} KRW."
    },
    INVALID_PURCHASE_AMOUNT_FORMAT {
        override val message: String get() = "[ERROR] Purchase amount must be divisible by ${Rule.LOTTO_PRICE}."
    },
    EXCEEDS_MAX_PURCHASE_AMOUNT {
        override val message: String get() = "[ERROR] Purchase amount must not exceed ${Rule.MAX_PURCHASE_AMOUNT} KRW."
    },
    INVALID_NUMBER_COUNT {
        override val message: String get() = "[ERROR] Lotto must contain exactly ${Rule.NUMBERS_COUNT} numbers."
    },
    OUT_OF_RANGE_NUMBER {
        override val message: String get() = "[ERROR] Lotto numbers must be between ${Rule.MIN_NUMBER} and ${Rule.MAX_NUMBER}."
    },
    DUPLICATE_NUMBERS {
        override val message = "[ERROR] Lotto numbers must be unique."
    },
    INVALID_BONUS_NUMBER_RANGE {
        override val message: String get() = "[ERROR] Bonus number must be between ${Rule.MIN_NUMBER} and ${Rule.MAX_NUMBER}."
    },
    DUPLICATE_BONUS_NUMBER {
        override val message = "[ERROR] Bonus number must not be in the winning numbers."
    };

    abstract val message: String
}