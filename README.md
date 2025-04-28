# kotlin-lotto-precourse

## Features
### input process
- taking user's input
- validate user's inputs for
    - if amount of money is divisible by 1000
    - if 6 winning numbers are each unique numbers
    - if one bonus number is unique from 6 winning numbers
- if validation fails, throw `IllegalArgumentException`
- re-prompting input from the step that caused exception.
### ticket process
- calculate how many tickets user has bought
- random number generator that generates number from 1 to 45
- 6 unique random number generation logic for purchased tickets
- sort each ticket's numbers in ascending order
### lotto match & result process
- bitmasking logic to count matching numbers between a ticket and winning numbera
- bitmasking logic to see if the ticket contains bonus number
- determine the rank of each ticket based on matched numbers and bonus number
- count how many tickets fall into each rank
- calculate the lotto profit rate
- round the profit rate of lotto to the nearest tenth
### output process
- print basic messages prompting user for input
    - "Please enter the purchase amount."
    - "Please enter last week's winning numbers."
    - "Please enter the bonus number."
- print error messages for invalid inputs that start with `[ERROR]`
- print how many tickets user has bought
- print purchased tickets' numbers
- print lotto result statistics
- print rounded lotto profit rate e.g., `65.5%`
### etc
- use enums for prize money