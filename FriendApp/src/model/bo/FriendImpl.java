package model.bo;

import java.util.ArrayList;
import java.util.List;

import model.dao.DaoFactory;
import model.dao.IFrindDao;
import model.dto.Friend;

public class FriendImpl implements IFriend {

	@Override
	public void addFriend(Friend friend) throws Exception {
		IFrindDao iFrindDao=DaoFactory.getFriendDao();
		iFrindDao.addFriend(friend);

	}

	@Override
	public void deleteFriend(int fid) throws Exception {
		IFrindDao iFrindDao=DaoFactory.getFriendDao();
		iFrindDao.deleteFriend(fid);

	}

	@Override
	public void updateFriend(Friend friend) throws Exception {
		IFrindDao iFrindDao=DaoFactory.getFriendDao();
		iFrindDao.updateFriend(friend);

	}

	@Override
	public List<Friend> findAll(String username) throws Exception {
		IFrindDao iFrindDao=DaoFactory.getFriendDao();
		
		return iFrindDao.findAll(username);
	}

	@Override
	public Friend getFriend(String fname,String username) throws Exception {
		IFrindDao iFrindDao=DaoFactory.getFriendDao();
		return iFrindDao.getFriend(fname,username);
	}
	
	public List<Friend> getFriendByX(String fname,String username) throws Exception{
		IFrindDao iFrindDao=DaoFactory.getFriendDao();
		return iFrindDao.getFriendByX(fname, username);
	}
	public List<Friend> showFriend(String condition,String type,String username) throws Exception{
		List<Friend> list=new ArrayList<>();
		IFrindDao iFrindDao=DaoFactory.getFriendDao();
		int i=Integer.parseInt(type);
		switch (i) {
		case 1:
			list=iFrindDao.findAll(username);
			break;
		case 2:
			list.add(iFrindDao.getFriend(condition, username));
			break;
		case 3:
			list=iFrindDao.getFriendByX(condition, username);
		default:
			break;
		}
		return list;
	}
	public Friend getFriendByFid(int fid) throws Exception{
		IFrindDao iFrindDao=DaoFactory.getFriendDao();
		return iFrindDao.getFriendByFid(fid);
	}

}
