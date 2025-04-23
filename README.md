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

## 3. Lotto Draw Process

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

- If the count of winning tickets is 1, use 'ticket'. If it is 0 or greater than 1, use 'tickets'.

```
3 Matches (5,000 KRW) - 1 ticket
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
