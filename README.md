# kotlin-lotto-precourse


# 🧪 Test Cases
## ✅ 1. Input Validation Tests
### 💰 Purchase Amount Input
- Ensure the input amount is a multiple of 1,000.
- Handle invalid input such as negative numbers, zero, or non-numeric characters.
- Handle extremely large input values (e.g., 1,000,000,000) gracefully.

### 🎯 Winning Numbers
- Show an error if fewer or more than 6 numbers are entered.
- Show an error if duplicate numbers are entered.
- Show an error if any number is outside the 1–45 range.
- Show an error if the input is not comma-separated.

### 🎁 Bonus Number Input
- Show an error if the bonus number is already in the winning numbers.
- Show an error if the bonus number is outside the 1–45 range.

## ✅ 2. Lotto Ticket Generation Tests
- Ensure each ticket contains 6 unique numbers.
- All numbers must be between 1 and 45.
- Ensure multiple tickets are generated independently with random numbers.

## ✅ 3. Profit Rate Calculation Tests
- Ensure the total earnings are calculated correctly based on matching results.
- Ensure the return rate (as a percentage) is accurately calculated.
- Validate return rate output with decimal points.