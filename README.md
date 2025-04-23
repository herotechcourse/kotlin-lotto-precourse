# kotlin-lotto-precourse
___

Try your luck 🍀

This is a lotto simulation game. The user enters the amount of money to spend in tickets (in KRW), the winning numbers and one bonus number. The game generates as many tickets as the player can afford since each costs 1,000 KRW. Then, the tickets are compared to the winning numbers and the final prize is calculated. Finally, the amount spent is compared to the prize and the profit percentage is calculated.

## Features

### Input validation
Check if the inputs are correct according to the specified format. If they are not, throw an error and reprompt the input in question.

### Lotto ticket generator
Create a ticket with 6 unique numbers.

### Ticket Comparer
Compare ticket numbers with winning numbers and count matches.

### Purchase calculator
Calculate number of tickets based on ticket prize and amount to be spent.

### Player's tickets generator
Generate and assign purchased tickets according to number of tickets calculated.

### Prizes table
Store prizes categories for further comparison.

### Results checker
Get the results from tickets comparer and define final results and final prize.

### Profit calculator
Compare amount spent and final prize and calculate the percentage of profit.

### Unit Tests
Test each feature functionality. 
