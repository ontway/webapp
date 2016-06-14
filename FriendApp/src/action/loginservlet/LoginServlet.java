package action.loginservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bo.IUser;

import model.bo.boFactory;
import model.dto.User;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out=response.getWriter();
		try {
//			String username=request.getParameter("username");
//			String password=request.getParameter("password");
//			User user=new User();
//			user.setUsername(username);
//			user.setPassword(password);
			request.getRequestDispatcher("user.jsp").include(request, response);
			User user=(User)request.getAttribute("user");
			IUser userImpl=boFactory.getUser();
			if(userImpl.validateUser(user)){
				if(userImpl.login(user)){
					HttpSession session=request.getSession();
					session.setAttribute("username", user.getUsername());
					request.getRequestDispatcher("index.jsp").forward(request, response);
					
				}else{
					request.setAttribute("msg", "密码错误");
					request.getRequestDispatcher("login.jsp").forward(request, response);
				}
			}else{
				request.setAttribute("msg", "用户不存在");
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}finally{
			out.close();
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
