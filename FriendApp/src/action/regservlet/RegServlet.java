package action.regservlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bo.IUser;
import model.bo.boFactory;
import model.dto.User;

/**
 * Servlet implementation class RegServlet
 */
@WebServlet("/RegServlet")
public class RegServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		try {
//			String username=request.getParameter("username");
//			String password=request.getParameter("password");
//			User user=new User();
//			user.setPassword(password);
//			user.setUsername(username);
			request.getRequestDispatcher("user.jsp").include(request, response);
			User user=(User)request.getAttribute("user");
			IUser userImpl=boFactory.getUser();
			if(userImpl.validateUser(user)){
				request.setAttribute("msg", "用户已经存在");
				request.getRequestDispatcher("reg.jsp").forward(request, response);
				
			}else if(user.getUsername()==""||user.getPassword()==""){
				request.setAttribute("msg", "用户名或密码不能为空");
				request.getRequestDispatcher("reg.jsp").forward(request, response);
			}
			else {
				userImpl.addUser(user);
				request.setAttribute("msg", "注册成功，请登录");
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			
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
