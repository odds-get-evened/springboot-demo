package gov.ny.its.mentor_demo.config;

import gov.ny.its.mentor_demo.util.SHAPasswordEncoder;
import nz.net.ultraq.thymeleaf.LayoutDialect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class MentorAppConfig {
	/**
	 * using SHA encoded passwords instead of the standard database encoding.
	 * @return the password encoder instance
	 */
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new SHAPasswordEncoder();
	}

	/**
	 * tells the template engine how to use thymeleaf layouts
	 * @return the layout
	 */
	@Bean
	public LayoutDialect layoutDialect() {
		return new LayoutDialect();
	}
}
