package org.example.casestudymodule3.service;

import org.example.casestudymodule3.model.Customer;
import org.example.casestudymodule3.model.Order;
import org.example.casestudymodule3.model.Skin;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerDao implements ICustomerDao{
    String jdbcURL = "jdbc:mysql://localhost:3306/shopskinmanager";
    String jdbcUsername = "root";
    String jdbcPassword = "11062001&Dat";

    private static final String SELECT_ALL_CHAMPIONS = "select * from skin";
    private static final String SELECT_ALL_CART = "select * from skin inner join orderdetail on skin.skin_id = orderdetail.skin_id";
    private static final String GET_ORDER_NOT_PAID = "select * from  order where is_paid = 0";
    private static final String SELECT_USER_BY_EMAIL = "";
    private static final String INSERT_USER_SQL = "";
    private Customer customer = null;

    public CustomerDao() {
    }

    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException | ClassNotFoundException e) {
            System.err.println(e.getMessage());;
        }
        return connection;
    }

    @Override
    public List<Skin> getAllSkin() {
        List<Skin> skins = new ArrayList<>();
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CHAMPIONS);) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("skin_id");
                String name = rs.getString("name");
                String thumbnail = rs.getString("thumbnail");
                String video = rs.getString("video");
                int price = rs.getInt("price");
                int champion_id = rs.getInt("champion_id");
                skins.add(new Skin(id, name, thumbnail, video, price, champion_id));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return skins;
    }

    public Order getCartNotPaid() {
        Order order = null;
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(GET_ORDER_NOT_PAID);) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("order_id");
                int customer_id = rs.getInt("customer_id");
                String order_date = rs.getString("order_date");
                int total_price = rs.getInt("total");
                int is_paid = rs.getInt("is_paid");
                order = new Order(id, customer_id, order_date, total_price, is_paid);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return order;
    }

    public Order addCart() {
        String ADD_NEW_ORDER = "insert into order(customer_id,order_date,total,is_paid) values (current_user.customer_id,now(),0,0)";
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(ADD_NEW_ORDER);) {
            ResultSet rs = preparedStatement.executeQuery();
        } catch (SQLException e) {
            printSQLException(e);
        }
        return null;
    }

    @Override
    public void addToCart(int orderId, int skinId) {
        String ADD_TO_CART = "insert into orderdetail values (orderId,skinId)";
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(ADD_TO_CART)) {
            preparedStatement.executeQuery();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    //User
    public boolean registerUser(Customer user) {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USER_SQL)) {
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getPassword());
            preparedStatement.setString(4, user.getIn_game());
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            printSQLException(e);
            return false;
        }
    }

    public Customer loginUser(String email, String password) {
        Customer customer = null;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_EMAIL)) {
            preparedStatement.setString(1, email);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next() && rs.getString("password").equals(password)) {
                customer = new Customer();
                customer.setCustomer_id(rs.getInt("customer_id"));
                customer.setName(rs.getString("name"));
                customer.setEmail(rs.getString("email"));
                customer.setIn_game(rs.getString("in_game"));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return customer;
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}