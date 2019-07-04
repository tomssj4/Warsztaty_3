package pl.coderslab.dao;

import pl.coderslab.db.DbUtil;
import pl.coderslab.models.Group;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GroupDao {
    private static final String CREATE_GROUP_QUERY =
            "INSERT INTO user_group(name) VALUES (?)";
    private static final String READ_GROUP_QUERY =
            "SELECT * FROM user_group where id = ?";
    private static final String UPDATE_GROUP_QUERY =
            "UPDATE user_group SET name = ? WHERE id = ?";
    private static final String DELETE_GROUP_QUERY =
            "DELETE FROM user_group WHERE id = ?";
    private static final String FIND_ALL_GROUP_QUERY =
            "SELECT * FROM user_group";

    public Group create(Group group) {
        try (Connection conn = DbUtil.getConnection()) {
            PreparedStatement statement =
                    conn.prepareStatement(CREATE_GROUP_QUERY, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, group.getName());
            statement.executeUpdate();
            ResultSet resultSet = statement.getGeneratedKeys();
            if (resultSet.next()) {
                group.setId(resultSet.getInt(1));
            }
            return group;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return null;
        }
    }

    public Group read(int groupId) {
        try (Connection conn = DbUtil.getConnection()) {
            PreparedStatement statement = conn.prepareStatement(READ_GROUP_QUERY);
            statement.setInt(1, groupId);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                Group group = new Group(id, name);
                return group;
            }
        } catch (SQLException e) {
            System.err.println("Grupa o podanym id nie istnieje.");
            System.err.println(e.getMessage());
        }
        return null;
    }

    public void update(Group group) {
        try (Connection conn = DbUtil.getConnection()) {
            PreparedStatement statement = conn.prepareStatement(UPDATE_GROUP_QUERY);
            statement.setString(1, group.getName());
            statement.setInt(2, group.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }


    public List<Group> loadAll() {
        try (Connection conn = DbUtil.getConnection()) {
            PreparedStatement statement = conn.prepareStatement(FIND_ALL_GROUP_QUERY);
            ResultSet resultSet = statement.executeQuery();
            List<Group> listOfAllGroups = new ArrayList<>();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                Group group = new Group(id, name);
                listOfAllGroups.add(group);

            }
            return listOfAllGroups;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return null;
    }

}