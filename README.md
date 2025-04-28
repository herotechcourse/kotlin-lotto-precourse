# kotlin-lotto-precourse

## Features
### take user's input (`view.InputView`)
- take user's input
### process user's input (`service.InputProcessingService`)
- validate user's inputs for
    - if the amount of money is divisible by 1000
    - if 6 winning numbers are each unique numbers
    - if one bonus number is unique from 6 winning numbers
    - if all numbers (winning & bonus) are within 1 - 45
- if validation fails, throw `IllegalArgumentException`
- re-prompting input from the step that caused exception.
- return comma-separated winning numbers in a list
### ticket process (`lotto.Ticket`)
- calculate how many tickets a user has bought
- generate 6 unique random numbers for each purchased ticket
- sort each ticket's numbers in ascending order
- create lotto objects to store each ticket's winning numbers
### save lotto numbers (`lotto.Lotto`)
- save one ticket's generated lotto numbers
- create a number for bitmasking based on 6 numbers
### save winning numbers (`lotto.WinningNumber`)
- save winning numbers and a bonus number
- create a number for bitmasking 6 winnning numbers and one bonus number
### lotto match & result process (`service.LottoMatchService`)
- bitmasking logic to count matching numbers between a ticket and winning numbera
- bitmasking logic to see if the ticket contains a bonus number
- determine the rank of each ticket based on matched numbers and bonus number
- count how many tickets fall into each rank
- calculate the lotto return rate
- round the return rate to the nearest tenth
### output process (`view.OutputView`)
- print basic messages prompting the user for input
    - "Please enter the purchase amount."
    - "Please enter last week's winning numbers."
    - "Please enter the bonus number."
- print error messages for invalid inputs that start with `[ERROR]`
- print how many tickets user has bought
- print purchased tickets' numbers
- print lotto result statistics
- print rounded lotto return rate e.g., `65.5%`
### etc
- use enums for prize money