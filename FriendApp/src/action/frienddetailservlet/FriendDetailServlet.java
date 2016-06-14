package action.frienddetailservlet;

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
 * Servlet implementation class FriendDetailServlet
 */
@WebServlet("/FriendDetailServlet")
public class FriendDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FriendDetailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		try {
			String fid=request.getParameter("fid");
			String opcode=request.getParameter("opcode");
			IFriend iFriend=boFactory.getFriend();
			Friend friend=iFriend.getFriendByFid(Integer.parseInt(fid));
			request.setAttribute("friend", friend);
			if("u".equals(opcode))
				request.getRequestDispatcher("updateFriend.jsp").forward(request, response);
			else {
				request.getRequestDispatcher("deleteFriend.jsp").forward(request, response);
				
			}
			
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
