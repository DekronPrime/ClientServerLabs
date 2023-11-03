package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AbiturientDAO {
    private Connection connection;

    public AbiturientDAO(Connection connection) {
        this.connection = connection;
    }

    public void createTable() throws SQLException {
        try (Statement statement = connection.createStatement()) {
            statement.execute("CREATE TABLE abiturients " +
                    "(id INT PRIMARY KEY            NOT NULL GENERATED ALWAYS AS IDENTITY," +
                    " lastname       VARCHAR(20)    NOT NULL, " +
                    " firstname      VARCHAR(20)    NOT NULL, " +
                    " fathername     VARCHAR(20)    NOT NULL, " +
                    " email          VARCHAR(30)    NOT NULL, " +
                    " phone          VARCHAR(15)    NOT NULL, " +
                    " average_point  NUMERIC(3,1)   NOT NULL, " +
                    " address        TEXT           NOT NULL, " +
                    " need_hostel    BOOLEAN        NOT NULL);");
        } catch (SQLException e) {
            throw new SQLException("Table already exists. First drop the table");
        }
    }

    public void dropTable() throws SQLException {
        try (Statement statement = connection.createStatement()) {
            statement.execute("DROP TABLE abiturients;");
        } catch (SQLException e) {
            throw new SQLException("Table is not exists. First create the table");
        }
    }

    int insert(Abiturient abiturient) throws SQLException {
        try (PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO abiturients (lastname,firstname,fathername,email,phone,average_point,address,need_hostel) VALUES (?,?,?,?,?,?,?,?);")) {
            preparedStatement.setString(1, abiturient.getLastName());
            preparedStatement.setString(2, abiturient.getFirstName());
            preparedStatement.setString(3, abiturient.getFatherName());
            preparedStatement.setString(4, abiturient.getEmail());
            preparedStatement.setString(5, abiturient.getPhone());
            preparedStatement.setDouble(6, abiturient.getAveragePoint());
            preparedStatement.setString(7, abiturient.getAddress());
            preparedStatement.setBoolean(8, abiturient.isNeedHostel());
            return preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new SQLException("Entered data is invalid");
        }
    }

    List<Abiturient> select() throws SQLException{
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM abiturients");
            ArrayList<Abiturient> abiturients = new ArrayList<>();
            while (resultSet.next()) {
                Abiturient abiturient = new Abiturient();
                abiturient.setID(resultSet.getLong("id"));
                abiturient.setLastName(resultSet.getString("lastname"));
                abiturient.setFirstName(resultSet.getString("firstname"));
                abiturient.setFatherName(resultSet.getString("fathername"));
                abiturient.setEmail(resultSet.getString("email"));
                abiturient.setPhone(resultSet.getString("phone"));
                abiturient.setAveragePoint(resultSet.getDouble("average_point"));
                abiturient.setAddress(resultSet.getString("address"));
                abiturient.setNeedHostel(resultSet.getBoolean("need_hostel"));
                abiturients.add(abiturient);
            }
            return abiturients;
        } catch (SQLException e) {
            throw new SQLException("Table is not exists");
        }
    }

    Abiturient findById(long id) throws SQLException {
        try (PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM abiturients WHERE id = ?")) {
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            Abiturient abiturient = new Abiturient();
            if (resultSet.next()) {
                abiturient.setID(resultSet.getLong("id"));
                abiturient.setLastName(resultSet.getString("lastname"));
                abiturient.setFirstName(resultSet.getString("firstname"));
                abiturient.setFatherName(resultSet.getString("fathername"));
                abiturient.setEmail(resultSet.getString("email"));
                abiturient.setPhone(resultSet.getString("phone"));
                abiturient.setAveragePoint(resultSet.getDouble("average_point"));
                abiturient.setAddress(resultSet.getString("address"));
                abiturient.setNeedHostel(resultSet.getBoolean("need_hostel"));
            }
            if (resultSet.getLong("id") == 0)
                throw new SQLException("Abiturient with such id is not found");
            return abiturient;
        } catch (SQLException e) {
            throw new SQLException("Table is not exists");
        }
    }

    int update(Abiturient abiturient) throws SQLException {
        try (PreparedStatement preparedStatement = connection.prepareStatement("UPDATE abiturients SET lastname = ?, firstname = ?, fathername = ?, email = ?, phone = ?, average_point = ?, address = ?, need_hostel = ? WHERE id = ?")) {
            preparedStatement.setString(1, abiturient.getLastName());
            preparedStatement.setString(2, abiturient.getFirstName());
            preparedStatement.setString(3, abiturient.getFatherName());
            preparedStatement.setString(4, abiturient.getEmail());
            preparedStatement.setString(5, abiturient.getPhone());
            preparedStatement.setDouble(6, abiturient.getAveragePoint());
            preparedStatement.setString(7, abiturient.getAddress());
            preparedStatement.setBoolean(8, abiturient.isNeedHostel());
            preparedStatement.setLong(9, abiturient.getID());
            return preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new SQLException("Abiturient with such id is not found");
        }
    }

    int delete(Abiturient abiturient) throws SQLException {
        try (PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM abiturients WHERE lastname = ? AND firstname = ? AND fathername = ? AND email = ? AND phone = ? AND average_point = ? AND address = ? and need_hostel = ?;")) {
            preparedStatement.setString(1, abiturient.getLastName());
            preparedStatement.setString(2, abiturient.getFirstName());
            preparedStatement.setString(3, abiturient.getFatherName());
            preparedStatement.setString(4, abiturient.getEmail());
            preparedStatement.setString(5, abiturient.getPhone());
            preparedStatement.setDouble(6, abiturient.getAveragePoint());
            preparedStatement.setString(7, abiturient.getAddress());
            preparedStatement.setBoolean(8, abiturient.isNeedHostel());
            return preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new SQLException("Entered data is invalid");
        }
    }

    int deleteById(long id) throws SQLException {
        try (PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM abiturients WHERE id = ?")) {
            preparedStatement.setLong(1, id);
            return preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new SQLException("Abiturient with such id is not found");
        }
    }
}
