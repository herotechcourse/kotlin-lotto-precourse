# kotlin-lotto-precourse

___

Try your luck 🍀

This is a lotto simulation game. The user enters the amount of money to spend on tickets (in KRW), the winning numbers, and one bonus number. The game generates as many tickets as the player can afford, as each costs 1,000 KRW. The tickets are then compared to the winning numbers, and the final prize is calculated. Finally, the amount spent is compared to the prize to calculate the profit percentage.

## Features

### Input Reception and Validation
This feature displays a prompt to get user input and save it in a variable. It performs necessary checks to ensure the input is not blank and has a valid format (e.g., contains only digits when a number is expected). If the input is invalid, it throws an `IllegalArgumentException` and displays an error message. The program reprompts until valid input is received.

### Purchase Tickets
The amount to be spent is received, and quality checks ensure that the amount is at least equal to the price of a single ticket. Additional checks verify that the amount is not excessively large (e.g., greater than 1,000,000 KRW) to ensure smooth program execution. The number of tickets is then calculated, and tickets are generated accordingly.

### Lotto Ticket Generation
This feature handles the input for winning numbers, performing quality checks such as verifying that there are exactly six numbers and that they are within the range of 1 to 45. It generates tickets with six unique numbers and provides safe access to them for other features.

### Compare and Match
This feature compares two tickets and counts how many numbers match between them. The number of matches is stored and made accessible to other features.

### Prize Table
This feature stores all prize categories, along with the corresponding number of matches required, whether the bonus number is needed, and the prize amounts. This information is made easily accessible for prize determination.

### Results Checker
Once all the data is generated and organized, this feature evaluates the results. It counts how many purchased tickets match the winning numbers and the bonus number. This information is compared to the prize table to generate Lotto statistics.

### Profit Calculator
The final prize amount is calculated based on the results. The amount spent is then compared to the final prize, and the profit percentage is calculated.

### Unit Tests
Unit tests are implemented for each feature to ensure functionality for base cases and edge cases, including error handling.
