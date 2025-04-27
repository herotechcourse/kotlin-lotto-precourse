# Lotto

## Description

The Lotto Program is an interactive console-based application that simulates a lottery ticket machine.
Users can purchase lottery tickets, input winning numbers, and calculate their winnings and profit rate based on the results.

## Features

1. **Purchase Lottery Tickets**

    - Accept user input for the purchase amount.
    - Ensure the purchase amount is divisible by 1,000.
    - Calculate the number of tickets the customer can purchase: (1 ticket = 1,000 KRW).

2. **Input Winning Numbers**

    - Accept 6 unique winning numbers from the user.
    - Validate that all numbers are within the range of 1 to 45.
    - Accept a single bonus number.
    - Ensure the winning numbers and bonus number are unique.

3. **Generate Tickets**

    - Issue as many tickets as the customer purchased.
    - Each ticket contains 6 unique random numbers between 1 and 45.

4. **Calculate the Win**

    - Match the user's tickets against the winning numbers and bonus number.
    - Determine the prize rank for each ticket:
     - **1st Prize**: Match 6 numbers (2,000,000,000 KRW).
     - **2nd Prize**: Match 5 numbers + bonus number (30,000,000 KRW).
     - **3rd Prize**: Match 5 numbers (1,500,000 KRW).
     - **4th Prize**: Match 4 numbers (50,000 KRW).
     - **5th Prize**: Match 3 numbers (5,000 KRW).

5. **Display Results**

   - Print the number of tickets issued and their numbers (sorted in ascending order).
   - Display the winning statistics, including the number of tickets for each prize rank.
   - Calculate and display the total profit rate.

## Install Dependencies

1. Download and install the latest JDK from [Oracle](https://www.oracle.com/java/technologies/javase-downloads.html).
2. Install Kotlin:
   - **For Mac**: Run the following command in the terminal:
     ```bash
     brew install kotlin
     ```
   - **For Windows**: Download and install Kotlin from [Kotlin](https://kotlinlang.org/docs/command-line.html).

## How to Run

1. Clone the repository.
2. Navigate to the project directory.

### Build

```bash
./gradlew clean build
```

### Run

```bash
java -cp "build/libs/kotlin-lotto-1.0-SNAPSHOT.jar:libs/mission-utils-1.2.0.jar:libs/kotlin-stdlib-1.9.24.jar" lotto.ApplicationKt
```

### Test

```bash
./gradlew clean test
```

#### Jar dependencies such as `kotlin-stdlib-1.9.24` and `mission-utils-1.2.0` are shipped with this repository in the `libs/` folder.

> ` ./gradlew -q dependencies --configuration runtimeClasspath`
>
> org.jetbrains.kotlin:kotlin-stdlib:1.9.24
>
> - Download the jar from:
>   https://mvnrepository.com/artifact/org.jetbrains.kotlin/kotlin-stdlib/1.9.24
>
> com.github.woowacourse-projects:mission-utils:1.2.0
>
> - The jar can be found locally in the Gradle cache:
>   ` ~/.gradle/caches/modules-2/files-2.1/com.github.woowacourse-projects/mission-utils/1.2.0/`

## Make a Fat Jar to Ship to Production

```bash
mkdir build/temp
cd build/temp
jar -xf ../../libs/mission-utils-1.2.0.jar
jar -xf ../../libs/kotlin-stdlib-1.9.24.jar
jar -xf ../../build/libs/kotlin-lotto-1.0-SNAPSHOT.jar
jar -cfm ../../build/libs/kotlin-lotto-1.0-SNAPSHOT-fat.jar ../../manifest.txt *
cd ../..
```

## Start the Game

```bash
java -jar build/libs/kotlin-lotto-1.0-SNAPSHOT-fat.jar
```
