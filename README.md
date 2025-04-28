# kotlin-lotto-precourse

## Domain

### 🎟️ Lotto

- [x] Numbers Property: numbers of a ticket (List of 6 unique integers between 1 and 45).
- [x] Validation: numbers must be exactly 6 and all unique.
- [x] Match Count Function: count how many numbers match with the winning numbers.
- [x] Contains Bonus Function: check if the ticket contains the bonus number.

### 🎰 Lotto Machine

- [x] Create Tickets Function: generate tickets based on the purchase amount.
- [x] Each ticket must consist of 6 unique random numbers between 1 and 45.

### 💰 Lotto Result

- [x] Rank Calculation Function: determine the prize rank based on matching numbers and bonus.
- [x] Result Aggregation Function: count the number of winning tickets for each rank.
- [x] Profit Rate Calculation Function: calculate the total return rate.

&nbsp;

## View

### InputView

- [x] Read Purchase Amount Function: read purchase amount from user input.
- [x] Read Winning Numbers Function: read 6 winning numbers (comma-separated) from user input.
- [x] Read Bonus Number Function: read bonus number from user input.
- [x] Input Validation: re-prompt on invalid input by throwing and handling IllegalArgumentException.

### OutputView

- [x] Print Purchased Tickets Function: print all issued tickets sorted in ascending order.
- [x] Print Result Statistics Function: print the statistics including match counts, prizes, and total profit rate.

&nbsp;

## Test

- [x] Feature Test: end-to-end flow from purchase to result calculation.
- [x] Exception Test: invalid purchase amount input.
- [x] Exception Test: invalid winning numbers input (duplicates, out-of-range, etc).
- [x] Exception Test: invalid bonus number input.
- [x] Unit Test: Lotto creation validation (number count, uniqueness).
- [x] Unit Test: LottoResult rank calculation and profit rate calculation.