# kotlin-lotto-precourse
## TODO:: List of the features:

- [x] Create a LottoConfig component (class or object) to store lotto game configuration:
  - Store constants:
    - Amount of numbers in lotto ticket
    - Ticket price
    - Currency symbol/code
  -  Store variables to customize optional winning scenarios.
  -  Implement utility functions:
    - getSumForEachMatch(matches: Int, tickets: List<Int>): Int - Calculate prize amount based on match count and bonus number.
    - getTicketInfoFormat(numbers: List<Int>): String - Format ticket numbers as a string (e.g., "[1, 2, 3, 4, 5, 6]").
    - getFormatedSum(sum: Int): String - Format currency (e.g., "1,000,000").
    - printWinningStatisticsRow(matchesAmount: Int, isUsedBonusBall: Boolean, ticketsAmount: Int): Unit - Get winning message for a given match combination.
- [x] store error messages and implement getter function for errors
- [x] store messages to user and implement getter function for this messages
- [x] implement class UsersTickets
  - store purchaseAmount and tickets
  - validation of purchaseAmount (isDigit, %1000)
  - read purchaseAmount till check is okay
  - generate tickets in quantity purchaseAmount
- [x] implement class Lotto
  - validation of winningNumbers (isDigit, size = 6, unique)
  - read winningNumbers till check is okay
  - validation of bonusNumbers (isDigit, not in winningNumbers, in 1..45)
  - read bonusNumbers till check is okay
  - implement function to calculate amount of matches winning numbers with other ticket
  - calculate and print result of lottery session
  - calculate and print return rate