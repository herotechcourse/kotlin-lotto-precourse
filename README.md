# kotlin-lotto-precourse


Lotto Game_로또 게임
---

This project implements a simple lottery ticket machine using Kotlin.  
Users enter a purchase amount and receive lottery tickets, then input last week's winning numbers and a bonus number.  
The application compares the user's tickets with the winning numbers, prints statistics, and calculates profit rate.

---

## 🚀 Functional Requirements

| #  | Requirement                                                                                             |
|----|--------------------------------------------------------------------------------------------------------|
| 1  | Users enter the purchase amount. 1 ticket is issued per 1,000 KRW.                                    |
| 2  | Each ticket consists of 6 unique random numbers in the range 1 to 45.                                  |
| 3  | After ticket issuance, users input 6 winning numbers and 1 bonus number.                               |
| 4  | The application compares each ticket to the winning numbers.                                           |
| 5  | Based on the number of matches, the app classifies each ticket into prize tiers (1st to 5th).          |
| 6  | Prints the total count per prize tier and calculates the profit rate.                                  |
| 7  | Invalid inputs trigger `IllegalArgumentException` with an error message starting with `[ERROR]`.       |

---

## 🖥️ Input/Output Requirements

### Input
- Purchase amount (e.g. `8000`)
- Winning numbers (comma-separated, e.g. `1,2,3,4,5,6`)
- Bonus number (e.g. `7`)

### Output
- Ticket count and ticket numbers (sorted):
    ```
    You have purchased 8 tickets.
    [8, 21, 23, 41, 42, 43]
    [3, 5, 11, 16, 32, 38]
    ...
    ```
- Winning statistics and total return rate:
    ```
    3 Matches (5,000 KRW) – 1 tickets
    4 Matches (50,000 KRW) – 0 tickets
    5 Matches (1,500,000 KRW) – 0 tickets
    5 Matches + Bonus Ball (30,000,000 KRW) – 0 tickets
    6 Matches (2,000,000,000 KRW) – 0 tickets
    Total return rate is 62.5%.
    ```

---

## ✅ Implementation Checklist

| Checklist (EN / KR)                                                                                                         | Done |
|----------------------------------------------------------------------------------------------------------------------------|------|
| Input purchase amount divisible by 1,000<br/>1,000으로 나누어떨어지는 금액 입력                                               | [X]  |
| Generate N tickets based on amount (1 ticket per 1,000 KRW)<br/>금액에 따라 로또 발급                                          | [X]  |
| Each ticket has 6 unique numbers from 1 to 45<br/>각 티켓은 1~45 사이의 중복 없는 6개의 숫자 포함                             | [X]  |
| Sort each ticket’s numbers in ascending order<br/>각 티켓의 번호는 오름차순 정렬                                              | [X]  |
| Input winning numbers (6 unique values) and bonus number<br/>당첨 번호 6개 + 보너스 번호 입력                                  | [X]  |
| Calculate matches for each ticket and determine prize tier<br/>각 티켓의 일치 개수로 당첨 등수 판단                             | [X]  |
| Print count of winning tickets by prize tier<br/>각 등수별 당첨 횟수 출력                                                      | [X]  |
| Calculate and display profit rate<br/>수익률 계산 및 출력                                                                      | [X]  |
| Throw `IllegalArgumentException` on invalid input<br/>잘못된 입력 시 `IllegalArgumentException` 예외 발생 및 재입력 요청       | [X]  |
| Separate constant strings for input and error messages / 입력 및 에러 메시지 상수화 | [X] |
---

## ⚠️ Error Handling

The program must handle invalid inputs gracefully by throwing an IllegalArgumentException and displaying an appropriate error message starting with [ERROR]. The following cases must be handled:
•	The purchase amount is not divisible by 1,000
•	The winning numbers are:
•	Not exactly six numbers
•	Out of the valid range (not between 1 and 45)
•	Not unique (duplicates present)
•	The bonus number:
•	Is out of range (not between 1 and 45)
•	Is duplicated in the winning numbers
•	The input format is invalid (e.g. contains non-numeric characters or wrong delimiters)


### Example error message:

`[ERROR] Lotto numbers must be between 1 and 45.`

In all cases, the program should prompt the user to re-enter the input from the failed step.
