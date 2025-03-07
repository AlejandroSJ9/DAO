package org.alejo.repository;

import org.alejo.dao.OrderDAO;
import org.alejo.model.Order;

import java.util.List;

public class OrderRepository implements OrderDAO {
    @Override
    public List<Order> getAll() {
        return List.of();
    }

    @Override
    public Order getById(Integer id) {
        return null;
    }

    @Override
    public void save(Order order) {

    }

    @Override
    public void update(Order order) {

    }

    @Override
    public void delete(Order order) {

    }
}
