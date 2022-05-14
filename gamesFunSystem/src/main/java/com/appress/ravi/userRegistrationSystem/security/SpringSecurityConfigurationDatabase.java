package com.appress.ravi.userRegistrationSystem.security;


import com.appress.ravi.userRegistrationSystem.services.UserInfoDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SpringSecurityConfigurationDatabase extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserInfoDetailsService userInfoDetailsService;

    @SuppressWarnings("deprecation")
    @Bean
    public static NoOpPasswordEncoder passwordEncoder() {
        return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
    }

    @Override
    protected void configure(
            AuthenticationManagerBuilder authenticationManagerBuilder)
            throws Exception {

        authenticationManagerBuilder
                .userDetailsService(userInfoDetailsService);

    }

/*
    This configuration secures all endpoints and requires authentication to access resources
*/
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.sessionManagement()
/*
        this method begins with requesting Spring Security to not create an HTTP session and not store logged-in users’ SecurityContext values in the session,
*/
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                .antMatchers("/api/user/**")
                .authenticated()
                .and()
                .httpBasic()
                .realmName("User Registration System")
                //You allowed anonymous access to the static resources such as /login/login.html, /template/home.html,
                .and().authorizeRequests()
                .antMatchers("/template/login/login.html", "/template/home.html", "/")
                .permitAll()
                .anyRequest().authenticated()
                .and()
/*
        Spring Security provides a special CsrfTokenRepository to send a cookie. When you start with a clean browser (Ctrl+F5 or incognito in Chrome), the first request to the server has no cookies, but the server sends back Set-Cookie for JSESSIONID (the regular HttpSession) and X-XSRF-TOKEN, which are the CRSF cookies that you set up in Listing 5-10. Subsequent requests will have these cookies, which are important: the Spring Security application doesn’t work without them, and they are providing some really basic security features (authentication and CSRF protection). When you log out, the values of the cookies change. Spring Security expects the token sent to it in a header called X-CSRF. From the initial request that loads the home page, the value of the CSRF token was available in the HttpRequest attributes on the server side. Angular has built-in support for CSRF (which it calls XSRF) based on cookies. Angular wants the cookie name to be XSRF-TOKEN, and the best part of Spring Security is that it provides it as a request attribute by default.
*/
                .csrf()
                .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse());
/*
, you disabled CSRF for HTTP methods to keep things simple. CSRF is a type of security vulnerability whereby a malicious web site forces users to execute unwanted commands on another web site in which they are currently authenticated. By default, Spring Security enables CSRF protection and is highly recommended when requests are submitted by a user via a browser. For services (REST) that are used by nonbrowser clients, CSRF can be disabled.*/
                /*.csrf()
                .disable();*/



    }

}
