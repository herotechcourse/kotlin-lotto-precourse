# kotlin-lotto-precourse

## Lotto Machine Project

Implement a lotto machine using Kotlin to handle ticket issuance and check winning results.

## Main Features

1.  Lotto Purchase
2.  Winning Number Input
3.  Winning Result Check

## Feature List

-   Receive lotto purchase amount input
    -   Input must be in units of 1000 KRW.
    -   [Exception] If the input is empty.
    -   [Exception] If the input is not a number.
    -   [Exception] If the input is a negative number.
    -   [Exception] If the input is zero.
    -   [Exception] If the amount is not divisible by 1000.
-   Input Winning Numbers
    -   Numbers are separated by commas.
    -   Numbers must be between 1 and 45.
    -   Numbers must not be duplicated.
    -   [Exception] If the input is empty.
    -   [Exception] If any part is not a number.
    -   [Exception] If the count of numbers is not 6.
    -   [Exception] If any number is not between 1 and 45.
    -   [Exception] If there are duplicate numbers.
-   Input Bonus Number
    -   The number must be between 1 and 45.
    -   The number must not be duplicated with the winning numbers.
    -   [Exception] If the input is empty.
    -   [Exception] If the input is not a number.
    -   [Exception] If the number is not between 1 and 45.
    -   [Exception] If the bonus number duplicates a winning number.
-   Output Winning Results
    -   Do not output statistics for 1 or 2 matches as there is no prize money.
    -   Output statistics starting from 3 matches, as these have prize money.
    -   Calculate the return on investment (total prize money / purchase amount). Round the ROI to one decimal place (e.g., 100.0%, 51.5%, 1,000,000.0%).
-   In case of an exception, an error message must be printed. The error message must start with "[ERROR]".