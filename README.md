# kotlin-lotto-precourse

## 🧾 Feature List

### 1️⃣ Lotto Purchase

- [x] The user can enter the purchase amount
- [x] One ticket is issued for every 1,000 KRW
- [x] If the amount is not divisible by 1,000, throw an exception
- [x] Throw exception if amount is 0 or negative

### 2️⃣ Lotto Number Generation

- [x] Each ticket must contain 6 unique random numbers

  → Random numbers Generation (Randoms.pickUniqueNumbersInRange)

- [x] Numbers must be integers between 1 and 45

- [x] Throw exception if numbers are duplicated or the count is not exactly 6  
  → `Lotto` class validation logic implemented and tested

### 3️⃣ Winning Numbers Input

- [x] The user inputs 6 winning numbers from the previous week
- [x] The user inputs one bonus number
- [x] The bonus number must not be duplicated with winning numbers
- [x] Validate 6 winning numbers: count, duplicates, range
- [x] BonusNumber class also performs validation to protect domain integrity (domain layer, **SRP**)

### 4️⃣ Result Check

- [x] Determine the prize rank based on the number of matching numbers
- [x] 3 or more matches qualify for a prize
- [x] 2nd prize is for 5 matches + the bonus number
- [ ] Calculate profit rate = (Total Winnings / Purchase Amount) * 100.0

### 5️⃣ Exception Handling

- [x] If numbers are duplicated, out of range, or incorrect in count, throw an `IllegalArgumentException`

   → ✅`Lotto` class: duplicates, invalid count, out-of-range numbers

   → ✅ `Money` class: zero, negative, or not divisible by 1000

   → ✅ `InputValidator` class: non-numeric input, bonus duplication, invalid count/range

   → ✅ `WinningNumber` class: duplicates, invalid count, out-of-range numbers

   → ✅ `BonusNumber` class : out-of-range numbers,  duplicates

- [ ] All error messages must start with `[ERROR]`  
  → ✅ Exception validation added,  Message prefix application remaining

### 🔍 Test Coverage

- [x] Lotto class validation
- [x] Money class validation
- [x] Input validation (InputView + InputValidator)
- [x] WinningNumber validation
- [x] WinningNumber.match() → Retrun Rank
- [ ] WinningResult → Rank-wise statistics test
