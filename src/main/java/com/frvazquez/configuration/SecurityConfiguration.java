package com.frvazquez.configuration;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


/**
 * The Class SecurityConfiguration.
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	/** The Constant LOG. */
	private static final Log LOG = LogFactory.getLog(SecurityConfiguration.class);
	
	/** The user service. */
	@Autowired
	@Qualifier("userService")
	private UserDetailsService userService;

	/**
	 * Configure global.
	 *
	 * @param auth the auth
	 * @throws Exception the exception
	 */
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		LOG.info("Security method manager authentication");
		auth.userDetailsService(userService).passwordEncoder(new BCryptPasswordEncoder());		
	}

	/* (non-Javadoc)
	 * Permisos de de acceso a los recurso del proyecto
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		LOG.info("MEthos Permit ALL");
		http.authorizeRequests()
			.antMatchers("/css/*", "/imgs/*").permitAll()
			.anyRequest().authenticated()
			.and()
			.formLogin().loginPage("/login").loginProcessingUrl("/logincheck")
			.usernameParameter("username")
			.passwordParameter("password")
			.defaultSuccessUrl("/loginsuccess").permitAll()
			.and()
			.logout().logoutUrl("/logout")
			.logoutSuccessUrl("/login?logout").permitAll();
	}

}
