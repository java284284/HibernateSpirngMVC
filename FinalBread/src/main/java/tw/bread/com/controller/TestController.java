package tw.bread.com.controller;

import java.io.IOException;
import java.util.Base64;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class TestController {
	
	@GetMapping("/t")
	public String processAction() {
		return "test";
	}

	@PostMapping("/testaction.controller")
	public @ResponseBody String test(@RequestParam("productName") String n, @RequestParam("productPrice") int p,
									 @RequestParam("productImg") MultipartFile file) throws IOException {
		String dataType="data:image/png;Base64,";
		byte[] bytes=file.getBytes();
		String ImgBase64String=Base64.getEncoder().encodeToString(bytes);
		
		return dataType+ImgBase64String;
	}

}
