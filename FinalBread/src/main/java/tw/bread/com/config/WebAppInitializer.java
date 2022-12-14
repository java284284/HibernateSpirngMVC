package tw.bread.com.config;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.Filter;

//相當於web.xml的java程式組態
public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override // 用來設定相當於beans.config.xml or application.xml的java程式組態類別
	protected Class<?>[] getRootConfigClasses() {
//		return null;
		return new Class[] { RootAPPConfig.class };
	}

	@Override // 用來設定相當於mvc-servlet.xml的java程式組態類別
	protected Class<?>[] getServletConfigClasses() {
		return new Class[] { WebAppConfig.class };
//		return null;
	}

	@Override // 用來設定DispathcerServlet URL Pattern
	protected String[] getServletMappings() {
		return new String[] { "/" };
//		return null;
	}

	@Override
	protected Filter[] getServletFilters() {
		CharacterEncodingFilter encodeFilter = new CharacterEncodingFilter("UTF-8", true);
		return new Filter[] { encodeFilter };
	}

}
