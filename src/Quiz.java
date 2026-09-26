import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Quiz {

    private List<Question> questions;
    private int userId;

    public Quiz(int userId) {
        this.userId = userId;

        QuestionDAO questionDAO = new QuestionDAO();
        questions = questionDAO.getAllQuestions();
    }

    public void startQuiz() {

        Scanner sc = new Scanner(System.in);

        if (questions == null || questions.isEmpty()) {
            System.out.println("No questions available!");
            return;
        }

        int totalQuestions = questions.size();

        // Store answers selected by the user
        List<String> answers = new ArrayList<>();

        for (int i = 0; i < totalQuestions; i++) {
            answers.add("");
        }

        int currentQuestion = 0;

        System.out.println("\n===== JAVA QUIZ =====");
        System.out.println("Total Questions: " + totalQuestions);

        while (true) {

            Question q = questions.get(currentQuestion);

            System.out.println("\n--------------------------------");
            System.out.println("Question " + (currentQuestion + 1)
                    + " of " + totalQuestions);
            System.out.println("--------------------------------");

            System.out.println(q.getQuestionText());

            System.out.println("A. " + q.getOptionA());
            System.out.println("B. " + q.getOptionB());
            System.out.println("C. " + q.getOptionC());
            System.out.println("D. " + q.getOptionD());

            // Display previously selected answer
            if (!answers.get(currentQuestion).isEmpty()) {
                System.out.println(
                        "Your Answer: " + answers.get(currentQuestion)
                );
            } else {
                System.out.println("Your Answer: Not answered");
            }

            System.out.println("\n1. Select Answer");
            System.out.println("2. Previous Question");
            System.out.println("3. Next Question");
            System.out.println("4. Submit Quiz");

            System.out.print("Enter your choice: ");
            String choice = sc.nextLine().trim();

            switch (choice) {

                case "1":

                    System.out.print("Enter answer (A/B/C/D): ");
                    String answer = sc.nextLine().trim().toUpperCase();

                    if (answer.equals("A") || answer.equals("B")
                            || answer.equals("C") || answer.equals("D")) {

                        answers.set(currentQuestion, answer);
                        System.out.println("Answer saved!");

                    } else {
                        System.out.println(
                                "Invalid answer! Enter A, B, C, or D."
                        );
                    }

                    break;

                case "2":

                    if (currentQuestion > 0) {
                        currentQuestion--;
                    } else {
                        System.out.println("This is the first question!");
                    }

                    break;

                case "3":

                    if (currentQuestion < totalQuestions - 1) {
                        currentQuestion++;
                    } else {
                        System.out.println("This is the last question!");
                    }

                    break;

                case "4":

                    System.out.print(
                            "Are you sure you want to submit? (Y/N): "
                    );

                    String confirm = sc.nextLine().trim().toUpperCase();

                    if (confirm.equals("Y")) {

                        int score = 0;
                        int correct = 0;
                        int wrong = 0;

                        for (int i = 0; i < totalQuestions; i++) {

                            String userAnswer = answers.get(i);
                            String correctAnswer =
                                    questions.get(i).getCorrectAnswer();

                            if (userAnswer.equalsIgnoreCase(correctAnswer)) {
                                score++;
                                correct++;
                            } else {
                                wrong++;
                            }
                        }

                        double percentage =
                                ((double) score / totalQuestions) * 100;

                        String resultStatus;

                        if (percentage >= 50) {
                            resultStatus = "PASS";
                        } else {
                            resultStatus = "FAIL";
                        }

                        System.out.println("\n===== QUIZ RESULT =====");
                        System.out.println(
                                "Total Questions : " + totalQuestions
                        );
                        System.out.println(
                                "Correct Answers : " + correct
                        );
                        System.out.println(
                                "Wrong Answers   : " + wrong
                        );
                        System.out.println(
                                "Score           : " + score
                        );
                        System.out.printf(
                                "Percentage      : %.2f%%%n", percentage
                        );
                        System.out.println(
                                "Result          : " + resultStatus
                        );

                        // Save result to database
                        ResultDAO resultDAO = new ResultDAO();

                        resultDAO.saveResult(
                                userId,
                                totalQuestions,
                                correct,
                                wrong,
                                score,
                                percentage,
                                resultStatus
                        );

                        return;

                    } else {
                        System.out.println("Submission cancelled!");
                    }

                    break;

                default:

                    System.out.println("Invalid choice! Try again.");
            }
        }
    }
}