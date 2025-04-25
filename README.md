# kotlin-lotto-precourse

# 🎯 Lotto (Hero Tech Pre-Course Mission)

## ✅ Feature Checklist

### 📥 Input

- [ ] Input amount of money to purchase lottery tickets
- [ ] Input last week's winning numbers (comma-separated)
- [ ] Input bonus number (single number)

---

### 🎮 Lotto Generation

- [ ] Generate lotto tickets based on amount (1,000 KRW per ticket)
- [ ] Each ticket contains 6 unique numbers in the range 1–45
- [ ] Sort numbers in each ticket in ascending order

---

### 🏆 Winning Result Evaluation

- [ ] Compare each ticket with winning numbers and bonus number
- [ ] Determine the prize rank (1st ~ 5th or no prize)
- [ ] Count the number of winning tickets per rank
- [ ] Calculate and display total winnings
- [ ] Calculate and display profit rate (percentage, rounded to first decimal)

---

### 🖨 Output

- [ ] Print number of purchased tickets and their numbers
- [ ] Print winning statistics by rank
- [ ] Print total profit rate

---

## 🛠 Fix / TODO

### 🚫 Validation

- [ ] Validate purchase amount (must be numeric, ≥ 1000, divisible by 1000)
- [ ] Validate winning numbers (6 unique numbers, 1–45)
- [ ] Validate bonus number (1–45, not duplicated with winning numbers)
- [ ] Throw `IllegalArgumentException` for invalid input and re-prompt user
- [ ] All error messages start with `[ERROR]`

---

### 🧪 Testing

- [ ] Add unit tests for Lotto number validation
- [ ] Add unit tests for prize matching logic
- [ ] Add unit tests for profit rate calculation
- [ ] Add unit tests for Lotto class (ensures 6 unique numbers between 1–45)

---