package br.com.project.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;

import br.com.project.security.AuthenticationFilter;
import br.com.project.security.TokenAuthenticationService;


/**
 * Config de segurança
 * 
 * @author Andre de Jesus
 *
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
//@Profile("default")
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	private final TokenAuthenticationService tokenAuthenticationService;

	public WebSecurityConfig() {
		super(true);
		tokenAuthenticationService = new TokenAuthenticationService();
	}

	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
		httpSecurity.cors().configurationSource(request -> new CorsConfiguration().applyPermitDefaultValues())
				.and().csrf().disable().authorizeRequests()

				.antMatchers("/v2/api-docs", "/configuration/ui", "/swagger-resources", "/configuration/security",
						"/swagger-ui.html", "/webjars/**", "/api/v1/test/**")
				.permitAll().anyRequest().authenticated().and()
				.addFilterBefore(new AuthenticationFilter(tokenAuthenticationService),
						UsernamePasswordAuthenticationFilter.class);

	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/user*", "/auth*", "/v2/api-docs", "/configuration/ui",
				"/swagger-resources/**", "/configuration/security", "/swagger-ui.html", "/webjars/**", "/configuration","/domain/**","/email", "/h2-console/**");
	}


}
