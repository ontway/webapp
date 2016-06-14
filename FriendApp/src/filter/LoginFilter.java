package filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class LoginFilter
 */
@WebFilter("/*")
public class LoginFilter implements Filter {

    /**
     * Default constructor. 
     */
    public LoginFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		try {
			request.setCharacterEncoding("UTF-8");
			HttpServletRequest req=(HttpServletRequest)request;
			HttpServletResponse resp=(HttpServletResponse)response;
			String path=req.getServletPath();
			HttpSession session=req.getSession();
			String username=(String)session.getAttribute("username");
			boolean b1=path.endsWith("login.jsp");
			boolean b2=path.endsWith("error.jsp");
			boolean b3=path.endsWith("LoginServlet");
			boolean b4=path.endsWith("reg.jsp");
			boolean b5=path.endsWith("RegServlet");
			boolean b6=(username!=null);
			if(b1||b2||b3||b4||b5||b6){
				chain.doFilter(request, response);
			}else {
				resp.sendRedirect("error.jsp");
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
