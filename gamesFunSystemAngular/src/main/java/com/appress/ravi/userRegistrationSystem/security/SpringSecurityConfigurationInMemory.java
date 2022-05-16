package com.appress.ravi.userRegistrationSystem.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configurers.provisioning.InMemoryUserDetailsManagerConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

/*@Configuration
@Order(SecurityProperties.)*/
public class SpringSecurityConfigurationInMemory extends WebSecurityConfigurerAdapter{

    /*You configured authentication by creating two users (user and admin) and their roles (USER and ADMIN) and their passwords.*/
    @Autowired
    protected void configureGlobal(AuthenticationManagerBuilder auth)
            throws Exception {

             auth.inMemoryAuthentication().withUser("user").password("{noop}password")
            .roles("USER");

             auth.inMemoryAuthentication().withUser("admin").password("{noop}password")
            .roles("USER", "ADMIN");
    }

   /* @Bean
    public UserDetailsService userDetailsService() {

        User.UserBuilder users = User.withDefaultPasswordEncoder();
        InMemoryUserDetailsManagerConfigurer manager = new InMemoryUserDetailsManager();
        manager.createUser(users.username("user").password("password").roles("USER").build());
        manager.createUser(users.username("admin").password("password").roles("USER", "ADMIN").build());
        return manager;

    }*/

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
                .httpBasic().and()
                .authorizeRequests()
                .antMatchers(HttpMethod.GET, "/api/user/")
                .hasRole("USER")

                .antMatchers(HttpMethod.POST, "/api/user/")
                .hasRole("USER")

                .antMatchers(HttpMethod.PUT, "/api/user/**")
                .hasRole("USER")

                .antMatchers(HttpMethod.DELETE, "/api/user/**")
                .hasRole("ADMIN")
                .and()
                .csrf()
                .disable();//You also disabled cross-site request forgery to restrict any end user from executing unwanted actions.
    }
}
