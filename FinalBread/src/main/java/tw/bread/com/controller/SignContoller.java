package tw.bread.com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import tw.bread.com.model.UserService;
import tw.bread.com.model.Users;

@Controller
public class SignContoller {

	@Autowired
	private UserService uService;

	@PostMapping(path = "/signaction.controller", produces = "text/pain;charset=UTF-8")
	public String processAction(@RequestParam("phone") String phone, @RequestParam("name") String name,
								@RequestParam("birthday") String birthday,@RequestParam("pid") String pid,
								@RequestParam("pwd") String pwd,Model m) {
		Users u=uService.Sign(phone, name, birthday, pid, pwd);
		if (u == null) {
			m.addAttribute("message", "註冊失敗");
		}
		m.addAttribute("message", "註冊成功");
		return "login";

	}

}
