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
    private static final String ALL_PROVIDERS = "/all-providers";
    private static final String PROVIDERS_RATE = "/providers/rate/{id}";
    private static final String PROVIDERS_RATE_Id = "/providers/rateById";
    private static final String FIND = "/find";
    private static final String SIGN_IN_PAGE = "/sign-in";
    private static final String SIGN_IN_API = "/api/sign-in";
    private static final String SIGN_OUT_API = "/api/sign-out";
    private static final String RATE_PROVIDER = "/providers/rated/{id}";

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/css/**", "/bootstrap/**", "/assets/bootstrap-solid.svg"
                        , "/validation.css", "/ICON.jpg", "/LOGO.jpg",
                        HOME_PAGE,
                        FIND,
                        PROVIDERS_RATE,
                        PROVIDERS_RATE_Id,
                        ALL_PROVIDERS,
                        SIGN_IN_PAGE,
                        SIGN_IN_API,
                        RATE_PROVIDER).permitAll()
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
                .logoutSuccessUrl(HOME_PAGE)
                .and()
                .exceptionHandling().accessDeniedPage("/403");
    }
}