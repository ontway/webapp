package model.dao;

import java.util.List;

import model.dto.Friend;

public interface IFrindDao {
        public void addFriend(Friend friend) throws Exception;
        public void deleteFriend(int fid) throws Exception;
        public void updateFriend(Friend friend) throws Exception;
        public List<Friend> findAll(String username) throws Exception;
        public Friend getFriend(String fname,String username) throws Exception;
        public List<Friend> getFriendByX(String fname,String username) throws Exception;
        public Friend getFriendByFid(int fid) throws Exception;
}
