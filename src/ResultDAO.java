import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ResultDAO {

    // Save Quiz Result
    public boolean saveResult(int userId,
                              int totalQuestions,
                              int correctAnswers,
                              int wrongAnswers,
                              int score,
                              double percentage,
                              String resultStatus) {

        String sql = "INSERT INTO quiz_results " +
                "(user_id, total_questions, correct_answers, " +
                "wrong_answers, score, percentage, result_status) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, userId);
            ps.setInt(2, totalQuestions);
            ps.setInt(3, correctAnswers);
            ps.setInt(4, wrongAnswers);
            ps.setInt(5, score);
            ps.setDouble(6, percentage);
            ps.setString(7, resultStatus);

            ps.executeUpdate();

            System.out.println("Quiz result saved successfully!");
            return true;

        } catch (SQLException e) {
            System.out.println("Failed to save quiz result!");
            System.out.println(e.getMessage());
            return false;
        }
    }

    // Get Quiz History
    public void getUserResults(int userId) {

        String sql = "SELECT * FROM quiz_results " +
                     "WHERE user_id = ? ORDER BY quiz_date DESC";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, userId);

            try (ResultSet rs = ps.executeQuery()) {

                System.out.println("\n===== QUIZ HISTORY =====");

                boolean found = false;

                while (rs.next()) {

                    found = true;

                    System.out.println("Date       : " +
                            rs.getTimestamp("quiz_date"));

                    System.out.println("Score      : " +
                            rs.getInt("score") + "/" +
                            rs.getInt("total_questions"));

                    System.out.println("Percentage : " +
                            rs.getDouble("percentage") + "%");

                    System.out.println("Result     : " +
                            rs.getString("result_status"));

                    System.out.println("-------------------------");
                }

                if (!found) {
                    System.out.println("No quiz history found.");
                }
            }

        } catch (SQLException e) {
            System.out.println("Failed to fetch quiz history!");
            System.out.println(e.getMessage());
        }
    }
}