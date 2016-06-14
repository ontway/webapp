package model.bo;

import java.util.List;



import model.dao.DaoFactory;
import model.dao.IUserDao;
import model.dto.User;

public class UserImpl implements IUser {

	@Override
	public void addUser(User user) throws Exception {
		IUserDao iUserDao=DaoFactory.getUserDao();
		iUserDao.create(user);

	}

	@Override
	public void deleteUser(User user) throws Exception {
		IUserDao iUserDao=DaoFactory.getUserDao();
		iUserDao.delete(user);

	}

	@Override
	public void updateUser(User user) throws Exception {
		IUserDao iUserDao=DaoFactory.getUserDao();
		iUserDao.update(user);

	}

	@Override
	public List<User> getList() throws Exception {
		IUserDao iUserDao=DaoFactory.getUserDao();
		return iUserDao.findAll();
	}

	@Override
	public User getUser(String username) throws Exception {
		IUserDao iUserDao=DaoFactory.getUserDao();
		return iUserDao.getUser(username);
	}

	@Override
	public boolean check(String username, String password) throws Exception {
		IUserDao iUserDao=DaoFactory.getUserDao();
		User user=iUserDao.getUser(username);
		if(user!=null&&user.getPassword().equals(password))
			return true;
		return false;
	}

	@Override
	public void changePassword(String username, String password) throws Exception {
		IUserDao iUserDao=DaoFactory.getUserDao();
		User user=iUserDao.getUser(username);
		if(user!=null){
			user.setPassword(password);
			iUserDao.update(user);
		}
	}
	
	public boolean validateUser(User user) throws Exception{
		if(getUser(user.getUsername())!=null)
			return true;
		return false;
	}
	public boolean login(User user) throws Exception{
		if(check(user.getUsername(),user.getPassword()))
	       return true;
		return false;
	}
    
	

}
