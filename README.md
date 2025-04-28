# kotlin-lotto-precourse
# Lotto Mission - Feature List
## 1. Purchase Amount
- Input the purchase amount from the user.
- Validate that the purchase amount is a positive integer divisible by 1,000.
- Calculate the number of lottery tickets that can be bought.
## 2. Lottery Ticket Generation
- Generate a lottery ticket containing 6 unique random numbers between 1 and 45.
- Generate multiple tickets according to the purchase amount.
- Sort ticket numbers in ascending order before displaying.
## 3. Winning Numbers Input
- Input 6 unique winning numbers from the user.
- Validate that numbers are between 1 and 45, and no duplicates exist.
## 4. Bonus Number Input
- Input a bonus number from the user.
- Validate that the bonus number is between 1 and 45 and does not duplicate any winning number.
## 5. Result Calculation
- Compare each ticket to the winning numbers.
- Determine the number of matching numbers for each ticket.
- Apply the following ranking rules:
  - 1st Prize: 6 matches
  - 2nd Prize: 5 matches + bonus number
  - 3rd Prize: 5 matches
  - 4th Prize: 4 matches
  - 5th Prize: 3 matches
- Calculate the total winnings.
## 6. Profit Rate Calculation
- Calculate the total return rate based on the total winnings and the purchase amount.
- Round the profit rate to the nearest tenth (e.g., 62.5%).
## 7. Error Handling
- If invalid input is provided, throw an IllegalArgumentException.
- Display error messages prefixed with [ERROR].
- Prompt the user again for correct input.
## 8. Output Format
- Display the list of purchased lottery tickets.
- Display winning statistics in the required format.
- Display the total return rate.