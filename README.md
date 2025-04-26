# 💶 Lotto

A simple lottery ticket machine application.

### 📖 Overview

The Lotto application follows these steps:
1. Enter the `purchase amount`.
2. Generate lotto tickets based on the purchase amount.
3. Enter the `winning numbers` and the `bonus number`.
4. Display the `winning results` and the `return rate`.

<image width="500" src="https://github.com/user-attachments/assets/0a79d88b-4b4e-47f2-9daf-d090108815f5">

## ✨ Features

### 🎟️ Purchase Lotto Tickets

- Purchase lotto tickets based on the input amount.
- Each ticket contains 6 unique random numbers between 1 and 45.
- Each ticket costs 1,000.

<image width="500" src="https://github.com/user-attachments/assets/5a769fca-4030-4cff-9ed8-a798ba6c4cf1">

### 🏆 Check Winning Statistics

- Compare your tickets against the winning numbers and bonus number.
- View the result statistics based on your matches.

<image width="500" src="https://github.com/user-attachments/assets/a0d9fe81-278b-4d90-a8df-f191c0f9692a">

## 🧪 Edge Cases

### Purchase amount

- Validate that the purchase amount is a positive integer.
- Validate that the purchase amount is a multiple of 1,000.

<image width="500" src="https://github.com/user-attachments/assets/752e99b7-ead4-4411-9fe1-ae1c558e5070">

### Winning numbers

- Validate that input values are separated by commas (",").
- Validate that exactly 6 numbers are entered.
- Validate that all numbers are between 1 and 45.
- Validate that all numbers are unique (no duplicates).

<image width="500" src="https://github.com/user-attachments/assets/c1658d23-8fbd-4269-80be-e0ab20bca0fb">

### Bonus number

- Validate that the bonus number is between 1 and 45.
- Validate that the bonus number is not duplicated in the winning numbers.

<image width="500" src="https://github.com/user-attachments/assets/deefb9fc-1d36-4a29-a9ad-f6eed8697595">

### Exit Program

- Handle the case where users enter "EXIT" to terminate input early.

<image width="500" src="https://github.com/user-attachments/assets/1e220dec-2a16-4e62-93c7-6435c5cbf442">

## 🚀 How to Run

1. Clone the repository.
2. Build and run the project using your preferred Kotlin environment.
3. Follow the console prompts to purchase tickets and check results.
