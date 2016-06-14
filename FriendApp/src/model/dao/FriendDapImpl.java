package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.dto.Friend;


public class FriendDapImpl implements IFrindDao {

	@Override
	public void addFriend(Friend friend) throws Exception {
		// TODO Auto-generated method stub
		Connection conn=ConnectionFactory.getConnection();
	    String sql="insert into friend values(?,?,?)";
	    try {
	    	PreparedStatement ps=conn.prepareStatement(sql);
			  ps.setString(1, friend.getFname());
			  ps.setString(2, friend.getFgender());
			  ps.setString(3, friend.getUsername());
			  ps.executeUpdate();
			  ps.close();
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			conn.close();
		}
	}

	@Override
	public void deleteFriend(int fid) throws Exception {
		Connection conn=ConnectionFactory.getConnection();
		String sql="delete from friend where fid=?";
		try {
			conn=ConnectionFactory.getConnection();
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1, fid);
			ps.executeUpdate();
			ps.close();
		} catch (Exception e) {
			// TODO: handle exception
		}finally{
			conn.close();
		}
	}

	@Override
	public void updateFriend(Friend friend) throws Exception {
		Connection conn=null;
		String sql="update friend set fname=?,fgender=?,username=? where fid=?";
		try{
			conn=ConnectionFactory.getConnection();
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, friend.getFname());
			ps.setString(2, friend.getFgender());
			ps.setString(3, friend.getUsername());
			ps.setInt(4, friend.getFid());
			ps.executeUpdate();
			ps.close();
		}catch(Exception e){
			
		}finally {
			conn.close();
		}

	}

	@Override
	public List<Friend> findAll(String username) throws Exception {
		Connection conn=null;
		String sql="select * from friend where username=?";
		List<Friend> list=new ArrayList<>();
		Friend friend=null;
		try {
			conn=ConnectionFactory.getConnection();
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, username);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				friend=new Friend();
				friend.setFname(rs.getString("fname"));
				friend.setFgender(rs.getString("fgender"));
				friend.setFid(rs.getInt("fid"));
				list.add(friend);
			}
		
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("É¾³ýÊ§°Ü");
		}finally {
			conn.close();
		}
		
		
		return list;
	}

	@Override
	public Friend getFriend(String fname,String username) throws Exception {
		Connection conn=null;
		String sql="select * from friend where fname=? and username=?";
		
		Friend friend=null;
		try {
			conn=ConnectionFactory.getConnection();
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, fname);
			ps.setString(2, username);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				friend=new Friend();
				friend.setFname(fname);
				friend.setFgender(rs.getString("fgender"));
				friend.setFid(rs.getInt("fid"));
				
			}
		
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("É¾³ýÊ§°Ü");
		}finally {
			conn.close();
		}
		return friend;
	}
	public List<Friend> getFriendByX(String fname,String username) throws Exception{
		List<Friend> list=new ArrayList<>();
		Connection conn=null;
		String sql="select * from friend where fname like ? and username=?";
        Friend friend=null;
        try {
			conn=ConnectionFactory.getConnection();
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, fname+"%");
			ps.setString(2, username);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				friend=new Friend();
				friend.setFname(rs.getString("fname"));
				friend.setFgender(rs.getString("fgender"));
				friend.setFid(rs.getInt("fid"));
				list.add(friend);
				
				
			}
		     rs.close();
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("É¾³ýÊ§°Ü");
		}finally {
			conn.close();
		}
		return list;
	}
	public Friend getFriendByFid(int fid) throws Exception{
		Friend friend=null;
		Connection conn=null;
		String sql="select * from friend where fid=?";
		try {
			conn=ConnectionFactory.getConnection();
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1, fid);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				friend=new Friend();
				friend.setFname(rs.getString("fname"));
				friend.setFgender(rs.getString("fgender"));
				friend.setUsername(rs.getString("username"));
				friend.setFid(fid);
				
			}
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			conn.close();
		}
		return friend;
	}

}
