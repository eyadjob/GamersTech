package gamersFun.com.example.gamersFun.service;


import gamersFun.com.example.gamersFun.configuration.WebSecurityConfig;
import gamersFun.com.example.gamersFun.entity.TokenTypeEntity;
import gamersFun.com.example.gamersFun.entity.UserEntity;
import gamersFun.com.example.gamersFun.entity.VerificationTokenEntity;
import gamersFun.com.example.gamersFun.repository.UserDao;
import gamersFun.com.example.gamersFun.repository.VerificationDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.net.http.HttpRequest;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserDao userDao;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private VerificationDao tokenDao;

    @Autowired
    GenericDaoService genericDaoService;

    public void register(UserEntity siteUserEntity) {
        //siteUser.setPassword(passwordEncoder.encode(siteUser.getPassword())); no need cause i used plain password and then encryot it in setter
        siteUserEntity.setRole("ROLE_USER");// DEFAULT TO USER ROLE_USER  for admin use ROLE_ADMIN
        userDao.save(siteUserEntity);
    }

    public void save(UserEntity siteUserEntity) {
        userDao.save(siteUserEntity);
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserEntity userEntity = userDao.findByEmail(email);
        if (userEntity == null) {
            return null;
        }

        List<GrantedAuthority> auth = AuthorityUtils.commaSeparatedStringToAuthorityList(userEntity.getRole());

        //String password = passwordEncoder.encode(user.getPassword());

        return new org.springframework.security.core.userdetails.User(email, userEntity.getPassword(), userEntity.isEnabled(), true, true, true, auth);
    }

    public UserEntity getUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        return userDao.findByEmail(email);
    }

    public UserEntity getUser(HttpServletRequest request) {
        Object userAttr = request.getSession().getAttribute(WebSecurityConfig.SESSION_USER_ATTRIBUTE);
        UserEntity user = null;
        if(userAttr != null){
             user = (UserEntity) userAttr;
        }
        return user;
    }

    public Optional<UserEntity> get(Long id) {
        return userDao.findById(id);
    }

    public String createVerificationToken(UserEntity userEntity, TokenTypeEntity tokenType) {
        VerificationTokenEntity token = new VerificationTokenEntity(userEntity, tokenType, UUID.randomUUID().toString());
        tokenDao.save(token);
        return token.getToken();
    }

    public VerificationTokenEntity getVerification(String token) {
        return tokenDao.findByToken(token);

    }

    public void deleteToken(VerificationTokenEntity token) {
        tokenDao.delete(token);
    }

    public void enableUser(Long userId, boolean enableUser) {
        Optional<UserEntity> userEntityOptional = userDao.findById(userId);
        if (enableUser) userEntityOptional.orElseThrow().setEnabled(true);
        else userEntityOptional.orElseThrow().setEnabled(false);
        userDao.save(userEntityOptional.orElseThrow());
    }

    public void updateUser(UserEntity userEntity) {
        userDao.save(userEntity);
    }

    public List getListOfUsersWithRecordsSizeAndSorting2(int pageIndex, int recordsSize, String sortingType) {
        return genericDaoService.getListRecordsWithRecordsSizeAndSorting(pageIndex,recordsSize,sortingType,userDao);
    }


    public UserEntity processOAuthPostLogin(String username) {
        UserEntity existUser = userDao.findByEmail(username);

        if (existUser == null) {
            UserEntity newUser = new UserEntity();
            newUser.setUserName(new Random().ints(10,0,10).mapToObj(Integer::toString).collect(Collectors.joining("")));
            newUser.setEmail(username);
            newUser.setRole("ROLE_USER");
            newUser.setEnabled(true);
            existUser = userDao.save(newUser);
        }

        return existUser;

    }

}
