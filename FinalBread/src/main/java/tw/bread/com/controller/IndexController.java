package tw.bread.com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

	@GetMapping("/bread.com")
	public String processAction() {
		return "index";
	}
	@GetMapping("/login.com")
	public String processAction1() {
		return "login";
	}
	@GetMapping("/shop.com")
	public String processAction2() {
		return "shop";
	}
	@GetMapping("/signup.com")
	public String processAction3() {
		return "signup";
	}
	@GetMapping("/admin.com")
	public String processAction4() {
		return "admin";
	}
	@GetMapping("/shoppingCart.com")
	public String processAction5() {
		return "shoppingCart";
	}
	@GetMapping("/add.com")
	public String processAction6() {
		return "addProduct";
	}


}
