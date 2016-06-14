package action.addfriendservlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bo.IFriend;
import model.bo.boFactory;
import model.dto.Friend;

/**
 * Servlet implementation class AddFriendServlet
 */
@WebServlet("/AddFriendServlet")
public class AddFriendServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddFriendServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		try {
			request.getRequestDispatcher("friend.jsp").include(request, response);
			Friend friend=(Friend)request.getAttribute("friend");
//			Friend friend=new Friend();
//			String fname=request.getParameter("fname");
//			String fgender=request.getParameter("fgender");
//			String username=request.getParameter("username");
//			friend.setFname(fname);
//			friend.setFgender(fgender);
//			friend.setUsername(username);
			IFriend iFriend=boFactory.getFriend();
			if(true){
				iFriend.addFriend(friend);
				request.setAttribute("msg", "添加成功");
				request.getRequestDispatcher("addFriend.jsp").forward(request, response);
			}	
//			else {
//				request.setAttribute("msg", "该朋友已经存在");
//				request.getRequestDispatcher("addFriend.jsp").forward(request, response);
//				
//			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
