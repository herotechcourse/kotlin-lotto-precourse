# kotlin-lotto-precourse

## Features
### take user's input (`view.InputView`)
-[X] take user's input 
### process user's input (`service.InputProcessingService`)
-[ ] validate user's inputs for
  -[ ] if the amount of money is divisible by 1000
  -[ ] if 6 winning numbers are each unique numbers
  -[ ] if one bonus number is unique from 6 winning numbers
  -[X] if all numbers (winning & bonus) are integers within 1 - 45
-[X] if validation fails, throw `IllegalArgumentException`
-[ ] return comma-separated winning numbers in a list
### ticket process (`lotto.Ticket`)
-[X] calculate how many tickets a user has bought
-[X] generate 6 unique random numbers for each purchased ticket
-[X] create lotto objects to store each ticket's winning numbers
### save lotto numbers (`lotto.Lotto`)
-[X] save one ticket's generated lotto numbers
-[X] create a number for bitmasking based on 6 numbers
-[X] sort lotto's numbers in ascending order
### save winning numbers (`lotto.WinningNumber`)
-[X] save winning numbers and a bonus number
-[X] create a number for bitmasking 6 winnning numbers and one bonus number
### lotto match & result process (`service.LottoMatchService`)
-[ ] bitmasking logic to count matching numbers between a ticket and winning numbera
-[ ] bitmasking logic to see if the ticket contains a bonus number
-[ ] determine the rank of each ticket based on matched numbers and bonus number
-[ ] count how many tickets fall into each rank
-[ ] calculate the lotto return rate
-[ ] round the return rate to the nearest tenth
### output process (`view.OutputView`)
-[X] print basic messages prompting the user for input
    -[X] "Please enter the purchase amount."
    -[X] "Please enter last week's winning numbers."
    -[X] "Please enter the bonus number."
-[X] print error messages for invalid inputs that start with `[ERROR]`
-[X] print how many tickets user has bought
-[X] print purchased tickets' numbers
-[X] print lotto result statistics
-[X] print rounded lotto return rate e.g., `65.5%`
### etc
-[X] use enums for prize money (`lotto.LottoRank`)
-[ ] re-prompting input from the step that caused exception (`lotto.Application.kt`)