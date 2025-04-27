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
- [X] Sort the numbers in each lotto ticket in ascending order. 
- [X] Print each lotto ticket's numbers, one per line.

### Receive the winning numbers for the lotto.
- [X] Print a prompt message to enter the winning numbers. "Please enter last week's winning numbers."
- [X] If the input is invalid, throw an 'IllegalArgumentException' and prompt the user again.
  - [X] If the input is empty.
  - [X] If the number of values is not 6.
  - [X] If any value is not a number.

### Receive the bonus number for the lotto.
- [X] Print a prompt message to enter the bonus number.
- [X] If the input is invalid, throw an 'IllegalArgumentException' and prompt the user again.
    - [X] If the input is empty.
    - [X] If the input is not a number.
    - [X] If the number is not in range 1 to 45.
    - [X] If the number must not consist of winning numbers.

### Print the winning statistics by match count.
- [X] Print a message for the winning statistics. "Winning Statistics"
- [X] Print a separator line.
- [X] Print the number of winning tickets for 3, 4, 5, 5+bonus number, and 6 matched numbers.

### Print the total return rate.
- [X] Calculate the total return rate.
- [X] Print the return rate message. "Total return rate is $62.5 %."
