package tw.bread.com.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import tw.bread.com.model.Users;

@Controller
@SessionAttributes("users")  
public class LogOutController {
	
	@GetMapping(path = "/logoutaction.controller")
	public String LogOutAction(@ModelAttribute("users") Users users,HttpSession httpSession,Model m) {
		httpSession.invalidate();
		m.addAttribute("users", null);
		return "redirect:bread.com";
		
	}

}
