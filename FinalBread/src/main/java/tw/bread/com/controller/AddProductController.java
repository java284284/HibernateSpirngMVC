package tw.bread.com.controller;

import java.io.File;
import java.io.IOException;
import java.util.Base64;
import java.util.List;

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
public class AddProductController {

	@Autowired
	private ProductsService pService;

	@PostMapping(path = "/addproductaction.controller", produces = "text/pain;charset=UTF-8")
	public String processAction(@RequestParam("productName") String name, @RequestParam("productPrice") int price,
								@RequestParam("productImg") MultipartFile file,HttpServletRequest request,Model m) throws IOException {
		
		byte[] bytes=file.getBytes();
		
		Products p = pService.addProduct(name, price,bytes);
		if (p == null) {
			m.addAttribute("message", "新增失敗");
		}
		m.addAttribute("message", "新增成功");
		return "addProduct";

	}

}
