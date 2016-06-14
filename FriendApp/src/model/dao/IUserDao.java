package model.dao;

import java.util.List;

import model.dto.User;

public interface IUserDao {
        public void create(User user) throws Exception;
        public void delete(User user) throws Exception;
        public void update(User user) throws Exception;
        public List<User> findAll() throws Exception;
        public User getUser(String username) throws Exception;
        
}
