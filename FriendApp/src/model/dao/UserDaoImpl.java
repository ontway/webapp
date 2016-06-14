package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.dto.User;

import model.dao.ConnectionFactory;


public class UserDaoImpl implements IUserDao {

	@Override
	public void create(User user) throws Exception {
		// TODO Auto-generated method stub
       Connection conn=ConnectionFactory.getConnection();
       String sql="insert into userinfo values(?,?)";
       try {
		  PreparedStatement ps=conn.prepareStatement(sql);
		  ps.setString(1, user.getUsername());
		  ps.setString(2, user.getPassword());
		  ps.executeUpdate();
		  ps.close();
	} catch (Exception e) {
		// TODO: handle exception
	}finally {
		conn.close();
	}
       
	}

	@Override
	public void delete(User user) throws Exception {
		Connection conn=null;
		String sql="delete from userinfo where username=?";
		try {
			conn=ConnectionFactory.getConnection();
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, user.getUsername());
			ps.executeUpdate();
			ps.close();
		} catch (Exception e) {
			// TODO: handle exception
		}finally{
			conn.close();
		}
 
	}

	@Override
	public void update(User user) throws Exception {
		Connection conn=null;
		String sql="update userinfo set username=?,password=?";
		try{
			conn=ConnectionFactory.getConnection();
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			ps.executeUpdate();
			ps.close();
		}catch(Exception e){
			
		}finally {
			conn.close();
		}
        
	}

	@Override
	public List<User> findAll() throws Exception {
		Connection conn=null;
		String sql="select * from userinfo";
		List<User> list=new ArrayList<>();
		User user=null;
		try {
			conn=ConnectionFactory.getConnection();
			PreparedStatement ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				user=new User();
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				
				list.add(user);
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
	public User getUser(String username) throws Exception {
		Connection conn=null;
		String sql="select * from userinfo where username=?";
		
		User user=null;
		try {
			conn=ConnectionFactory.getConnection();
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, username);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				user=new User();
				user.setUsername(username);
				user.setPassword(rs.getString("password"));
				
				
			}
		
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("É¾³ýÊ§°Ü");
		}finally {
			conn.close();
		}
		return user;
	}

}
