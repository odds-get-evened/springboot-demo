package gov.ny.its.mentor_demo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

/**
 * primary configuration for application security
 */
@Configuration
@EnableWebSecurity
public class MentorSecurityConfig {
	@Bean
	public SecurityFilterChain configure(HttpSecurity sec) throws Exception {
		sec.authorizeHttpRequests((auth) -> {
			auth.requestMatchers("/login/**").permitAll();
			auth.requestMatchers("/secret/**").authenticated();
			auth.anyRequest().permitAll();
		});

		sec.oauth2Login(Customizer.withDefaults());

		return sec.build();
	}
}
