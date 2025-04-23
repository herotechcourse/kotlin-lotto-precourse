# Functional Requirements

## 1. Lottery Ticket
- Cost: 1,000 KRW
- Numbers:
  - Each ticket must consist of 6 `different` random numbers. 
  - Range: `1 - 45` 
  - Use: `Randoms.pickUniqueNumbersInRange(1, 45, 6)`
  - [Error] Handle:
    - Duplicate numbers
    - Out-of-range values.

## 2. Budget Validation
- Minimum amount: `1,000 KRW`
- Budget must be divisible by 1,000
  - Ignore any remaining amount.
- Available ticket count
  - `purchaseAmount / 1000`
  - Ignore decimal part.

## 3. Ticket
- Generate `nLottery` tickets.
- Sort each ticket in `ascending` order.
- Use the provided `Lotto` class.

## 4. Winning main numbers
- Must consist of `6 different` numbers.
- Range: `1 - 45`
- [Error] Handle:
  - Duplicate numbers
  - Out-of-range values.

## 5. Winning bonus number
- Must be a `single` number
- Must not duplicate any of the main numbers
- Range: `1 - 45`
- [Error] Handle:
    - Duplicate numbers
    - Out-of-range values.

## 6. Matching & Rank Calculation
- Define 5-types of prizes.
- Use `enum` class for `Rank`.
- Bonus number works only for `2nd Prize`.
- Store the number of wins per rank.
- Profit rate = `Total prize money / Total purchase amount`

| Prize sort | Matching Numbers |      Prize Amount |
|:----------:|:----------------:|------------------:|
| 1st Prize  |        6         | 2,000,000,000 KRW |
| 2nd Prize  | 5 + Bonus Number |    30,000,000 KRW |
| 3rd Prize  |        5         |     1,500,000 KRW |
| 4th Prize  |        4         |        50,000 KRW |
| 5th Prize  |        3         |         5,000 KRW |

## 7. Error message
- All error messages must start with `[ERROR]`

## 8. Rounding up regulation
- Round to the `second` decimal place.
- Display only up to the `first` decimal place.
  - ex) `81.22 -> 81.2`

## 9. Output Requirements
- Display `nLottery` (the number of tickets)
- Display `each ticket’s numbers` enclosed in square brackets.
- Display `Winning Statistics`
- Display `Profit rate`
- Display `Error messages`