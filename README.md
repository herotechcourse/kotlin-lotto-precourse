# Lotto

A Kotlin console-based Lotto simulator.

Users can purchase lottery tickets, input winning and bonus numbers, and view their match statistics and total profit rate.

## Features

- Accept purchase amount input and issue the correct number of lottery tickets (1 ticket per 1,000 KRW).
- Generate each lottery ticket with 6 unique random numbers between 1 and 45.
- Accept winning numbers and a bonus number input from the user.
- Validate that all numbers are within the valid range (1–45) and are unique.
- Compare user tickets with winning numbers and determine prize ranks.
- Display lottery statistics, including the number of matches per prize tier.
- Calculate and display the total return (profit) rate, rounded to one decimal place.
- Handle invalid inputs with appropriate error messages starting with "[ERROR]".

> Note: This feature list may be updated as development progresses and edge cases are identified.