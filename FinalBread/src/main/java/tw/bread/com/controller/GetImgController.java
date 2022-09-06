package tw.bread.com.controller;

import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import tw.bread.com.model.Products;
import tw.bread.com.model.ProductsService;

@Controller
public class GetImgController {

	@Autowired
	private ProductsService pService;

	@GetMapping(path = "/imgaction.controller")
	public void processAction(@RequestParam("id") int id, HttpServletResponse response) throws IOException {
		Products p = pService.sProduct(id);
		byte[] bytes = p.getPhoto();
		response.setContentType(MediaType.IMAGE_JPEG_VALUE);
		OutputStream out = response.getOutputStream();
		out.write(bytes);
		out.flush();
		out.close();
		
	}
	

}
