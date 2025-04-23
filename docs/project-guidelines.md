# Project-guidelines

## 🎯 Project goals
1. Member function
    - Put all functions related to a class inside the class.
2. Unit tests
   - Test each class and function by unit.
3. Feedback
   - Actively reflect the given feedback on this project.

---

## ✅ Requirements Checklist

### 🛠️ Process Requirements
1. Fork and clone the repo.
2. Create a feature list in `doc/feature-list.md`.
3. Follow Angular JS commit message convention `feat`, `fix`, …)
   - [Commit Message Guide](https://gist.github.com/stephenparish/9941e89d80e2bc58a153)

---

### 🧑🏻‍💻 Programming Requirements
### Basic Rules
1. Kotlin version: `1.9.24`
2. Language: Kotlin only
3. Entry  point: `main()` in `Application` class
4. ❌ **DO NOT**
   - Modify: build.gradle.kts 
   - Include: external libraries. 
   - Use: System.exit(), exitProcess()
   - Rename or move: files, packages, or other elements.

---

### Code Style & Test
1. Follow [Kotlin coding conventions](https://kotlinlang.org/docs/coding-conventions.html)
2. Max indentation: 2 levels
3. Test: `./gradlew clean test` (Using JUnit5 & AssertJ)

---

### Basic (3)
1. SRP (Single Responsibility Principle): One function should do one thing.
2. Max `10` lines per function.
3. Prefer `early return` than `else`.
4. Use `Enum` classes for values like `Rank` (avoid hard-coding)
5. Separate service logic from UI logic.
    - **Service logic**: ex) calculate, validate, make ticket.
    - **UI logic**: ex) readline(), println()
6. Write unit tests for logics, excluding UI logics (System.out, System.in)

---

### API Reference
1. `Randoms.pickUniqueNumbersInRange()`
   - From: camp.nextstep.edu.missionutils.Randoms.
   - Ex:
        ```
        Randoms.pickUniqueNumbersInRange(1, 45, 6)
        ```
2. `Console.readLine()`
   - From: camp.nextstep.edu.missionutils.Console.

---

### Lotto Class
1. Use the provided `Lotto` class.
2. Only `numbers` field allowed; It must be private.
3. Keep in the `lotto` package.
   ```
   src/
   └── lotto/
   └── Lotto.kt
   ```
4. if `numbers.size > 6` 
   - throw: Error.
5. Only allow to add method
- Can't add any `var` or `val`.
    ```
    package lotto
    
    class Lotto(private val numbers: List<Int>) {
        init {
            require(numbers.size == 6) { "[ERROR] Lotto must contain exactly 6 numbers." }
        }

        // TODO: Implement additional functions
    }
    ```