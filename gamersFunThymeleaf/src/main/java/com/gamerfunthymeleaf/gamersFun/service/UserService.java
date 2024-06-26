package com.gamerfunthymeleaf.gamersFun.service;


import com.gamerfunthymeleaf.gamersFun.entity.User;
import com.gamerfunthymeleaf.gamersFun.repository.UserDao;
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

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserDao userDao;

//    @Autowired
//    private PasswordEncoder passwordEncoder;


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
}
