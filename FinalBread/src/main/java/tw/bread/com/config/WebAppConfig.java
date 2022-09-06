package tw.bread.com.config;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

//相當於mvc-servlet.xml java程式組態
@Configuration
@ComponentScan(basePackages = { "tw.bread.com" })
@EnableWebMvc
public class WebAppConfig implements WebMvcConfigurer {
	
	@Bean
	public MappingJackson2JsonView jsonView() {
		MappingJackson2JsonView jsonView1=new MappingJackson2JsonView();
		jsonView1.setPrettyPrint(true);
		return jsonView1;
	}

	@Bean
	public Jaxb2Marshaller jaxMarshaller() {
		Jaxb2Marshaller jaxb2=new Jaxb2Marshaller();
		jaxb2.setPackagesToScan("tw.bread.com");
		return jaxb2;
	}
	
	@Bean
	public ContentNegotiatingViewResolver contentViewResolver() {
		ContentNegotiatingViewResolver cnvr1=new ContentNegotiatingViewResolver();
		ArrayList<View> list=new ArrayList<View>();
		list.add(jsonView());
		cnvr1.setDefaultViews(list);
		return cnvr1;
	}
	
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}

	@Bean
	public InternalResourceViewResolver viewResolver() {
		InternalResourceViewResolver irvr1 = new InternalResourceViewResolver();
		irvr1.setPrefix("/WEB-INF/pages/");
		irvr1.setSuffix(".jsp");
		irvr1.setOrder(6);
		return irvr1;
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/img/**").addResourceLocations("/WEB-INF/resources/img/");
		registry.addResourceHandler("/css/**").addResourceLocations("/WEB-INF/resources/css/");
	}

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addRedirectViewController("/", "bread.com");
		registry.addViewController("/happyday.wonderland").setViewName("form");
	}

	@Bean
	public CommonsMultipartResolver multipartResolver() {
		CommonsMultipartResolver cmr1 = new CommonsMultipartResolver();
		cmr1.setDefaultEncoding("UTF-8");
		return cmr1;
	}

}
