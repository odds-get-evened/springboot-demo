package gov.ny.its.mentor_demo.security;

import gov.ny.its.mentor_demo.util.SHAPasswordEncoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new SHAPasswordEncoder();
	}

	// configure secure areas of application
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity sec) throws Exception {
		sec.authorizeHttpRequests(
				(req) -> {
					req.requestMatchers("/inv/**").authenticated();
					req.anyRequest().permitAll();
				}
		);

		return sec.build();
	}
}
