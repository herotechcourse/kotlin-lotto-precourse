# kotlin-lotto-precourse

## Summary

A lotto simulator implemented in Kotlin as part of the Hero Tech Course pre-course mission 2.

1. Enter the purchase amount. The program issues as many lottery tickets as the budget allows.
2. Enter the winning numbers and a bonus number.
3. The Program compares your tickets to the winning numbers and prints the result, including winning and profit rate.

## Feature List
### ✅ Ticket Purchase
- [x] **Accept purchase amount**
  - [x] Validate that the purchase amount is not blank
  - [x] Validate that the purchase amount is a number
  - [x] Validate that the purchase amount is a positive integer
  - [x] Validate that the purchase amount is divisible by 1,000
- [x] **Issue lottery tickets based on the purchase amount**
  - [x] Validate that the number of issued tickets matches the purchase amount divided by 1,000
  - [x] Validate that each ticket's numbers are in the range from 1 to 45
  - [x] Validate that each ticket's numbers consist of 6 unique numbers

### ✅ Winning numbers
- [ ] **Accept winning numbers**
  - [ ] Validate that the winning numbers are not blank
  - [ ] Validate that the winning numbers are numbers
  - [ ] Validate that the winning numbers are positive integers
  - [ ] Validate that the winning numbers are in the range from 1 to 45
  - [ ] Validate that the winning numbers consist of 6 unique numbers
- [ ] **Accept bonus number**
  - [ ] Validate that the bonus number is not blank
  - [ ] Validate that the bonus number is a number
  - [ ] Validate that the bonus number is a positive integer
  - [ ] Validate that the bonus number is in the range from 1 to 45
  - [ ] Validate that the bonus number is not included in the winning numbers

### ✅ Result Calculation
- [ ] **Compare user's tickets to the winning numbers and bonus number**
- [ ] **Calculate and show lottery result statistics**
- [ ] **Calculate and show profit rate**
  - [ ] Validate that the profit rate is rounded to the nearest tenth

### ⚠️ Error Handling
- [ ] **Error messages start with `[ERROR]`**
- [ ] **Re-prompt input if invalid data is entered**
- [ ] **Handle only specific exception types (e.g., `IllegalArgumentException`, `IllegalStateException`), not generic `Exception`**
