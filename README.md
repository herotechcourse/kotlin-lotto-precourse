# kotlin-lotto-precourse

# Lotto Ticket Machine

## 📌 Feature List

### 1. Purchase
- [ ] User inputs purchase amount.
- [ ] Validate that amount is divisible by 1,000.
- [ ] Generate correct number of tickets (1 ticket = 1,000 KRW).
- [ ] Each ticket has 6 unique random numbers between 1 and 45.
- [ ] Display all tickets in ascending order.

### 2. Winning Numbers
- [ ] User inputs winning numbers (6 unique numbers).
- [ ] User inputs a bonus number (must be different from winning numbers).
- [ ] Validate input: check for duplicates and correct range.

### 3. Result Calculation
- [ ] Compare each ticket to winning numbers.
- [ ] Determine rank (1st to 5th prize) based on matches.
- [ ] Calculate total prize money.
- [ ] Calculate and display profit rate.

### 4. Error Handling
- [ ] Throw `IllegalArgumentException` for invalid input.
- [ ] Show error messages in `[ERROR]` format.

### 5. Structure & Tests
- [ ] Organize by business logic and UI separation.
- [ ] Write unit tests for all logic (exclude UI).
- [ ] Follow Kotlin coding conventions: max 2 indentation levels, small functions, no `else`.





