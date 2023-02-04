package gamersFun.com.example.gamersFun.configuration;


import gamersFun.com.example.gamersFun.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

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

    @Autowired
    private CustomOAuth2UserService oauthUserService;

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
                        "/showBlog**",
                        "/oauth/**",
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
                .oauth2Login()
                .loginPage("/login")
                .userInfoEndpoint()
                .userService(oauthUserService)
                .and()
                .successHandler(new AuthenticationSuccessHandler() {
                    @Override
                    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
                        System.out.println("AuthenticationSuccessHandler invoked");
                        System.out.println("Authentication name: " + authentication.getName());
                        CustomOAuth2User oauthUser = new CustomOAuth2User( (OAuth2User) authentication.getPrincipal());
                        userService.processOAuthPostLogin(oauthUser.getEmail());
                        response.sendRedirect("/");
                    }
                }).and()
                .logout().logoutSuccessUrl("/").permitAll()
                .and()
                .exceptionHandling().accessDeniedPage("/403")
        ;
                /*.logout()
                .permitAll();*/

        // @formatter:on
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth)
            throws Exception {
        auth.userDetailsService(userService).passwordEncoder(passwordEncoder);
    }
}
