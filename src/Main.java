import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        UserDAO userDAO = new UserDAO();

        while (true) {

            System.out.println("\n===== ONLINE QUIZ APPLICATION =====");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.println("\n===== REGISTER =====");

                    System.out.print("Enter username: ");
                    String username = sc.nextLine();

                    System.out.print("Enter password: ");
                    String password = sc.nextLine();

                    if (userDAO.registerUser(username, password)) {
                        System.out.println("Registration successful!");
                    } else {
                        System.out.println("Registration failed!");
                    }
                    break;

                case 2:
                    System.out.println("\n===== LOGIN =====");

                    System.out.print("Enter username: ");
                    String loginUsername = sc.nextLine();

                    System.out.print("Enter password: ");
                    String loginPassword = sc.nextLine();

                    User user = userDAO.loginUser(
                            loginUsername, loginPassword
                    );

                    if (user != null) {

                        System.out.println("\nLogin successful!");
                        System.out.println("Welcome, " + user.getUsername() + "!");

                        boolean loggedIn = true;

                        while (loggedIn) {

                            System.out.println("\n===== USER MENU =====");
                            System.out.println("1. Start Quiz");
                            System.out.println("2. Quiz History");
                            System.out.println("3. Logout");
                            System.out.print("Enter your choice: ");

                            int userChoice = sc.nextInt();
                            sc.nextLine();

                            switch (userChoice) {

                                case 1:
                                    Quiz quiz = new Quiz(user.getUserId());
                                    quiz.startQuiz();
                                    break;

                                case 2:
                                    ResultDAO resultDAO = new ResultDAO();
                                    resultDAO.getUserResults(user.getUserId());
                                    break;

                                case 3:
                                    System.out.println("Logged out successfully!");
                                    loggedIn = false;
                                    break;

                                default:
                                    System.out.println("Invalid choice!");
                            }
                        }

                    } else {
                        System.out.println("Invalid username or password!");
                    }
                    break;

                case 3:
                    System.out.println(
                            "Thank you for using Online Quiz Application!"
                    );
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}