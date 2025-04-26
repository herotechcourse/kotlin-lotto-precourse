# kotlin-lotto-precourse

## Features

### 1. Purchase Amount Input
- [ ] Each ticket costs 1,000 KRW, so the amount must be divisible by 1,000
  - [ ] if can't divisable by 1,000 -> IllegalArgumentException

### 2. Lotto Issuance
- [ ] 6 unique random numbers (range of # : 1 ~ 45)

### 3. Winning Number Input
- [ ] input only 6 unique numbers (range of # : 1 ~ 45)
    - [ ] if not 6 numbers -> IllegalArgumentException
    - [ ] if not 1 ~ 45 number -> IllegalArgumentException
    - [ ] if not unique numbers -> IllegalArgumentException

### 4. Bonus Number Input
- [ ] input only 1 unique bonus numbers (range of # : 1 ~ 45)
    - [ ] if not single number -> IllegalArgumentException
    - [ ] if not 1 ~ 45 number -> IllegalArgumentException
    - [ ] if not unique number -> IllegalArgumentException

### 5. Show Result
- 1st Prize: Match 6 numbers / 2,000,000,000 KRW
- 2nd Prize: Match 5 numbers + bonus number / 30,000,000 KRW
- 3rd Prize: Match 5 numbers / 1,500,000 KRW
- 4th Prize: Match 4 numbers / 50,000 KRW
- 5th Prize: Match 3 numbers / 5,000 KRW

- [ ] calculate total winning amount
- [ ] calculate and display the profit rate
