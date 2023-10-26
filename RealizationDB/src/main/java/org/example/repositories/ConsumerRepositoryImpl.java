package org.example.repositories;

import org.example.models.Consumer;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ConsumerRepositoryImpl implements ConsumerRepository{

    private final DataSource dataSource;
    private final static String SQL_SELECT_ALL = "select * from consumer";
    private final static String SQL_INSERT = "insert into consumer (consumer_name, money, car_saloon, consumer_surname, consumer_patronymic, date_of_birth, job, nationality, phonenumber, email) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

    public ConsumerRepositoryImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public List<Consumer> findAll() {
        List<Consumer> consumers = new ArrayList<>();
        try (Connection connection = dataSource.getConnection();
             Statement statement = connection.createStatement()){
            try (ResultSet resultSet = statement.executeQuery(SQL_SELECT_ALL)) {
                while (resultSet.next()) {
                    Consumer consumer = Consumer.builder()
                            .id(resultSet.getInt("consumer_id"))
                            .consumer_name(resultSet.getString("consumer_name"))
                            .consumer_surname(resultSet.getString("consumer_surname"))
                            .consumer_patronymic(resultSet.getString("consumer_patronymic"))
                            .money(resultSet.getInt("money"))
                            .car_saloon(resultSet.getInt("car_saloon"))
                            .date_of_birth(resultSet.getString("date_of_birth"))
                            .job(resultSet.getString("job"))
                            .nationality(resultSet.getString("nationality"))
                            .phonenumber(resultSet.getString("phonenumber"))
                            .email(resultSet.getString("email"))
                            .build();
                    consumers.add(consumer);
                }
            }

        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
        return consumers;
    }

    @Override
    public void save(Consumer item) {
        try (Connection connection = dataSource.getConnection()) {
            try (PreparedStatement statement = connection.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS)) {
                statement.setString(1,item.getConsumer_name());
                statement.setString(4,item.getConsumer_surname());
                statement.setString(5,item.getConsumer_patronymic());
                statement.setInt(2,item.getMoney());
                statement.setInt(3,item.getCar_saloon());
                statement.setString(6, item.getDate_of_birth());
                statement.setString(7,item.getJob());
                statement.setString(8,item.getNationality());
                statement.setString(9,item.getPhonenumber());
                statement.setString(10,item.getEmail());
                int affectedRows = statement.executeUpdate();

                if (affectedRows != 1) {
                    throw new SQLException("Cannot insert consumer");
                }

                try (ResultSet generatedIds = statement.getGeneratedKeys()){
                    if (generatedIds.next()) {
                        item.setId(generatedIds.getInt("consumer_id"));
                    } else {
                        throw new SQLException("Cannot retrieve id");
                    }
                }

            }
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }


}
