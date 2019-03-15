package com.erfinfeluzy.training.config;

import javax.xml.ws.Endpoint;

import org.apache.cxf.Bus;
import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.feature.LoggingFeature;
import org.apache.cxf.jaxws.EndpointImpl;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.erfinfeluzy.training.spring.soap.CustomerSoapService;
import com.erfinfeluzy.training.spring.soap.CustomerSoapServiceImpl;

@SuppressWarnings("deprecation")
@Configuration
public class SOAPConfig {
	
	/** SOAP producer **/

	@Bean
	public ServletRegistrationBean cxfDispatcherServlet() {
		return new ServletRegistrationBean(new CXFServlet(), "/soap/*");
	}

	@Bean(name = Bus.DEFAULT_BUS_ID)
	public SpringBus springBus() {
		SpringBus springBus = new SpringBus();
		return springBus;
	}

	@Bean
	public Endpoint endpoint() {
		EndpointImpl endpoint = new EndpointImpl(springBus(), customerSoapService());
		endpoint.getFeatures().add(new LoggingFeature());
		endpoint.publish("/CustomerService");
		return endpoint;
	}
	
	@Bean
	public CustomerSoapService customerSoapService() {
		return new CustomerSoapServiceImpl();
	}
	
	/** SOAP consumer **/
	
	@Bean(name = "client")
	public CustomerSoapService customerServiceProxy() {
	    return (CustomerSoapService) proxyFactoryBean().create();
	}
	
	@Bean
	public JaxWsProxyFactoryBean proxyFactoryBean() {
	    JaxWsProxyFactoryBean proxyFactory = new JaxWsProxyFactoryBean();
	    proxyFactory.setServiceClass(CustomerSoapService.class);
	    proxyFactory.setAddress("http://localhost:8080/soap/CustomerService");
	    return proxyFactory;
	}

}
