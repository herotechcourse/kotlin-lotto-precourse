# kotlin-lotto-precourse

## 📂 Feature List

### 🔉 Input/Output Features

- [ ] Accept user input.
- [Exception] Input must not be empty.
    - [ ] Accept the lottery purchase amount.
    - [Exception] Purchase amount must be divisible by 1,000 KRW.
    - [Exception] All input values must be numeric.
    - [ ] Accept the winning numbers.
    - [Exception] There must be exactly 6 winning numbers.
    - [Exception] Each number must be between 1 and 45.
    - [Exception] Input values must be numeric.
    - [Exception] Winning numbers must be separated by commas (,).
    - [Exception] No other characters may appear between commas.
    - [ ] Accept the bonus number.
    - [Exception] Bonus number must be between 1 and 45.
    - [Exception] Winning numbers must not contain duplicates.
    - [Exception] Bonus number must not duplicate any winning number.
- [ ] Display processed results to the user.
    - [ ] Show the number of tickets issued and each ticket’s numbers.
    - [Exception] Ticket numbers must be sorted in ascending order.
    - [ ] Show the winning results and profit rate.
    - [Exception] Profit rate must be rounded to two decimal places.

### 💻 Domain Features

- [x] Compare generated tickets with winning numbers to count matches.
- [x] Calculate the prize amount corresponding to the number of matches.
- [x] Determine the rank corresponding to the number of matches.

### 🔨 Utility Features

- [x] Auto-generate lottery numbers for each purchased ticket.
- [x] Calculate profit rate based on purchase amount and total winnings.