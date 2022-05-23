package gamersFun.com.example.gamersFun.configuration;


import gamersFun.com.example.gamersFun.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true,securedEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        // @formatter:off

        http
                .authorizeRequests()
                //Accessible links for every users
                .antMatchers(
                        "/",
                        "/search",
                        "/author",
                        "/about",
                        "/signup",
                        "/contact",
                        "/invaliduser",
                        "/expiredtoken",
                        "/verifyEmail",
                        "/confirmRegister"


                )
                .permitAll()
                .antMatchers(
                        "/js/*",
                        "/js/**",
                        "/css/*",
                        "/css/**",
                        "scss",
                        "/imgs/**",
                        "/imgs/*")
                .permitAll()
                .antMatchers("/addCategory",
                        "/addNews",
                        "/admin/*"

                        )
                .hasRole("ADMIN")//.access("hasRole('ADMIN')")
                //Accessible links for authenticated to ADMIN users links

                .antMatchers("/addBlogs",
                        "/viewBlogs")
                .hasRole("BLOGGER")
                .antMatchers("/webjars/**",
                        "/profile",
                        "/profile/*",
                        "/editProfile",
                        "/upload-profile-photo",
                        /*"/profilePhoto/*",*/
                        "/save-interest",
                        "/delete-interest")
                .authenticated()
                .anyRequest()
                .denyAll()
                .and()
                .formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/")
                .permitAll()
                .and()
                .logout()
                .permitAll();

        // @formatter:on
    }





    @Override
    protected void configure(AuthenticationManagerBuilder auth)
            throws Exception {
        auth.userDetailsService(userService).passwordEncoder(passwordEncoder);
    }




 }
