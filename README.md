# kotlin-lotto-precourse

## 🎯 Lotto Program - Feature List
### 📌 Step 1. Lotto Purchase
Prompt the user to enter the purchase amount

Validate that the amount is divisible by 1,000 KRW

Issue one lottery ticket per 1,000 KRW

Each ticket contains 6 unique random numbers between 1 and 45

Sort and display each ticket's numbers in ascending order

### 📌 Step 2. Winning Numbers Input
Prompt the user to input last week's 6 winning numbers (comma-separated)

Validate the numbers (no duplicates, all within 1 to 45)

Prompt the user to input a bonus number

Validate the bonus number (must be between 1 and 45, and not duplicated)

### 📌 Step 3. Result Calculation
Compare each ticket with the winning numbers

Determine the prize rank based on the number of matches

Check for 2nd place condition (5 matches + bonus number)

Count the number of winning tickets for each rank

Calculate total winnings and return rate

Display results and return rate rounded to one decimal place

### 📌 Step 4. Input Validation & Error Handling
Throw an `IllegalArgumentException` if the amount is not a multiple of 1,000

Throw an exception if the lotto numbers are not exactly 6

Validate that numbers are in the correct range and not duplicated

Validate the bonus number (range, duplication)

Display error messages starting with `[ERROR]` and re-prompt input

