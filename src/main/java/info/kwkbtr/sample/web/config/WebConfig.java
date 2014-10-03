package info.kwkbtr.sample.web.config;

import info.kwkbtr.sample.web.service.Service;

import java.util.HashSet;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.wink.spring.Registrar;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

import com.fasterxml.jackson.jaxrs.base.JsonMappingExceptionMapper;
import com.fasterxml.jackson.jaxrs.base.JsonParseExceptionMapper;
import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;

@Configuration
@ImportResource("classpath:META-INF/server/wink-core-context.xml")
@ComponentScan(basePackages = {"info.kwkbtr.sample.web.service"})
public class WebConfig {
	
	@Resource
	private Set<Service> services;
	private Set<Object> getServices() {
		return new HashSet<Object>(services);
	}
	
	@Bean
	public Registrar winkRegistrar() {
		Registrar registrar = new Registrar();
		registrar.setInstances(getServices());

		Set<Class<?>> providers = new HashSet<>();
		providers.add(JacksonJsonProvider.class);
		providers.add(JsonMappingExceptionMapper.class);
		providers.add(JsonParseExceptionMapper.class);
		registrar.setClasses(providers);

		return registrar;
	}


}
