# kotlin-lotto-precourse

# Functional Requirements
### Input
- The price of a ticket is `1,000 KRW` and the input amount must be in units of `1,000 KRW`.
- User inputs the winning numbers and bonus number.
  - The winning numbers consist of 6 unique values.
  - The bonus number is a single value.

### Lotto
- Each tickets contain six unique numbers between 1 and 45.
- Prizes are awarded for ranks up to 5th rank, based on the following criteria
  - 1st : Match 6 numbers / 2,000,000,000 KRW
  - 2nd : Match 5 numbers + bonus number / 30,000,000 KRW
  - 3rd : Match 5 numbers / 1,500,000 KRW
  - 4th : Match 4 numbers / 50,000 KRW
  - 5th : Match 3 numbers / 5,000 KRW

### Result
- Print the number of winning tickets for each rank.
- Compare the winning numbers with the user's numbers and print the results along with the rate of return

<hr>

# Programming Requirements
  - Avoid using `else`, use `return` instead.
  - Use an `Enum` class where application
  - Seperate UI logic from business logic
    - The `InputView` and `OutputView` classes should be separated from the core business logic
  - Implement unit tests for all logic, except for UI interactions.

<hr>

# Architecture
### 1. Input
  - Exception
  - [x] If the user inputs invalid data, re-prompt input from that step
  - Amount
    - [x] Non-numeric characters are used
    - [x] The amount is not a unit of `1,000 KRW`
    - [x] The amount exceeds the range of an Integer
  - Winning Numbers
    - [x] Non-numeric characters are used(excluding commas)
    - [x] Fewer or more than 6 numbers are entered
    - [x] Duplicate numbers are entered
    - [x] Numbers outside the range of 1 to 45 are entered
  - Bonus Number
    - [x] Non-numeric characters are used
    - [x] The number is not within the range of 1 to 45
    - [x] Bonus number is not duplicate with winning numbers

### 2. Output
  - Purchased Lotto Numbers
    - [x] print `(purchase amount / 1,000)` sets of numbers, enclosed in square brackets and separated by comma(,)
  - Winning Statistics
    - [x] Print the results in ascending order.
  - Rate of Return
    - [x] Print the value rounded to the first decimal place.
  - Exception
    - [x] Throw an error message starting with `[ERROR]`

### 3. Business Logic
  - [x] Rank is implemented using an `Enum` class.
    - (matchCount, prize amount)
  - [x] Purchased lotto numbers are stored in a List.
  - List Iteration
    - [x] implement method that return Lotto to List<Int>
    - [x] For each purchased lotto ticket, check how many numbers including the bonus number match the winning numbers.
    - [x] Store winning tickets in a `Map`
  - Prize Amount Sum
    - [x] Calculate the rate of return rounded to the first decimal place.
      - (total winning amount / total purchase amount) * 100