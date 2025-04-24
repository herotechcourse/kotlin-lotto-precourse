# kotlin-lotto-precourse

## 🧾 Feature List

### 1️⃣ Lotto Purchase

- [ ] The user can enter the purchase amount
- [x] One ticket is issued for every 1,000 KRW
- [x] If the amount is not divisible by 1,000, throw an exception
- [x] Throw exception if amount is 0 or negative

### 2️⃣ Lotto Number Generation

- [ ] Each ticket must contain 6 unique random numbers

  → Random numbers Generation (Randoms.pickUniqueNumbersInRange)

- [x] Numbers must be integers between 1 and 45

- [x] Throw exception if numbers are duplicated or the count is not exactly 6  
  → `Lotto` class validation logic implemented and tested

### 3️⃣ Winning Numbers Input

- [ ] The user inputs 6 winning numbers from the previous week
- [ ] The user inputs one bonus number
- [ ] The bonus number must not be duplicated with winning numbers

### 4️⃣ Result Check

- [ ] Determine the prize rank based on the number of matching numbers
- [ ] 3 or more matches qualify for a prize
- [ ] 2nd prize is for 5 matches + the bonus number
- [ ] Calculate profit rate = (Total Winnings / Purchase Amount) * 100.0

### 5️⃣ Exception Handling

- [x] If numbers are duplicated, out of range, or incorrect in count, throw an `IllegalArgumentException`

   → ✅`Lotto` class: duplicates, invalid count, out-of-range numbers

   → ✅ `Money` class: zero, negative, or not divisible by 1000

- [ ] All error messages must start with `[ERROR]`  
  → ✅ Exception validation added,  Message prefix application remaining
