package tw.bread.com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import tw.bread.com.model.Products;
import tw.bread.com.model.ProductsService;

@Controller

public class SearchProductController {

	@Autowired
	private ProductsService pService;
	

	
	@GetMapping(path = "/searchaction.controller", produces = "text/pain;charset=UTF-8")
	public String processAction(@RequestParam("search") String search,Model m)  {
		List<Products> list = pService.searchProducts(search);
		m.addAttribute("allProducts",list);
		
		return "shop";
		
	}
}
