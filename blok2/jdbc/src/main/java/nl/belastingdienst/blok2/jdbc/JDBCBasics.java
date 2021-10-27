package nl.belastingdienst.blok2.jdbc;

import lombok.extern.slf4j.Slf4j;

import java.sql.*;

@Slf4j
public class JDBCBasics {

    public static void main(String[] args) throws ClassNotFoundException {

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcdemo", "root", "root")) {
            // 1 driver laden
            // Class<?> deDriverClass = Class.forName("com.mysql.cj.jdbc.Driver");

            // 2
            // zie try (...) boven

            // 3
            Statement statement = connection.createStatement();

            // 4
            ResultSet resultSet = statement.executeQuery("SELECT * FROM PERSON");

            // 5
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String name = resultSet.getString("name");
                int age = resultSet.getInt(3);

                Person p = Person.builder().id(id).name(name).age(age).build();
                log.info(p.toString());
            }
        } catch (SQLException e) {
            log.error("Er trad een SQL-fout op", e);
        }

    }

}
