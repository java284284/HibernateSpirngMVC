package tw.bread.com.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import tw.bread.com.model.UserService;
import tw.bread.com.model.Users;

@Controller
@SessionAttributes("users")  
public class LonginController {

	@Autowired
	private UserService uService;

	@PostMapping(path = "/loginaction.controller", produces = "text/pain;charset=UTF-8")
	public String processAction(@RequestParam("phone") String phone, @RequestParam("pwd") String pwd,Model m) {
		Users u = uService.checkLogin(new Users(phone,pwd));
		if(u==null) {
		m.addAttribute("message", "登入失敗,請重新登入");
		return "login";
		}
		m.addAttribute("users",u);
		
		return "redirect:bread.com";
	}
}
