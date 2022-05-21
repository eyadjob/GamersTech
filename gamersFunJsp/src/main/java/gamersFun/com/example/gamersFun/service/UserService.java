package gamersFun.com.example.gamersFun.service;


import gamersFun.com.example.gamersFun.entity.TokenType;
import gamersFun.com.example.gamersFun.entity.User;
import gamersFun.com.example.gamersFun.entity.VerificationToken;
import gamersFun.com.example.gamersFun.repository.UserDao;
import gamersFun.com.example.gamersFun.repository.VerificationDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
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


    public void register(User siteUser){
        //siteUser.setPassword(passwordEncoder.encode(siteUser.getPassword())); no need cause i used plain password and then encryot it in setter
        siteUser.setRole("ROLE_USER");// DEFAULT TO USER ROLE_USER  for admin use ROLE_ADMIN
        userDao.save(siteUser);
    }
    public void save(User siteUser){
        userDao.save(siteUser);
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userDao.findByEmail(email);
        if(user == null){
            return null;
        }

        List<GrantedAuthority> auth = AuthorityUtils.commaSeparatedStringToAuthorityList(user.getRole());

        //String password = passwordEncoder.encode(user.getPassword());

        return new org.springframework.security.core.userdetails.User(email,user.getPassword(),user.isEnabled(),true,true,true,auth);
    }



    public User getUser(String email) {
        return userDao.findByEmail(email);
    }

    public Optional<User> get(Long id) {
        return userDao.findById(id);
    }


    public String createVerificationToken(User user, TokenType tokenType){
        VerificationToken token = new VerificationToken(user,tokenType,UUID.randomUUID().toString());
        tokenDao.save(token);
        return token.getToken();
    }


    public VerificationToken getVerification(String token){
        return tokenDao.findByToken(token);

    }


    public void deleteToken(VerificationToken token){
        tokenDao.delete(token);
    }
}
