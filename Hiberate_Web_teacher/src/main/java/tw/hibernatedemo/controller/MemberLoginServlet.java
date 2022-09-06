package tw.hibernatedemo.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import tw.hibernatedemo.model.MyMember;
import tw.hibernatedemo.service.MemberService;


@WebServlet("/MemberLoginServlet")
public class MemberLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public MemberLoginServlet() {
        super();
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		Map<String, String> errorMsgMap = new HashMap<String, String>();
		
		request.setAttribute("errorMsgMap", errorMsgMap);
		
		HttpSession httpSession = request.getSession();
		
		String username = request.getParameter("username");
		String pwd = request.getParameter("pwd");
		
//		MemberService service = new MemberService();
		WebApplicationContext context = WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());
		
		MemberService service = context.getBean("memberService", MemberService.class);
		
		MyMember tempMember = service.checkLogin(username, pwd);
		
		if(tempMember != null) {
			httpSession.setAttribute("loginMember", tempMember);
		}else {
			errorMsgMap.put("LoginError", "帳號密碼錯誤，請重新輸入");
		}
		
		if(errorMsgMap.isEmpty()) {
			RequestDispatcher rs = request.getRequestDispatcher("loginOK.jsp");
			rs.forward(request, response);
		}else {
			RequestDispatcher rs = request.getRequestDispatcher("login.jsp");
			rs.forward(request, response);
		}
		
	}

}
