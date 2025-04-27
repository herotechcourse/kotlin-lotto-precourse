# kotlin-lotto-precourse

## feature list
### input handling
- [x] purchase amount
    - [x] validate that purchase amount is divisible by 1,000
    - [x] throw exception if purchase amount is not divisible by 1,000
- [x] 6 winning numbers + 1 bonus number
    - [x] all 7 numbers must be unique in the range from 1 to 45
    - [x] bonus number is a number separate from the winning numbers
### exception handling
- [ ] re-prompt user in case of exceptions
- [ ] start error message with [ERROR]
### lottery ticket machine
- [ ] ticket generation
    - [ ] generate number of tickets based on purchase amount - 1 ticket per 1,000
    - [ ] each ticket consists on 6 random numbers in the range from 1 to 45
- [ ] result generation
    - [ ] compare tickets with winning numbers to calculate winnings - see table below
    - [ ] calculate profit return rate based on winnings
    - [ ] round profit return rate to nearest tenth
### output
- [ ] generated tickets
    - [ ] number of tickets
    - [ ] tickets
        - [ ] numbers must be sorted in ascending order
- [ ] results
    - [ ] matches per prize rank
    - [ ] profit return rate
        - [ ] round profit return rate to nearest tenth



## prize ranks
user wins based on matches
- 1st prize: 6 matching numbers --> 2,000,000,000 KRW
- 2nd prize: 5 matching numbers + bonus number --> 30,000,000 KRW
- 3rd prize: 5 matching numbers --> 1,500,000 KRW
- 4th prize: 4 matching numbers --> 50,000 KRW
- 5th prize: 3 matching numbers --> 5,000 KRW