# Legacy Execution Flow (FDD/TDD)
## Overview
```
1. ConsoleOutput:    Print request message. (purchase amount)
        ↓
2. ConsoleInput:     User enters purchase amount.
        ↓
3. Validation:       Must be >= 1,000, check number format (int, char, ..)
        ↓
4. Make ticket(s):   Generate (nLottery) tickets. (Amount / 1000). 
        ↓
5. ConsoleOutput:    Print Purchased Ticket(s) list.
        ↓
6. ConsoleOutput:    Print request message. (winning number)
        ↓
7. ConsoleInput:     User enters 6 winning main numbers.
        ↓
8. Validation:       Range: 1-45, no duplicates.
        ↓
9. ConsoleOutput:    Print request message. (bonus number)
        ↓
10. ConsoleInput:    User enters winning bonus number.
        ↓
11. Validation:      Range: 1-45, no duplicates.
        ↓
12. Calculation:     Match results by rankd(matchCountByRank) & Profit rate
        ↓
13. ConsoleOutput:   Print result of statistics
        ↓
14. ConsoleOutput:   Print result of profit rate
```

---

## Detail
### 1. ConsoleOutput
- Request the user to enter the purchase amount.
- ex) `Please enter the purchase amount.`

### 2. ConsoleInput
- User enters the purchase amount.
- ex) `3000`

### 3. Validation
- ⛔️Error handling.
    - If input < 1,000
        - `[ERROR] Miminum amout is 1,000.`
            - 🌱 Throw `IllegalArgumentException` || `IllegalStateException`
                - re-prompt input.

### 4. Make ticket(s)
- #### 4-1. Calculate
    - Determine how many tickets can be bought within the budget.
    - Calculate: `nLottery` = purchaseAmount / 1000
    - ex) Input: 5,500 KRW
        - The Number of maximum tickets available for sale: `5ea`

- #### 4-2. Calculate
    - Generate `nLottery` tickets, each with `6` unique numbers in range `1 - 45`.
        - 💭Logic: `Randoms.pickUniqueNumbersInRange(1, 45, 6)`
        - ⛔️Error handling
            - Duplicate: `[ERROR] Each number must be different.`
            - Out of range: `[ERROR] Lotto numbers must be between 1 and 45.`
            - 🌱 Throw `IllegalArgumentException` || `IllegalStateException`
                - re-prompt input if needed.

### 5. ConsoleOutput
- #### 5-1. Shows the nLottery (= the number of tickets issued)
    - ex) You have purchased `3` tickets.

- #### 5-2. Shows each of ticket’s numbers enclosed in square brackets.
    - Sorted in ascending order.
    - ex)
        ```
        [8, 21, 23, 41, 42, 43]
        [3, 5, 11, 16, 32, 38]
        [7, 11, 16, 35, 36, 44]
        ```

### 6. ConsoleOutput
- Request user to enter 6 winning numbers.
- ex) `Please enter last week's winning numbers.`

### 7. ConsoleInput
- Getting 6 main numbers from the userInput.
- ex) `1, 2, 3, 4, 5, 6`

### 8. Validation
- ⛔️Error handling.
    - Duplicate: `[ERROR] Each number must be different.`
    - Out of range: `[ERROR] Lotto numbers must be between 1 and 45.`
    - 🌱 Throw `IllegalArgumentException` || `IllegalStateException`
        - re-prompt input if needed.

### 9. ConsoleOutput
- Request user to enter the single bonus number.
- ex) `Please enter the bonus number.`

### 10. ConsoleInput
- Getting single number from the userInput.
- ex) `7`

### 11. Validation
- ⛔️Error handling.
    - Duplicate: `[ERROR] Each number must be different.`
    - Out of range: `[ERROR] Lotto numbers must be between 1 and 45.`
    - 🌱 Throw `IllegalArgumentException` || `IllegalStateException`
        - re-prompt input if needed.

### 12. Calculate
- #### 12-1. Rank matching
    - Compare (each user ticket number) with (the winning numbers) to determine rank.

- #### 12-2. Store results
    - Count how many tickets match with each prize category and store it.

- #### 12-3. Calculate profit rate.
    - Formula: `Total amount of prize money / Total purchase amount`
        - ex) 50,000 KRW / 10,000 KRW (10ea) * 100 == 500%
    - Round to the second decimal place and display to first decimal place.
        - ex) `51.66 -> 51.7%`

### 13. ConsoleOutput
- Display the result of statistics.
- How many lottery were won.
- ex)
    ```
    “Winning Statistics”
    “---“
    3 Matches (5,000 KRW) - ? ticket
    4 Matches (50,000 KRW) - ? tickets
    5 Matches (1,500,000 KRW) - ? tickets
    5 Matches + Bonus Ball (30,000,000 KRW) - ? tickets
    6 Matches (2,000,000,000 KRW) - ? tickets
    ```
- ⚠️ To maintain the condition, max function lines is 10, let's make the result value a constant.

### 14. ConsoleOutput
- Display the profit rate with given sentence together.
- ex) `Total return rate is 62.5%.`