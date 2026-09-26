# Online Quiz Application

## About the Project

The Online Quiz Application is a Java-based application that allows users to register, log in, participate in quizzes, and view their results.

The application displays multiple-choice questions and allows users to navigate between questions, select answers, and submit the quiz. The final score and performance are calculated instantly and stored in a MySQL database.

## Features

- User Registration and Login
- Multiple-Choice Questions (MCQs)
- Four Options for Each Question
- Previous and Next Question Navigation
- Answer Selection and Submission
- Automatic Score Calculation
- Correct and Wrong Answer Tracking
- Percentage Calculation
- PASS/FAIL Result Status
- Quiz History
- MySQL Database Integration

## Technologies Used

- Java (Core Java)
- JDBC
- MySQL
- VS Code
- MySQL Connector/J

## Project Structure

OnlineQuizApplication/
├── database/
│   └── quiz_database.sql
├── lib/
│   └── mysql-connector-j-26.7.0.jar
├── src/
│   ├── Main.java
│   ├── DBConnection.java
│   ├── User.java
│   ├── UserDAO.java
│   ├── Question.java
│   ├── QuestionDAO.java
│   ├── Quiz.java
│   └── ResultDAO.java
└── README.md

## Requirements

- Java JDK
- MySQL Server
- MySQL Workbench (optional)
- VS Code or any Java IDE

## Database Setup

1. Open MySQL Workbench.
2. Open the `database/quiz_database.sql` file.
3. Execute the SQL script to create the database and tables.
4. Ensure that the database is created successfully.

## Database Connection

1. Open `src/DBConnection.java`.
2. Update the database username and password according to your MySQL configuration.
3. Make sure the database name and connection URL match your setup.

## How to Run

Open the terminal in the project folder.

### Step 1: Compile the Java Files

```bash
javac -cp "lib/mysql-connector-j-26.7.0.jar" -d out src/*.java
````

### Step 2: Run the Application

On Windows PowerShell:

```
```

```
java -cp "out;lib/mysql-connector-j-26.7.0.jar" Main
```

## How to Use

1.  Register a new user account. 
2.  Log in using your credentials. 
3.  Select Start Quiz. 
4.  Answer the multiple-choice questions. 
5.  Use Previous and Next to navigate between questions. 
6.  Submit the quiz to view your results. 
7.  View your quiz history from the user menu. 

## Result System

After submitting the quiz, the application displays:

-  Total Questions 
-  Correct Answers 
-  Wrong Answers 
-  Score 
-  Percentage 
-  PASS/FAIL Status 

The quiz result is saved in the MySQL database.

## Author

M. Nathiya

## GitHub Repository

[https://github.com/ramashanmugi-v/Online-Quiz-Application](https://github.com/ramashanmugi-v/Online-Quiz-Application)

```
```

````

### 5.3 Save Pannu

`Ctrl + S` press pannu da.

**README.md file create aagidum.** ✅

---

## STEP 6: GitHub-la README Upload Pannu

VS Code Terminal-la indha commands order-ah run pannu:

```powershell
git add README.md
````

```
```

```
git commit -m "Add project README"
```

```
```

```
git push
```

Upload mudinjadhum un GitHub repository open pannu:

Online Quiz Application – GitHub 
