# kotlin-lotto-precourse

## 1. Input process

### 1. The user enters the purchase amount.

```
Please enter the purchase amount.
8000
```

### 2. The user enters the winning numbers.

- Save separately by comma.

```
Please enter last week's winning numbers.
1,2,3,4,5,6
```

### 3. The user enters the bonus number.

```
Please enter the bonus number.
7
```

## 2. Validation and Exception Handling

1. If the purchase amount is a non-numeric string, negative number, or zero, throw
   an `IllegalArgumentException` and prompt the user to enter the purchase amount again.
2. If the purchase amount is not divisible by 1,000, throw an `IllegalArgumentException` and prompt
   the user to enter the purchase amount again.
3. If any of winning numbers are non-numeric string, or not within the range of 1 to 45, throw
   an `IllegalArgumentException` and prompt the user to enter the winning numbers again.
4. If there are fewer or more than 6 winning numbers, throw an `IllegalArgumentException` and prompt
   the user to enter the winning numbers again.
5. If there are duplicate numbers in the winning numbers, throw an `IllegalArgumentException` and
   prompt the user to enter the winning numbers again.
6. If the bonus number is a non-numeric string or not within the range of 1 to 45, throw an
   `IllegalArgumentException` and prompt the user to enter the bonus number again.
7. If the bonus number duplicates with the winning numbers, throw an `IllegalArgumentException` and
   prompt the user to enter the bonus number again.

## 3. Lotto Simulation

- Compare the numbers on each issued lotto ticket with the winning numbers entered by the user to
  determine how many match: 3 matches, 4 matches, 5 matches, 5 matches + bonus number match, or 6
  matches.
- For each match condition met, increment the count of winning tickets accordingly.

## 4. Print result

### 1. Print issued lotto tickets.

- The count of issued lotto tickets = Purchase amount / 1000.
- Issued lotto numbers - Random values and sorted in ascending order

```
You have purchased 8 tickets.
[8, 21, 23, 41, 42, 43] 
[3, 5, 11, 16, 32, 38] 
[7, 11, 16, 35, 36, 44] 
[1, 8, 11, 31, 41, 42] 
[13, 14, 16, 38, 42, 45] 
[7, 11, 30, 40, 42, 43] 
[2, 13, 22, 32, 38, 45] 
[1, 3, 5, 14, 22, 45]
```

### 2. Print winning statistics.

```
3 Matches (5,000 KRW) - 1 tickets
4 Matches (50,000 KRW) - 0 tickets
5 Matches (1,500,000 KRW) - 0 tickets
5 Matches + Bonus Ball (30,000,000 KRW) - 0 tickets
6 Matches (2,000,000,000 KRW) - 0 tickets
```

### 3. Print profit rate.

- Profit rate = (Total prize amount / Purchase amount) * 100
    - Round the number to the nearest tenth.
- Total prize amount =
  (5,000 * the count of 3 matches tickets) +
  (50,000 * the count of 4 matches tickets) +
  (1,500,000 * the count of 5 matches tickets) +
  (30,000,000 * the count of 5 matches and bonus tickets) +
  (2,000,000,000 * the count of 6 matches tickets)

```
Total return rate is 62.5%.
```

## 5. Test Plan

1. Enter value must numerical characters.
2. Enter value with comma must numerical characters.
3. Throws an exception when non-numerical characters entered.
---
4. Purchase amount must positive and not zero and divisible 1000.
5. Throws an exception when purchase amount is negative or zero or not divisible 1000.
6. Issued ticket's numbers are sorted.
---
7. Create issued tickets by purchased ticket count.
---
8. Lotto number must between 1 and 45 and no duplicates and exactly 6 size.
9. Throws an exception when lotto number is not between 1 and 45.
10. Throws an exception when lotto numbers exceed 6 or less than 6 or contain duplicates.
11. Increases the ticket count of matches when winning the lottery.
---
12. Bonus number must between 1 and 45 and not duplicate with winning numbers.
13. Throws an exception when bonus number is not between 1 and 45 or duplicate with winning numbers.
---
14. IsMatch is true when match count is equals prize value.
15. IsMatch is false when match count is not equals prize value.
16. Update ticket count.
17. Each prize amount is prize amount multiplied by ticket count.
---
18. Increases the five matches prize's ticket count when match count is 5 and has bonus is false.
19. Increases the five matches with bonus prize's ticket count when match count is 5 and has bonus
    is true.
20. Profit rate is total prize amount divided by purchase amount percentage.
---
21. Format int to comma pattern.(#,###)
22. Format double to comma and one decimal pattern.(#,##0.0)
