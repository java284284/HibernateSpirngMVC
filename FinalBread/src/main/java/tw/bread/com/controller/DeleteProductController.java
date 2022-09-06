package tw.bread.com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import tw.bread.com.model.ProductsService;

@Controller
@Transactional
public class DeleteProductController {
	
	@Autowired
	private ProductsService pService;
	
	@GetMapping("/deleteaction.controller")
	public String processAction(@RequestParam("id") int id) {
		pService.deleteProduct(id);
		return "index";
		
	}

}
