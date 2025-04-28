# kotlin-lotto-precourse

# Features

### 1. Input - Purchase amount

**View**
* Print info text
* Get the Purchase amount
* After the logic, show how many lotteries are issued

**Logic**
* Make input values into a number
* Get lottery tickets as the budget allows (ticket = 1000)

  ex. If the budget can't be divisible by 1000 (4323, 2400) <br/>
  -> issue only 4323 => 4, 2400 => 2

**Error cases**
1. The budget must be at least 1000
2. Only accept `Number`
3. Handle the empty input case

### 2. Output - Issues tickets

**View**
* Number of tickets issued and their numbers (sorted in ascending order)

**Logic**
* Repeat with the lottery counts
* Get 6 random numbers in the range 1-45

### 3. Input - Winning numbers and bonus number

**View**
* The user enters the winning numbers

**Logic**
* Validate input value
* Transition input value to Number[] : make 6 number list by comma-separated

**Error cases**
1. Numbers must be in the range 1-45
2. Winning number
  - The user enters numbers(comma-separated)
  - Only accept `Number`
  - No duplicates allowed

### 4. Output - The result of lotteries

**View**
1. Print the result of lottery
```
3 Matches (5,000 KRW) – 1 tickets
4 Matches (50,000 KRW) – 0 tickets
5 Matches (1,500,000 KRW) – 0 tickets
5 Matches + Bonus Ball (30,000,000 KRW) – 0 tickets
6 Matches (2,000,000,000 KRW) – 0 tickets
```

2. Prints profit rate
```
Total return rate is 62.5%.
```

**Logic**
* winningNumbers size must be 6.
  
1. Logic for matching the lottery
2. Get match counts for each prize
3. Calculate profit rate
4. Process rate to the nearest tenth
