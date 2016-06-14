package action.findfriendservlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bo.IFriend;
import model.bo.boFactory;
import model.dto.Friend;

/**
 * Servlet implementation class FindFriendServlet
 */
@WebServlet("/FindFriendServlet")
public class FindFriendServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindFriendServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html);charset=UTF-8");
		try {
			String condition=request.getParameter("condition");
			String type=request.getParameter("type");
			HttpSession session=request.getSession();
			String username=(String)session.getAttribute("username");
			List<Friend> list=new ArrayList<>();
			IFriend iFriend=boFactory.getFriend();
			list=iFriend.showFriend(condition, type, username);
			request.setAttribute("list", list);
			request.getRequestDispatcher("showFriend.jsp").forward(request, response);
			
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
