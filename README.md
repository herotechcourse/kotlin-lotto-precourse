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