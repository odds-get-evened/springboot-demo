package gov.ny.its.mentor_demo.security;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;

/**
 * primary configuration for application security
 */
@Configuration
@EnableWebSecurity
public class MentorSecurityConfig {
	private final Environment environment;

	public MentorSecurityConfig(Environment environment) {
		this.environment = environment;
	}

	@Bean
	public SecurityFilterChain configure(HttpSecurity sec) throws Exception {
		sec.authorizeHttpRequests((auth) -> {
			auth.requestMatchers("/login/**", "/account/register", "/logout").permitAll();
			auth.requestMatchers("/secret/**").authenticated();
			auth.anyRequest().permitAll();
		});

		/*
		 * @todo bypass the auth0 logout confirmation (defaults to this for some reason)
		 */
		sec.logout((logout) -> {
			logout.logoutUrl("/logout");
			logout.logoutSuccessUrl("/");
			logout.invalidateHttpSession(true);
			logout.deleteCookies("JSESSIONID");
		});

		// assign the Okta login to the security instance
		sec.oauth2Login(Customizer.withDefaults());

		return sec.build();
	}
}
