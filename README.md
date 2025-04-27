# kotlin-lotto-precourse
## Features
### Input
- the purchase amount
- the winning numbers(comma-separated)
- the bonus number

### Output
- the number of tickets issued and the numbers on each ticket
- result statistics
- the profit rate
- error messages

### Issue lottery tickets
- Issue as many tickets as the budget allows (each ticket costs 1,000KRW).
#### A Lottery Ticket
- Consists of 6 unique random numbers (1 to 45).

### Rank the Lottery
- Compare the issued tickets with the winning number.
- Calculate profit rate.

### Validation
- Throw an IllegalArgumentException and re-prompt input.
- Validate the input
  - Is it not a blank?
  - Is it a number?
  - Is it divisible by 1,000?
  - Are the winning numbers and bonus numbers between 1 and 45?
  - Are the winning numbers duplicated?
  - Are there exactly six winning numbers?
  - Does the bonus number not duplicate any of the winning numbers?