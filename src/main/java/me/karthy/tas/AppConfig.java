package me.karthy.tas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import io.oneclicklabs.transaction.logging.interceptor.RestTransactionInterceptor;
import io.oneclicklabs.transaction.logging.writer.LogWriterManager;

/**
 * Created by oneclicklabs.io
 */
@Configuration
@EnableWebMvc
public class AppConfig extends WebMvcConfigurerAdapter {

	@Autowired
	private AuditInterceptor interceptor;

	@Autowired
	@Qualifier("manager.logwriter")
	private LogWriterManager logWriterManager;

	@Override
	public void addInterceptors(InterceptorRegistry registry) {

		registry.addInterceptor(interceptor);
		registry.addInterceptor(new RestTransactionInterceptor(logWriterManager));

	}

}
