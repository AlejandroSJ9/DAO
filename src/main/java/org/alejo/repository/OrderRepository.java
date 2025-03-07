package org.alejo.repository;

import org.alejo.config.DataBaseConnection;
import org.alejo.dao.OrderDAO;
import org.alejo.dto.OrderDTO;
import org.alejo.mapper.OrderMapper;
import org.alejo.model.Order;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderRepository implements OrderDAO {
    private final OrderMapper orderMapper = OrderMapper.INSTANCE;
    @Override
    public List<Order> getAll() {
        String query = "SELECT * FROM order";
        List<Order> orders = new ArrayList<>();
        try(Connection conn = DataBaseConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(query)){

            ResultSet result = ps.executeQuery(query);
            while (result.next()) {
                orders.add(orderMapper.toEntity(new OrderDTO(
                        result.getInt("id"),
                        result.getInt("user_id"),
                        result.getInt("product_id"),
                        result.getInt("quantity"),
                        result.getTimestamp("order_date"))));
            }
        return orders;
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public Order getById(Integer id) {
        String sql = "SELECT * FROM orders WHERE id = ?";
        try (Connection conn = DataBaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return orderMapper.toEntity(new OrderDTO((int) rs.getLong("id"), (int) rs.getLong("user_id"), (int) rs.getLong("product_id"), rs.getInt("quantity"), rs.getTimestamp("order_date")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void save(Order order) {
        String sql = "INSERT INTO orders (user_id, product_id, quantity, order_date) VALUES (?, ?, ?, ?)";
        try (Connection conn = DataBaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setLong(1, order.getUserId());
            stmt.setLong(2, order.getProductId());
            stmt.setInt(3, order.getQuantity());
            stmt.setTimestamp(4, Timestamp.valueOf(order.getOrderDate()));
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Order order) {
        String sql = "UPDATE orders SET user_id = ?, product_id = ?, quantity = ? WHERE id = ?";
        try (Connection conn = DataBaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setLong(1, order.getUserId());
            stmt.setLong(2, order.getProductId());
            stmt.setInt(3, order.getQuantity());
            stmt.setLong(4, order.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Order order) {
        String sql = "DELETE FROM orders WHERE id = ?";
        try (Connection conn = DataBaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setLong(1, order.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
