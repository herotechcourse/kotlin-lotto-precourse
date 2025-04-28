# kotlin-lotto-precourse

# 🎯 Feature List - Lotto Pre-course Mission

## 🛒 Purchasing

- [x] Read the purchase amount from the user.
- [x] Validate that the amount is a multiple of 1,000 KRW.
- [x] Calculate the number of lotto tickets based on the amount.

## 🎟️ Ticket Generation

- [x] Generate lotto tickets using Randoms.pickUniqueNumbersInRange(1, 45, 6).
- [x] Each ticket must have 6 unique numbers between 1 and 45.
- [x] Sort the numbers in ascending order before displaying.
- [x] Create Lotto objects for each ticket.

## 🏆 Winning Numbers Input

- [x] Read last week's winning numbers (comma-separated).
- [x] Validate that exactly 6 unique numbers between 1 and 45 are entered.
- [x] Read a bonus number separately.
- [x] Validate that the bonus number is between 1 and 45 and not a duplicate of winning numbers.

## 🧮 Result Calculation

- [x] Compare each purchased lotto ticket with the winning numbers.
- [x] Determine the number of matches and check if the bonus number matches.
- [x] Categorize each ticket into prize ranks (1st to 5th).

## 📊 Output

- [x] Print the list of purchased tickets in ascending order.
- [ ] Print the winning statistics (number of tickets for each rank).
- [ ] Calculate the total prize money.
- [ ] Calculate and display the profit rate, rounded to one decimal place.

## ⚠️ Error Handling

- [ ] Throw IllegalArgumentException with "[ERROR]" prefix for invalid inputs.
- [ ] Re-prompt user input after an error without terminating the program.