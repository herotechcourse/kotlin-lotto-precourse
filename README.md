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
- [ ] Lotto util (lotto simulator utility functions)
- [ ] Error message (include sysytem error messages)

### Model

- [ ] Lotto machine (lotto seller and simulator)
- [ ] Money (contain purchase amount)
- [ ] Prize (prize details by lotto ranking)
- [ ] Rank (lotto rank enum)
- [ ] Winner (contain winning numbers and bonus number)

### View

- [ ] Read input
  - [ ] Safe Read
- [ ] Print output
  - [ ] Print result

### Controller

- [ ] Lotto controller (main controller class that orchestrates the flow of the lottery application.)