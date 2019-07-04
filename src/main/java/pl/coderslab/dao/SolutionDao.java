package pl.coderslab.dao;

import pl.coderslab.db.DbUtil;
import pl.coderslab.models.Solution;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SolutionDao {
    private static final String CREATE_SOLUTION_QUERY =
            "INSERT INTO solution(created, updated, description, exercise_id, users_id) VALUES (?, ?, ?, ?, ?)";
    private static final String READ_SOLUTION_QUERY =
            "SELECT * FROM solution where id = ?";
    private static final String UPDATE_SOLUTION_QUERY =
            "UPDATE solution SET created = ?, updated = ?, description = ?, exercise_id = ?, users_id = ? WHERE id = ?";
    private static final String DELETE_SOLUTION_QUERY =
            "DELETE FROM solution WHERE id = ?";
    private static final String FIND_ALL_SOLUTION_QUERY =
            "SELECT * FROM solution";
    private static final String FIND_ALL_BY_USER_ID = "SELECT * FROM solution WHERE users_id = ?;";
    private static final String FIND_ALL_BY_EXERCISE_ID = "SELECT * FROM solution WHERE exercise_id" +
            " = ? ORDER BY created DESC;";
    private static final String FIND_RECENT = "SELECT * FROM solution ORDER BY created LIMIT ?";

    public Solution read(int solutionId) {
        try (Connection conn = DbUtil.getConnection()) {
            PreparedStatement statement = conn.prepareStatement(READ_SOLUTION_QUERY);
            statement.setInt(1, solutionId);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                int id = resultSet.getInt("id");
                String created = resultSet.getString("created");
                String updated = resultSet.getString("updated");
                String description = resultSet.getString("description");
                int exerciseId = resultSet.getInt("exercise_id");
                int usersId = resultSet.getInt("users_id");
                Solution solution = new Solution(id, created, updated, description, exerciseId, usersId);
                return solution;
            }
        } catch (SQLException e) {
            System.out.println("Rozwiazanie o podanym id nie istnieje.");
            e.printStackTrace();
        }
        return null;
    }

    public List<Solution> findAllByUserId(int userId) {
        try (Connection conn = DbUtil.getConnection()) {
            PreparedStatement statement = conn.prepareStatement(FIND_ALL_BY_USER_ID);
            statement.setInt(1, userId);
            ResultSet resultSet = statement.executeQuery();
            List<Solution> listOfUserSolutions = new ArrayList<>();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String created = resultSet.getString("created");
                String updated = resultSet.getString("updated");
                String description = resultSet.getString("description");
                int exerciseId = resultSet.getInt("exercise_id");
                Solution solution = new Solution(id, created, updated, description, exerciseId, userId);
                listOfUserSolutions.add(solution);
            }
            return listOfUserSolutions;

        } catch (SQLException e) {
            System.err.println("Uzytkownik o podanym id nie istnieje.");
            System.err.println(e.getMessage());
        }
        return null;
    }

    public List<Solution> findRecent(int rowsLimit) {
        try (Connection conn = DbUtil.getConnection()) {
            PreparedStatement statement = conn.prepareStatement(FIND_RECENT);
            statement.setInt(1, rowsLimit);
            ResultSet resultSet = statement.executeQuery();
            List<Solution> listOfRecentSolutions = new ArrayList<>();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String created = resultSet.getString("created");
                String updated = resultSet.getString("updated");
                String description = resultSet.getString("description");
                int exerciseId = resultSet.getInt("exercise_id");
                int usersId = resultSet.getInt("users_id");
                Solution solution = new Solution(id, created, updated, description, exerciseId, usersId);
                listOfRecentSolutions.add(solution);

            }
            return listOfRecentSolutions;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return null;
    }

    public static Solution loadById(int solutionId) {
        try (Connection conn = DbUtil.getConnection()) {
            PreparedStatement statement = conn.prepareStatement(READ_SOLUTION_QUERY);
            statement.setInt(1, solutionId);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                int id = resultSet.getInt("id");
                String created = resultSet.getString("created");
                String updated = resultSet.getString("updated");
                String description = resultSet.getString("description");
                int exerciseId = resultSet.getInt("exercise_id");
                int usersId = resultSet.getInt("users_id");
                Solution solution = new Solution(id, created, updated, description, exerciseId, usersId);
                return solution;
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return null;
    }

}