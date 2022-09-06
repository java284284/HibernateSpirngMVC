package tw.bread.com.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import tw.bread.com.model.Products;
import tw.bread.com.model.ProductsService;

@Controller
public class GetAllProduct {

	@Autowired
	private ProductsService pService;
	
	@GetMapping(path = "/getallaction.controller", produces = "text/pain;charset=UTF-8")
	public String processAction(Model m)  {
		List<Products> list = pService.readAllProducts();
		m.addAttribute("allProducts",list);
		
		return "shop";
		
	}
}
