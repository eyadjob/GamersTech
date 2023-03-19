package gamersFun.com.example.gamersFun.configuration;


import gamersFun.com.example.gamersFun.entity.UserEntity;
import gamersFun.com.example.gamersFun.service.BlogsModule;
import gamersFun.com.example.gamersFun.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.security.Principal;
import java.util.Collection;
import java.util.List;

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
                                USER_ROLE="ROLE_USER",
                                SESSION_USER_ATTRIBUTE="connectedUser";



    @Autowired
    private CustomOAuth2UserService oauthUserService;

    @Autowired
    private BlogsModule blogsModule;

    private static final Logger logger = LoggerFactory.getLogger(WebSecurityConfig.class);

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
                        "/blogPhoto/*",
                        "/addComment"
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
                        String userName = "";
                        HttpSession session = request.getSession();
                        Collection<GrantedAuthority> authorities = null;
                        if(authentication.getPrincipal() instanceof Principal ) {
                            userName = ((Principal)authentication.getPrincipal()).getName();
                            session.setAttribute("role", "none");
                        }else {
                            OAuth2User userSpringSecu = (OAuth2User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
                            UserEntity userEntity = userService.processOAuthPostLogin(oauthUser.getEmail());
                            session.setAttribute("role", String.valueOf( userSpringSecu.getAuthorities()));
                           /* List<GrantedAuthority> authorities = jwtTokenService.getAuthoritiesFromToken(token);
                            UsernamePasswordAuthenticationToken authentication =
                                    new UsernamePasswordAuthenticationToken(email, null, authorities);
                            authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                            SecurityContextHolder.getContext().setAuthentication(authentication);*/

                            SecurityContextHolder.getContext().setAuthentication(authentication);
                            session.setAttribute( SESSION_USER_ATTRIBUTE , userEntity);
                        }

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
