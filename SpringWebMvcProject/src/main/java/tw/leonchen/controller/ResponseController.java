package tw.leonchen.controller;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ResponseController {
	
	@GetMapping(path = "/responseaction.controller", produces = "text/pain;charset=UTF-8")
	@ResponseBody
	public String processResponseAction() {
		return "hi, how are you? 我很好 @@";
	}
	
	@GetMapping(path = "/responsenetityaction.controller")
	public ResponseEntity<String> processResponseEntityAction(){
		return new ResponseEntity<String>("Custom Status Code(403 Forbidden)", HttpStatus.FORBIDDEN);
	}
	
	@GetMapping(path = "/responsenetityheadersaction.controller")
	public ResponseEntity<String> processResponseEntityAction2(){
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.TEXT_PLAIN);
		return new ResponseEntity<String>("Custom Status Code(200)", headers, HttpStatus.OK);
	}

	@GetMapping(path = "/responseimageaction.controller")
	public void processImageResourceAction(HttpServletRequest resqust, HttpServletResponse respnse) throws IOException {
		InputStream in = resqust.getServletContext().getResourceAsStream("/WEB-INF/resources/images/images01.jpg");
		IOUtils.copy(in, respnse.getOutputStream());
	}
	
	@GetMapping(path = "/responseimageaction2.controller")
	@ResponseBody
	public byte[] processImageResourceAction2(HttpServletRequest resqust, HttpServletResponse respnse) throws IOException {
		InputStream in = resqust.getServletContext().getResourceAsStream("/WEB-INF/resources/images/images01.jpg");
		return IOUtils.toByteArray(in);
	}
}
