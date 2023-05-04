package org.example.dao;

import jdk.jshell.spi.ExecutionControl;
import org.example.model.Product;

import java.sql.*;

public class ProductDAO<T> {
    protected Connection _connection;
    protected PreparedStatement statement;
    protected String request;
    protected ResultSet resultSet;

    public ProductDAO(Connection connection) {
        _connection = connection;
    }

    public boolean save(Product product) throws SQLException {
        request = "INSERT INTO product (name, price, quantity, description) values (?,?,?,?)";
        statement = _connection.prepareStatement(request, Statement.RETURN_GENERATED_KEYS);
        statement.setString(1, product.getName());
        statement.setFloat(2, product.getPrice());
        statement.setInt(3,product.getQuantity());
        statement.setString(4,product.getDescription());
        int nbRow = statement.executeUpdate();
        resultSet = statement.getGeneratedKeys();
        if(resultSet.next()) {
            product.setId(resultSet.getInt(1)) ;
        }
        return nbRow == 1;
    }

    public Product getById(int id) throws SQLException {
        Product product = null;
        request = "SELECT * FROM product where id_product = ?";
        statement = _connection.prepareStatement(request);
        statement.setInt(1, id);
        resultSet = statement.executeQuery();
        if(resultSet.next()) {
            product = new Product(resultSet.getInt("id_product"),
                    resultSet.getString("name"),
                    resultSet.getFloat("price"),
                    resultSet.getInt("quantity"),
                    resultSet.getString("description")
            );
        }
        return product;
    }

    public boolean update(Product product) throws SQLException {
        request = "UPDATE product set quantity = ? where id_product = ?";
        statement = _connection.prepareStatement(request);
        statement.setInt(1, product.getQuantity());
        statement.setInt(2, product.getId());
        int nbRow = statement.executeUpdate();
        return nbRow == 1;
    }

    public boolean delete(Product product) throws SQLException {
        request = "DELETE FROM product where id_product = ?";
        statement = _connection.prepareStatement(request);
        statement.setInt(1, product.getId());
        int nbRow = statement.executeUpdate();
        return nbRow == 1;
    }
}
