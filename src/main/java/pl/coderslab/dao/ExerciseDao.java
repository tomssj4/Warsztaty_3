package pl.coderslab.dao;

import pl.coderslab.db.DbUtil;
import pl.coderslab.models.Exercise;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ExerciseDao {
    private static final String CREATE_EXERCISE_QUERY =
            "INSERT INTO exercise(title, description) VALUES (?, ?)";
    private static final String READ_EXERCISE_QUERY =
            "SELECT * FROM exercise where id = ?";
    private static final String UPDATE_EXERCISE_QUERY =
            "UPDATE exercise SET title = ?, description = ? WHERE id = ?";
    private static final String DELETE_EXERCISE_QUERY =
            "DELETE FROM exercise WHERE id = ?";
    private static final String FIND_ALL_EXERCISE_QUERY =
            "SELECT * FROM exercise";
    private static final String FIND_ALL_EXERCISES_WHERE_NO_SOLUTION = "SELECT * FROM exercise " +
            "WHERE exercise.id NOT IN (SELECT solution.exercise_id FROM solution WHERE users_id=?)";

    public Exercise create(Exercise exercise) {
        try (Connection conn = DbUtil.getConnection()) {
            PreparedStatement statement =
                    conn.prepareStatement(CREATE_EXERCISE_QUERY, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, exercise.getTitle());
            statement.setString(2, exercise.getDescription());
            statement.executeUpdate();
            ResultSet resultSet = statement.getGeneratedKeys();
            if (resultSet.next()) {
                exercise.setId(resultSet.getInt(1));

            }
            return exercise;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return null;
        }
    }

    public Exercise read(int exerciseId) {
        try (Connection conn = DbUtil.getConnection()) {
            PreparedStatement statement = conn.prepareStatement(READ_EXERCISE_QUERY);
            statement.setInt(1, exerciseId);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                int id = resultSet.getInt("id");
                String title = resultSet.getString("title");
                String description = resultSet.getString("description");
                Exercise exercise = new Exercise(id, title, description);
                return exercise;
            }
        } catch (SQLException e) {
            System.err.println("Cwiczenie o podanym id nie istnieje.");
            System.err.println(e.getMessage());
        }
        return null;
    }

    public void update(Exercise exercise) {
        try (Connection conn = DbUtil.getConnection()) {
            PreparedStatement statement = conn.prepareStatement(UPDATE_EXERCISE_QUERY);
            statement.setString(1, exercise.getTitle());
            statement.setInt(3, exercise.getId());
            statement.setString(2, exercise.getDescription());
            statement.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    public List<Exercise> findAllExercises() {
        try (Connection conn = DbUtil.getConnection()) {
            PreparedStatement statement = conn.prepareStatement(FIND_ALL_EXERCISE_QUERY);
            ResultSet resultSet = statement.executeQuery();
            List<Exercise> listOfAllExercises = new ArrayList<>();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String title = resultSet.getString("title");
                String description = resultSet.getString("description");
                Exercise exercise = new Exercise(id, title, description);
                listOfAllExercises.add(exercise);
            }
            return listOfAllExercises;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return null;
    }

}