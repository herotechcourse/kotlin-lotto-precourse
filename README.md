Lotto Program
This is a simple Lotto ticket machine program written in Kotlin.
It asks the user for a purchase amount, generates lotto tickets, asks for the winning numbers, and calculates the result and profit.

✅ Features to Implement
Read the purchase amount from the user

Generate multiple lotto tickets (each ticket = 6 unique numbers between 1 to 45)

Show the user the generated tickets

Read last week's winning numbers from the user

Read the bonus number from the user

Compare the tickets with winning numbers and bonus number

Calculate how many tickets win which prize

Calculate and print the total profit rate

Handle invalid inputs properly (showing [ERROR] messages)

🏗️ Project Structure
css
Copy
Edit
src
┣ main
┃ ┣ kotlin
┃ ┃ ┣ lotto
┃ ┃ ┃ ┣ Application.kt
┃ ┃ ┃ ┣ Lotto.kt
┃ ┃ ┃ ┣ LottoTicket.kt
┃ ┃ ┃ ┣ LottoMachine.kt
┃ ┃ ┃ ┣ InputView.kt
┃ ┃ ┃ ┣ OutputView.kt
┃ ┃ ┃ ┣ Result.kt
┃ ┃ ┃ ┣ Rank.kt
┣ test
┃ ┣ kotlin
┃ ┃ ┣ lotto
┃ ┃ ┃ ┣ LottoMachineTest.kt
┃ ┃ ┃ ┣ ResultTest.kt
⚙️ How to Run
Make sure you are using:

Kotlin 1.9.24

IntelliJ IDEA (or other compatible IDE)

Steps:

Run main() function inside Application.kt

Follow the prompts in the console.

📋 Rules Followed
Kotlin Coding Conventions (2 indent levels, max 10 lines per function)

No external libraries were added

Used only Randoms and Console from camp.nextstep.edu.missionutils

No System.exit() or exitProcess()

Business logic and UI logic are separated

🧪 Testing
Tests are written with:

JUnit 5

AssertJ

How to run tests:

bash
Copy
Edit
./gradlew clean test    # macOS/Linux
gradlew.bat clean test  # Windows
You should see:

bash
Copy
Edit
BUILD SUCCESSFUL
📌 Notes
If the input is wrong, an [ERROR] message is shown and the program asks again.

Bonus number must be different from winning numbers.

Profit rate is printed rounded to one decimal place.

🎯 Example Program Flow
yaml
Copy
Edit
Please enter the purchase amount.
8000

You have purchased 8 tickets.
[8, 21, 23, 41, 42, 43]
[3, 5, 11, 16, 32, 38]
[7, 11, 16, 35, 36, 44]
[1, 8, 11, 31, 41, 42]
[13, 14, 16, 38, 42, 45]
[7, 11, 30, 40, 42, 43]
[2, 13, 22, 32, 38, 45]
[1, 3, 5, 14, 22, 45]

Please enter last week's winning numbers.
1,2,3,4,5,6

Please enter the bonus number.
7

Winning Statistics
---
3 Matches (5,000 KRW) – 1 tickets
4 Matches (50,000 KRW) – 0 tickets
5 Matches (1,500,000 KRW) – 0 tickets
5 Matches + Bonus Ball (30,000,000 KRW) – 0 tickets
6 Matches (2,000,000,000 KRW) – 0 tickets
Total return rate is 62.5%.
