package base;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MyConnection {
    public void create(String name, String brand, String type, int strings) throws SQLException {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement =
                     connection.prepareStatement(
                             "insert into guitars_table(id, name, brand, type, strings) " +
                                     "VALUES(default, ?, ?, ?, ?);")) {
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, brand);
            preparedStatement.setString(3, type);
            preparedStatement.setInt(4, strings);
            preparedStatement.execute();
        }
    }

    public List<Guitar> read() throws SQLException {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement =
                     connection.prepareStatement("select * from guitars_table order by id;")) {
            ResultSet resultSet = preparedStatement.executeQuery();
            ArrayList<Guitar> guitars = mapping(resultSet);
            return guitars;
        }
    }

    public void update(int id, String name, String brand, String type, int strings) throws SQLException {
        try (
                Connection connection = getConnection();
                PreparedStatement prepStatRead = connection.prepareStatement(
                        "select * from guitars_table where id=?")) {
            prepStatRead.setInt(1, id);
            ResultSet resultSet = prepStatRead.executeQuery();
            ArrayList<Guitar> guitars = mapping(resultSet);
            PreparedStatement preparedStatement =
                    connection.prepareStatement(
                            "update guitars_table set \"name\"   = ?, \"brand\"= ?, \"type\"=?, \"strings\"=? where id =?;");
            preparedStatement.setInt(5, id);
            if (!name.equals(null) & !name.equals("") & !guitars.get(0).getName().equals(name)) {
                preparedStatement.setString(1, name);
            } else {
                preparedStatement.setString(1, guitars.get(0).getName());
            }
            if (!brand.equals(null) & !brand.equals("") & !guitars.get(0).getBrand().equals(brand)) {
                preparedStatement.setString(2, brand);
            } else {
                preparedStatement.setString(2, guitars.get(0).getBrand());
            }
            if (!type.equals(null) & !type.equals("") & !guitars.get(0).getType().equals(type)) {
                preparedStatement.setString(3, type);
            } else {
                preparedStatement.setString(3, guitars.get(0).getType());
            }
            if (strings != 0 & guitars.get(0).getStrings() != strings) {
                preparedStatement.setInt(4, strings);
            } else {
                preparedStatement.setInt(4, guitars.get(0).getStrings());
            }
            preparedStatement.execute();
        }
    }

    public void delete(int... ints) throws SQLException {
        try (Connection connection = getConnection()) {
            PreparedStatement preparedStatement;
            for (int i = 0; i < ints.length; i++) {
                preparedStatement = connection.prepareStatement("delete from guitars_table where id = ?;");
                preparedStatement.setInt(1, ints[i]);
                preparedStatement.execute();
                preparedStatement.close();
            }
        }
    }

    private static Connection getConnection() {
        Connection connection;
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:postgresql://localhost/HW34_dataBase",
                    "postgres", "root");
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }

    private static ArrayList<Guitar> mapping(ResultSet resultSet) throws SQLException {
        ArrayList<Guitar> guitars = new ArrayList<>();
        while (resultSet.next()) {
            Guitar guitar = new Guitar();
            guitar.setId(resultSet.getInt("id"));
            guitar.setName(resultSet.getString("name"));
            guitar.setBrand(resultSet.getString("brand"));
            guitar.setType(resultSet.getString("type"));
            guitar.setStrings(resultSet.getInt("strings"));
            guitars.add(guitar);
        }
        return guitars;
    }
}
