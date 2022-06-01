package gamersFun.com.example.gamersFun.configuration;


import gamersFun.com.example.gamersFun.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
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

    public static final String BLOGGER_ROLE = "ROLE_BLOGGER",
                               ADMIN_ROLE = "ROLE_ADMIN",
                                USER_ROLE="ROLE_USER";

    @Override
    protected void configure(HttpSecurity http) throws Exception {
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
                        "/confirmRegister",
                        "/adminConsole",
                        "/deleteCategory**",
                        "/addCategory**",
                        "/editCategory**",
                        "/adminConsole**",
                        "/getShopPage**",
                        "/enableUser**",
                        "/updateUser**",
                        "/addNewsPage**",
                        "/deleteNewsPage**",
                        "/addUser**",
                        "/shopAccount",
                        "/blogPhoto/*"
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
                        "/viewBlogs",
                        "/editBlog",
                        "/deleteBlog")
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
