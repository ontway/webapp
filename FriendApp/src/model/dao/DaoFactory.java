package model.dao;

public class DaoFactory {
      public static IUserDao getUserDao(){
    	  return new UserDaoImpl();
      }
      public static IFrindDao getFriendDao(){
    	  return new FriendDapImpl();
      }
}
