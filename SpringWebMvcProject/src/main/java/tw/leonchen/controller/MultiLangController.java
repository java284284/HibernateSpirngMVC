package tw.leonchen.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MultiLangController {
	@Autowired
	private MessageSource ms;
	
	@GetMapping("/resultMultilang.controller")
	public String processAction() {
		String errMsg = ms.getMessage("program.error", null, LocaleContextHolder.getLocale());
		System.out.println("Locale:" + LocaleContextHolder.getLocale());
		System.out.println("ErrMsg:" + errMsg);
		return "multiLangResult";
	}

}
