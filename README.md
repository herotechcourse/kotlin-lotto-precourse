# kotlin-lotto-precourse

## Lotto Ticketing Machine Program

This is a Lotto ticketing machine program. When a purchase amount is entered, you can buy as many Lotto tickets as the amount allows.  
After entering the winning numbers and the bonus number, you can check the winning results among the purchased tickets and calculate the return on investment.

**Please enter the purchase amount, 1st place winning numbers, and bonus number.**

---

### ✅ Valid Input Requirements

#### 💰 Purchase Amount
- Each Lotto ticket costs 1,000 KRW. Please enter the amount in units of 1,000 KRW.
- The maximum purchase amount is 100,000 KRW.
- Only numeric input is allowed.

#### 🎯 Winning Numbers Input
- There must be exactly 6 winning numbers.
- Numbers must be separated by commas (e.g., `1,2,3,4,5,6`).
- Numbers must be within the range 1 to 45.

#### ➕ Bonus Number Input
- Bonus number must also be within the range 1 to 45.
- Only numeric input is allowed.

---

### ❗ Exception Handling Cases

#### 💰 Purchase Amount
- Input is empty
- Input includes non-numeric characters
- Amount exceeds 100,000 KRW
- Input exceeds the `int` range
- Input is not divisible by 1,000 KRW

#### 🎯 Winning Numbers
- Input is empty
- Input includes characters other than numbers and commas
- More than 6 numbers are entered
- One or more numbers are not in the 1–45 range
- Duplicate numbers are present

#### ➕ Bonus Number
- Input is empty
- Input includes non-numeric characters
- Number is not in the 1–45 range
- Bonus number is duplicated in the winning numbers

---

## ✅ Feature Checklist

### 🧾 User Input
- [x] Receive purchase amount input
- [x] Receive winning numbers input
- [x] Receive bonus number input

### 🔍 Purchase Amount Validation
- [x] Check if purchase amount input is empty; throw exception if so
- [x] Validate that input contains only numbers; throw exception otherwise
- [x] Throw exception if amount exceeds 100,000 KRW
- [x] Throw exception if amount is zero
- [x] Throw exception if amount is not divisible by 1,000
- [x] If an exception occurs, prompt input again

### ➗ Ticket Quantity Calculation
- [x] Calculate number of tickets based on the purchase amount

### 🔎 Winning Numbers Validation
- [x] Check if input is empty; throw exception if so
- [x] Validate that input only contains numbers and commas; throw exception otherwise
- [x] Check if exactly 6 numbers are provided; throw exception otherwise
- [x] Throw exception if any number is outside the 1–45 range
- [x] Throw exception if duplicates exist
- [x] If an exception occurs, prompt input again

### 🧮 Bonus Number Validation
- [x] Check if input is empty; throw exception if so
- [x] Validate that input contains only numbers; throw exception otherwise
- [x] Throw exception if number is outside 1–45 range
- [x] Throw exception if it duplicates any winning number
- [x] If an exception occurs, prompt input again

### 🎟️ Lotto Purchase
- [x] Calculate quantity from purchase amount
- [x] Generate a set of 6 unique random numbers for each ticket
- [x] Sort each ticket's numbers in ascending order
- [x] Print generated Lotto numbers

### 📝 Store Winning Numbers
- [x] Store entered winning numbers
- [x] Store bonus number

### 📊 Winning Statistics
- [x] Compare purchased tickets against winning numbers to compute statistics
- [x] Calculate total prize amount
- [x] Calculate return rate based on total winnings and purchase amount
- [x] Round return rate to two decimal places

### 🖨️ Output
- [x] Print "Please enter purchase amount"
- [x] Print number of tickets purchased (e.g., "%d tickets purchased.")
- [x] Print "Please enter the winning numbers."
- [x] Print "Please enter the bonus number."
- [x] Print "Winning Statistics"
- [x] Print "---"
- [x] Print winning statistics details
- [x] Print return rate
