package local;

import javax.servlet.Filter;

import org.springframework.boot.SpringApplication;
import local.controller.security.TokenFilter;
//import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

//@EnableAutoConfiguration
@SpringBootApplication
public class MercadoWebApplication {

	@Bean
    public FilterRegistrationBean getFiltroJWT() {
		System.out.println("entrei no filter");
		FilterRegistrationBean frb = new FilterRegistrationBean();
		frb.setFilter(new TokenFilter());
		System.out.println("perto do return");
		frb.addUrlPatterns("/admin/*");
		return frb;
	}
	
	
	public static void main(String[] args) {
		SpringApplication.run(MercadoWebApplication.class, args);
	}
}
