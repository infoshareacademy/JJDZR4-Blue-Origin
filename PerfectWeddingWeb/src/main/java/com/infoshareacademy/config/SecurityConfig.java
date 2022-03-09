package com.infoshareacademy.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    private static final String HOME_PAGE = "/";
    private static final String PROVIDERS = "/providers";
    private static final String PROVIDERS_RATE = "/providers/rate/{id}";
    private static final String FIND = "/find";
    private static final String SIGN_IN_PAGE = "/sign-in";
    private static final String SIGN_IN_API = "/api/sign-in";
    private static final String SIGN_OUT_API = "/api/sign-out";

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/css/**", "/bootstrap/**", "/assets/bootstrap-solid.svg"
                        , "/validation.css", "/ICON.jpg", "/LOGO.jpg",
                        HOME_PAGE,
                        SIGN_IN_PAGE,
                        FIND,
                        PROVIDERS_RATE,
                        SIGN_IN_API).permitAll()
                .antMatchers("/users").hasRole("ADMIN")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage(SIGN_IN_PAGE)
                .loginProcessingUrl(SIGN_IN_API)
                .defaultSuccessUrl(HOME_PAGE, true)
                .failureUrl(SIGN_IN_PAGE + "?error")
                .and()
                .logout()
                .logoutUrl(SIGN_OUT_API)
                .invalidateHttpSession(true)
                .deleteCookies("JSESSIONID")
                .logoutSuccessUrl(HOME_PAGE);
    }

/*    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("admin")
                .password("{bcrypt}$2a$12$NID.YIxlFe/Au92P0zbaquwb1/.GR8vkd2mKgZDaj4Np3IQ54JNAO")
                .roles("ADMIN");
    }*/
}