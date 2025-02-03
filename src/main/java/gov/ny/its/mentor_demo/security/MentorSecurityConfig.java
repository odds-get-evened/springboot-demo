package gov.ny.its.mentor_demo.security;

import gov.ny.its.mentor_demo.util.SHAPasswordEncoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.password.PasswordEncoder;
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
			auth.requestMatchers("/login/**", "/account/register").permitAll();
			auth.requestMatchers("/secret/**").authenticated();
			auth.anyRequest().permitAll();
		});

		sec.oauth2Login(Customizer.withDefaults());

		return sec.build();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new SHAPasswordEncoder();
	}
}
