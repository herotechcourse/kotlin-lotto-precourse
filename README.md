# Lotto 🎰

---

## Feature Specification

### Receive the purchase amount for the lottery.
- [ ] Display a prompt message to enter the purchase amount.
- [ ] Parse the entered amount and calculate the number of purchasable tickets by dividing it by 1,000.
- [ ] If the input is invalid, throw an 'IllegalArgumentException' and prompt the user again.
  - [ ] If the input is empty.
  - [ ] If the amount is less than 1,000.
  - [ ] If the amount is not divisible by 1,000.
  - [ ] If the input is not a valid number.

### Display the purchased lottery tickets.
- [ ] Display a message to show the number of purchased tickets. "You have purchased $8 tickets."
- [ ] Display each lottery ticket's numbers, one per line.

### Receive the winning numbers for the lottery.
- [ ] Display a prompt message to enter the winning numbers. "Please enter last week's winning numbers."
- [ ] If the input is invalid, throw an 'IllegalArgumentException' and prompt the user again.
  - [ ] If the input is empty.
  - [ ] If the number of values is not 6.
  - [ ] If any value is not a number.

### Receive the bonus number for the lottery.
- [ ] Display a prompt message to enter the bonus number.
- [ ] If the input is invalid, throw an 'IllegalArgumentException' and prompt the user again.
    - [ ] If the input is empty.
    - [ ] If the input is not a number.
    - [ ] If the number is not in range 1 to 45.

### Display the winning statistics by match count.
- [ ] Display a message for the winning statistics. "Winning Statistics"
- [ ] Display a separator line.
- [ ] Display the number of winning tickets for 3, 4, 6, 6+bonus, and 6 matched numbers.

### Display the total return rate.
- [ ] Calculate the total return rate.
- [ ] Display the return rate message. "Total return rate is $62.5 %."





e nearest tenth (e.g., 100.0%, 51.5%, 1,000,000.0%):