# kotlin-lotto-precourse


## ✅ Feature List

### 1. Purchase Flow
- [x] Prompt user to input a purchase amount.
- [x] Validate that the amount is divisible by 1,000 KRW.
- [x] Calculate the number of tickets to be issued.
- [x] Generate the correct number of tickets.

### 2. Ticket Generation
- [x] Generate 6 **unique** random numbers per ticket.
- [x] Each number must be between 1 and 45.
- [x] Sort ticket numbers in ascending order.
- [x] Display all generated tickets after purchase.

### 3. Winning Numbers Input
- [x] Prompt user to input 6 unique winning numbers (comma-separated).
- [x] Validate numbers are in range [1, 45] and unique.
- [x] Prompt user to input 1 bonus number.
- [x] Validate bonus number is unique and in range.

### 4. Result Calculation
- [x] Compare each ticket to the winning numbers.
- [x] Count matched numbers and bonus match.
- [x] Determine prize rank:
  - 6 Matches → 🥇 1st Prize (2,000,000,000 KRW)
  - 5 Matches + Bonus → 🥈 2nd Prize (30,000,000 KRW)
  - 5 Matches → 🥉 3rd Prize (1,500,000 KRW)
  - 4 Matches → 🎖️ 4th Prize (50,000 KRW)
  - 3 Matches → 🏅 5th Prize (5,000 KRW)

### 5. Statistics and Profit Calculation
- [x] Count number of tickets per prize tier.
- [x] Calculate total earnings.
- [x] Calculate and display profit rate (rounded to 1 decimal place).

### 6. Input Validation & Error Handling
- [x] Throw `IllegalArgumentException` or `IllegalStateException` for invalid inputs.
- [x] Re-prompt user on invalid input.
- [x] Display all error messages with prefix `[ERROR]`.

### 7. Testing
- [ ] Unit test all domain logic and use cases.
- [ ] Validate ticket generation, matching logic, profit calculation.
- [ ] Use **JUnit 5** and **AssertJ**.
- [ ] Exclude tests for I/O (InputView/OutputView).

---

## 🧪 Tech Stack
