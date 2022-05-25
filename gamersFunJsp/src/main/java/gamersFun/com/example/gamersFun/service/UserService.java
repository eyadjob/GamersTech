package gamersFun.com.example.gamersFun.service;


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
import org.springframework.security.web.servletapi.SecurityContextHolderAwareRequestWrapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private VerificationDao tokenDao;

    public void register(UserEntity siteUserEntity){
        //siteUser.setPassword(passwordEncoder.encode(siteUser.getPassword())); no need cause i used plain password and then encryot it in setter
        siteUserEntity.setRole("ROLE_USER");// DEFAULT TO USER ROLE_USER  for admin use ROLE_ADMIN
        userDao.save(siteUserEntity);
    }
    public void save(UserEntity siteUserEntity){
        userDao.save(siteUserEntity);
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserEntity userEntity = userDao.findByEmail(email);
        if(userEntity == null){
            return null;
        }

        List<GrantedAuthority> auth = AuthorityUtils.commaSeparatedStringToAuthorityList(userEntity.getRole());

        //String password = passwordEncoder.encode(user.getPassword());

        return new org.springframework.security.core.userdetails.User(email, userEntity.getPassword(), userEntity.isEnabled(),true,true,true,auth);
    }

    public UserEntity getUser(String email) {
        return userDao.findByEmail(email);
    }

    public Optional<UserEntity> get(Long id) {
        return userDao.findById(id);
    }


    public String createVerificationToken(UserEntity userEntity, TokenTypeEntity tokenType){
        VerificationTokenEntity token = new VerificationTokenEntity(userEntity,tokenType,UUID.randomUUID().toString());
        tokenDao.save(token);
        return token.getToken();
    }
    public VerificationTokenEntity getVerification(String token){
        return tokenDao.findByToken(token);

    }

    public void deleteToken(VerificationTokenEntity token){
        tokenDao.delete(token);
    }

    public UserEntity getUser(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        return userDao.findByEmail(email);

    }
}
