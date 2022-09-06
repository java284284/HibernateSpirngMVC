package tw.leonchen.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import tw.leonchen.model.Picture;
import tw.leonchen.model.PictureService;

@Controller
public class UploadFileController {
	
	@GetMapping("/fileuploadmain.controller")
	public String processMainAction() {
		return "uploadFile";
	}
	
	@PostMapping(path = "/upload.controller")
	@ResponseBody
	public String processUploadFileAction(@RequestParam("myFiles") MultipartFile mf, HttpServletRequest request) throws IllegalStateException, IOException {
		String fileName = mf.getOriginalFilename();
		
		String saveFileDir = "c:/temp/upload";
		File saveFilePath = new File(saveFileDir,fileName);
		
		//內建getByte取代課本P.168
		byte[] b = mf.getBytes();
		
		mf.transferTo(saveFilePath);
		
		if(fileName!=null && fileName.length()!=0) {
			savePicture(fileName, b);
		}
		
		return "saveFilePath:" + saveFilePath;
	}

	@Autowired
	private PictureService pService;
	
	private void savePicture(String fileName, byte[] b) {
		Picture p = new Picture(fileName, b);
		pService.insert(p);
	}

}
