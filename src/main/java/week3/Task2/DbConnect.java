package week3.Task2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

public class DbConnect {
    private static final String CONNECTION_STRING = "jdbc:mysql://localhost:3306/lab3";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "403081";

    private Connection connection = null;

    public DbConnect() {
        try {
            connection = DriverManager.getConnection(
                    CONNECTION_STRING,
                    USERNAME,
                    PASSWORD
            );
            System.out.println("Successfully connected to the database.");
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to connect to the database.", e);
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
                System.out.println("Database connection successfully closed.");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String args[]) throws SQLException {
        DbConnect database = new DbConnect();
        database.getAllTasks();
        database.getById(2);
        database.createNewTask(6, "Another task creation", Status.TO_DO);
        database.updateTaskName(2, "New description.");
    }

    public void getAllTasks() throws SQLException {
        PreparedStatement statement = this.connection.prepareStatement(
                "SELECT * FROM tasks"
        );
        ResultSet rs = statement.executeQuery();

        while (rs.next()) {
            System.out.println(rs.getInt("id"));
            System.out.println(rs.getString("task_description"));
            System.out.println(rs.getString("task_status"));
        }
    }

    public void getById(int id) throws SQLException {
        PreparedStatement statement = this.connection.prepareStatement(
                "SELECT * FROM tasks WHERE id = ?"
        );
        statement.setInt(1, id);
        ResultSet rs = statement.executeQuery();

        while (rs.next()) {
            System.out.println(rs.getInt("id"));
            System.out.println(rs.getString("task_description"));
            System.out.println(rs.getString("task_status"));
        }
    }

    public void createNewTask(int id, String task_description, Status task_status) throws SQLException {
        PreparedStatement statement = this.connection.prepareStatement(
                "INSERT INTO tasks (id, task_description, task_status) VALUES (?, ?, ?)"
        );
        statement.setInt(1, id);
        statement.setString(2, task_description);
        statement.setString(3, task_status.name());

        int insertedRows = statement.executeUpdate();
        if (insertedRows > 0) {
            System.out.println("New task has been successfully created.");
        } else {
            System.out.println("Task has not been created.");
        }
    }

    public void updateTaskName(int id, String task_description) throws SQLException {
        PreparedStatement statement = this.connection.prepareStatement(
                "UPDATE tasks SET task_description = ? WHERE id = ?"
        );
        statement.setString(1, task_description);
        statement.setInt(2, id);
        int newTaskDescription = statement.executeUpdate();
        if (newTaskDescription > 0) {
            System.out.println("Task description has been succesfully updated.");
        } else {
            System.out.println("Task description was not updated.");
        }
    }
}
