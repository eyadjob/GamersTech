package gamersFun.com.example.gamersFun.service;


import gamersFun.com.example.gamersFun.entity.Profile;
import gamersFun.com.example.gamersFun.entity.UserEntity;
import gamersFun.com.example.gamersFun.entity.UserEntity;
import gamersFun.com.example.gamersFun.repository.ProfileDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfileService {

    @Autowired
    public ProfileDao profileDao;

    // @PreAuthorize("isAuthenticated()") // works aspect oriendted programming
    public Profile save(Profile profile){
        Profile profile1 = profileDao.save(profile);
        return profile1;
    }

    public Profile getUserProfile(UserEntity user){
        return profileDao.findByUser(user);
    }
}
