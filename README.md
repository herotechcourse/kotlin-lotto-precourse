# kotlin-lotto-precourse

## Implementation Feature List

-   [x] Purchase Amount
    -   [x]  User enters the amount to purchase Lotto tickets.
    -   [x]  Input is validated as an integer.
    -   [x]  Input is validated to be divisible by 1,000 KRW.
    -   [x]  Re-prompt the user for input on invalid input (one retry).

-   [x]  Lotto Ticket Generation
    -   [x]  The program issues the correct number of Lotto tickets based on the purchase amount (1,000 KRW per ticket).
    -   [x]  Each Lotto ticket contains 6 unique random numbers.
    -   [x]  Numbers are within the range of 1 to 45.

-   [x]  Winning Numbers and Bonus Number
    -   [x]  The user enters the 6 winning numbers.
    -   [x]  Input is validated as 6 unique integers.
    -   [x]  Numbers are within the range of 1 to 45.
    -   [x]  The user enters the bonus number.
    -   [x]  Input is validated as a single integer.
    -   [x]  Number is within the range of 1 to 45.
    -   [x]  Bonus number is different from the winning numbers.
    -   [x]  Re-prompt the user for input on invalid input (one retry).

-   [x]  Prize Determination
    -   [x]  The program compares the user's Lotto tickets to the winning numbers and bonus number.
    -   [x]  The program determines the prize rank for each Lotto ticket based on the matching numbers:
        -   1st Prize: 6 matching numbers (2,000,000,000 KRW)
        -   2nd Prize: 5 matching numbers + bonus number (30,000,000 KRW)
        -   3rd Prize: 5 matching numbers (1,500,000 KRW)
        -   4th Prize: 4 matching numbers (50,000 KRW)
        -   5th Prize: 3 matching numbers (5,000 KRW)

-   [x]  Results Output
    -   [x]  The program displays the number of tickets purchased.
    -   [x]  The program displays the numbers of each purchased ticket.
    -   [x]  The program displays the winning statistics:
        -   Number of tickets for each prize rank.
    -   [x]  The program calculates and displays the total return rate (profit rate) rounded to one decimal place.

-   [x]  Exception Handling
    -   [x]  The program throws `IllegalArgumentException` for invalid user input.
    -   [x]  The program handles only `IllegalArgumentException`.
    -   [x]  Error messages start with "[ERROR]".
    -   [x]  The program re-prompts the user for input on invalid input (one retry).

## Tests

### `ApplicationTest`

* [x]  `feature test`
    * [x]  Verifies the main application logic with a specific scenario:
        * Correct number of tickets purchased.
        * Correct ticket numbers are generated.
        * Correct winning statistics are calculated and displayed.
        * Correct profit rate is calculated and displayed.
* [x] `exception on invalid purchase amount`
    * [x] Verifies that `IllegalArgumentException` is thrown when the purchase amount is not divisible by 1000.
* [x] `exception on non-numeric purchase amount`
    * [x] Verifies that `IllegalArgumentException` is thrown when the purchase amount is not a number.
* [x] `exception on invalid winning numbers format`
    * [x] Verifies that `IllegalArgumentException` is thrown when the winning numbers input does not contain 6 numbers.
* [x] `exception on non-numeric winning numbers`
    * [x] Verifies that `IllegalArgumentException` is thrown when the winning numbers input contains non-numeric values.
* [x] `exception on invalid bonus number format`
    * [x] Verifies that `IllegalArgumentException` is thrown when the bonus number input is not a number.
* [x] `exception on bonus number out of range`
    * [x] Verifies that `IllegalArgumentException` is thrown when the bonus number is not within the valid range (1-45).
