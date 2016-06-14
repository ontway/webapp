package model.bo;

public class boFactory {
    public static IUser getUser(){
    	return new UserImpl();
    }
    public static IFriend getFriend(){
    	return new FriendImpl();
    }
}
