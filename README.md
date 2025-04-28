# kotlin-lotto-precourse

## Features
### take user's inputs in `Application.kt`
#### function `readAmount`
- take input of the purchase amount
- check input validation(is number and larger than 1000)
  - if the input is number
  - if the input is equal or larger than 1000
#### function `readWinningNumbers`
- take input of last week's winning numbers
#### function `readBonusNumber`
- take input of the bonus number
- check whether the input is between 1 and 45
----
### ticket process in `Application.kt`
- calculate how many tickets a user has bought in function `main`
  - Calculate the maximum number of tickets user can buy at a given price
----
### validation process in `Lotto.kt`
validate 'WinningNumbers' input
- check list of number contain exactly 6 numbers
- check each number in the list is unique
- check all numbers in the list are between 1 - 45
----
### result process in  `Application.kt`
- check whether winning of each ticket and profit rate
  - print the number of winning tickets for each rank
  - print total profit rate e.g., `62.5%`
