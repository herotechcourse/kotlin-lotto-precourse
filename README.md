# kotlin-lotto-precourse

## Summary

This project is Lottery Simulator.
you can buy tickets and choose winning numbers then simulator show lottery result.

## How to Play?

1. Input purchase amount (more than 1000)
2. Input winning numbers, each number must be between 1 and 45
3. Input bonus number, number must be between 1 and 45
4. Lottery simulator show result

## Prize Tiers

| Match | Condition       | Prize             |
| ----- | --------------- | ----------------- |
| 6     | Matches         | 2,000,000,000 KRW |
| 5     | Matches + Bonus | 30,000,000 KRW    |
| 5     | Matches         | 1,500,000 KRW     |
| 4     | Matches         | 50,000 KRW        |
| 3     | Matches         | 5,000 KRW         |

## Features

### Common

- [x] Parser (input parser)
- [x] Lotto util (lotto simulator utility functions)
- [x] Error message (include sysytem error messages)

### Model

- [x] Lotto machine (lotto seller and simulator)
- [x] Money (contain purchase amount)
- [x] Prize (prize details by lotto ranking)
- [x] Rank (lotto rank enum)
- [x] Winner (contain winning numbers and bonus number)

### View

- [x] Read input
  - [x] Safe Read
- [x] Print output
  - [x] Print result

### Controller

- [x] Lotto controller (main controller class that orchestrates the flow of the lottery application.)

## Test

### Parser Test

#### ToInt Function Tests

- **Valid input conversion**: Confirms that valid numeric strings are correctly converted to integers
- **Non-numeric input handling**: Verifies that an exception is thrown when attempting to parse non-numeric text
- **Empty string handling**: Ensures an appropriate exception is thrown when an empty string is provided

#### ToIntList Function Tests

- **Valid comma-separated values**: Verifies that strings with comma-separated numbers are correctly converted to integer lists
- **Whitespace handling**: Confirms that the parser handles inputs with extra spaces around the numbers
- **Invalid value detection**: Ensures that exceptions are thrown when any value in the list is non-numeric
- **Empty string handling**: Verifies that empty strings are properly rejected with an exception

### Money Test

#### MoneyCreationTest

Tests the creation of Money objects:

- **createMoneyWithValidAmount**: Verifies Money objects can be created with valid amounts
- **throwExceptionWhenAmountIsNull**: Ensures exception is thrown when amount is null
- **throwExceptionWhenAmountIsLessThanMinimum**: Confirms exception is thrown for amounts below 1000

#### MoneyBehaviorTest 

Tests the behavior of Money objects:

- **getAmountShouldReturnCorrectValue**: Verifies the getter returns the correct amount
- **shouldAllowMaximumValidAmount**: Ensures the class handles the maximum integer value

#### Key Validations

- Money cannot be created with null values
- Money amount must be at least 1000
- Money objects correctly store and return their amount values

### Prize Test

#### Constructor Tests

- Validates that the constructor throws an exception when given a negative match count
- Ensures the constructor accepts valid match counts (0-6)

#### getRank Method Tests

- Validates correct rank determination based on match count and bonus ball status:
  - FIRST rank: 6 matches
  - SECOND rank: 5 matches with bonus ball
  - THIRD rank: 5 matches without bonus ball
  - FOURTH rank: 4 matches
  - FIFTH rank: 3 matches
  - NONE rank: 0-2 matches

#### getReward Method Tests

- Confirms that the correct prize amount is returned for each rank:
  - Validates rewards for all ranks from FIRST to NONE
  - Ensures different rewards for 5 matches with/without bonus ball

### Winner Test

#### Constructor Validation Tests

These tests verify that the `Winner` constructor properly validates its input parameters:

- Ensures that a valid list of numbers and bonus number can create a Winner instance
- Verifies exceptions are thrown for the following invalid inputs:
  - Empty numbers list
  - Numbers list with incorrect size (not 6 numbers)
  - Numbers outside the valid range (1-45)
  - Duplicate numbers in the list
  - Bonus number outside valid range (1-45)
  - Bonus number that appears in the winning numbers list

## Methods Tests

These tests verify the behavior of the `Winner` class methods:

- `getNumbers()` returns the correct list of winning numbers
- `getBonus()` returns the correct bonus number

### Lotto Util Test

### Lotto Machine Test
