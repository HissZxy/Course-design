package xatu.lcl;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginCheck
 */
@WebServlet("/LoginCheck")
public class LoginCheck extends HttpServlet {

    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginCheck() {
        super();
       
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String username = request.getParameter("username");
		PrintWriter out = response.getWriter();
		out.println(username);
		String passwd = request.getParameter("password");
		out.println(passwd);
		String sex    = request.getParameter("sex");
		out.println(sex);
		String[] hobby    = request.getParameterValues("hobby");
		for(int i = 0; i < hobby.length; i++) {
			out.print(hobby[i]+" ");
		}

		String desp    = request.getParameter("desp");
		out.println(desp);
		
		
	}

}
