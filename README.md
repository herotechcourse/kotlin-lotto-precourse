# Lotto 🎰

---

## Feature Specification

### Receive the purchase amount for the lotto.
- [X] Print a prompt message to enter the purchase amount.
- [X] Parse the entered amount and calculate the number of purchasable tickets by dividing it by 1,000.
- [X] If the input is invalid, throw an 'IllegalArgumentException' and prompt the user again.
  - [X] If the input is empty.
  - [X] If the amount is less than 1,000.
  - [X] If the amount is not divisible by 1,000.
  - [X] If the input is not a valid number.

### Print the purchased lotto tickets.
- [X] Print a message to show the number of purchased tickets. "You have purchased $8 tickets."
- [X] Print each lotto ticket's numbers, one per line.

### Receive the winning numbers for the lotto.
- [X] Print a prompt message to enter the winning numbers. "Please enter last week's winning numbers."
- [X] If the input is invalid, throw an 'IllegalArgumentException' and prompt the user again.
  - [X] If the input is empty.
  - [X] If the number of values is not 6.
  - [X] If any value is not a number.

### Receive the bonus number for the lotto.
- [ ] Print a prompt message to enter the bonus number.
- [ ] If the input is invalid, throw an 'IllegalArgumentException' and prompt the user again.
    - [ ] If the input is empty.
    - [ ] If the input is not a number.
    - [ ] If the number is not in range 1 to 45.

### Print the winning statistics by match count.
- [ ] Print a message for the winning statistics. "Winning Statistics"
- [ ] Print a separator line.
- [ ] Print the number of winning tickets for 3, 4, 6, 6+bonus, and 6 matched numbers.

### Print the total return rate.
- [ ] Calculate the total return rate.
- [ ] Print the return rate message. "Total return rate is $62.5 %."





e nearest tenth (e.g., 100.0%, 51.5%, 1,000,000.0%):