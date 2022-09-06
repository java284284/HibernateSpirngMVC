package tw.bread.com.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import tw.bread.com.model.Products;
import tw.bread.com.model.ProductsService;

@Controller
public class UpdateProductController {

	@Autowired
	private ProductsService pService;

	@GetMapping("/update.com")
	public String processAction1(@RequestParam("id") int id,Model m) {
		Products p=pService.sProduct(id);
		m.addAttribute("id",id);
		m.addAttribute("name",p.getName());
		m.addAttribute("price",p.getPrice());
		
		
		return "UpdateProduct";
	}

	@PostMapping("/updateaction.controller")
	public String processAction(@RequestParam("id") int id, @RequestParam("productName") String newName,
								@RequestParam("productPrice") int newPrice,@RequestParam("productImg") MultipartFile file,
								HttpServletRequest request, Model m) throws IllegalStateException, IOException {

		byte[] bytes=file.getBytes();

		Products p = pService.updateProduct(id, newName, newPrice, bytes);
		if (p == null) {
			m.addAttribute("message", "修改失敗");
		}
		m.addAttribute("message", "修改成功");
		return "UpdateProduct";
	}
}
