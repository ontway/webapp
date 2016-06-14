package model.bo;

import java.util.List;

import model.dto.User;


public interface IUser {
        public void addUser(User user) throws Exception;
        public void deleteUser(User user) throws Exception;
        public void updateUser(User user) throws Exception;
        public List<User> getList() throws Exception;
        public User getUser(String username) throws Exception;
        public boolean check(String username,String password) throws Exception;
        public void changePassword(String username,String password) throws Exception;
       public boolean validateUser(User user) throws Exception;
       public boolean login(User user) throws Exception;
}
