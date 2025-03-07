package org.alejo.repository;

import org.alejo.dao.ProductDAO;
import org.alejo.model.Product;

import java.util.List;

public class ProductRepository implements ProductDAO {
    @Override
    public List<Product> getAll() {
        return List.of();
    }

    @Override
    public Product getById(Integer id) {
        return null;
    }

    @Override
    public void save(Product product) {

    }

    @Override
    public void update(Product product) {

    }

    @Override
    public void delete(Product product) {

    }
}
