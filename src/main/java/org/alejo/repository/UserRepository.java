package org.alejo.repository;

import org.alejo.dao.UserDAO;
import org.alejo.model.User;

import java.util.List;

public class UserRepository implements UserDAO {
    @Override
    public List<User> getAll() {
        return List.of();
    }

    @Override
    public User getById(Integer id) {
        return null;
    }

    @Override
    public void save(User user) {

    }

    @Override
    public void update(User user) {

    }

    @Override
    public void delete(User user) {

    }
}
