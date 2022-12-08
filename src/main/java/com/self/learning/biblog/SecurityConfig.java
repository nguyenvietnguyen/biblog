package com.self.learning.biblog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.session.HttpSessionEventPublisher;

@EnableWebSecurity
@Configuration
public class SecurityConfig {
	@Autowired
	LoginSuccessHandler loginSuccessHandler;
	
	@Bean
	public HttpSessionEventPublisher httpSessionEventPublisher() {
	    return new HttpSessionEventPublisher();
	}
	
	@Bean
	public SecurityFilterChain filterChain1(HttpSecurity http) throws Exception {
		http.sessionManagement(session->session.maximumSessions(1)  .expiredUrl("/sessionExpired.html").and().invalidSessionUrl("/login").sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED));
		http.authorizeHttpRequests((requests) -> requests
				.requestMatchers("/","/home","/contact","/category/**","/register","/login","/client/**","/post-detail/**","/logout")
				.permitAll()
				.requestMatchers("/admin/**")
				.hasAnyRole("admin")
				.requestMatchers("/client/**")
				.hasAnyRole("customer")
				.requestMatchers("/admin/**","/client/**")
				.authenticated()
				)
		.formLogin()
		.loginPage("/login")
		.loginProcessingUrl("/login")
		.successHandler(loginSuccessHandler)
		.usernameParameter("username")
		.passwordParameter("password")
		.failureUrl("/login")
		.permitAll()
				.and().logout((logout) -> logout.logoutUrl("/logout").logoutSuccessUrl("/").deleteCookies("JSESSIONID").permitAll());
		return http.build();
	}

	@Bean
	public UserDetailsService userDetailService() {
		return new UserDetailsServiceImpl();
	}

	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
		authProvider.setUserDetailsService(userDetailService());
		authProvider.setPasswordEncoder(new BCryptPasswordEncoder());
		return authProvider;
	}
}
