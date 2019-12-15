package xatu.lcl;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginManage
 */
@WebServlet("/LoginManage")
public class LoginManage extends HttpServlet {

       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginManage() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out  = response.getWriter();
		String username  = request.getParameter("username");
		String passwd = request.getParameter("passwd");
		String quick = request.getParameter("freeLogin");
		if(!"".equals(username) && !"".equals(passwd) ) {
			out.print("登录成功");
			Cookie cook = new Cookie("username","user");
			if(("fastway".equals(quick))) {
				cook.setMaxAge(3600*24*14);
			}
			
			response.addCookie(cook);
		}
		
		else {
			out.print("用户名或者密码错误");
		}
	}

}
