package test;



import model.bo.IFriend;

import model.bo.boFactory;
import model.dto.Friend;


public class Test {
      public static void main(String[] args) throws Exception{
    	  IFriend ifFriend=boFactory.getFriend();
    	  Friend f=new Friend();
    	  
    	  f.setFname("aa");
    	  f.setFgender("��");
    	  f.setUsername("a");
    	  
    	 ifFriend.addFriend(f);
    	  
      }
}
