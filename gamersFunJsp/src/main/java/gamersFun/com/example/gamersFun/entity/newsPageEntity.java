package gamersFun.com.example.gamersFun.entity;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Date;

@Entity
@Table(name = "verification")
public class newsPageEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "token")
    private String token;


    @OneToOne(targetEntity = UserEntity.class)
    @JoinColumn(name = "user_id",nullable = false)
    private UserEntity userEntity;

    @Column(name = "token_type")
    @Enumerated
    private TokenTypeEntity tokenType;

    @Column(name = "expiry_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date expire;

    public newsPageEntity(){

    }

    public newsPageEntity(UserEntity userEntity, TokenTypeEntity tokenType, String token){
        this.userEntity = userEntity;
        this.tokenType = tokenType;
        this.token = token;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public UserEntity getUser() {
        return userEntity;
    }

    public void setUser(UserEntity userEntity) {
        this.userEntity = userEntity;
    }

    public TokenTypeEntity getTokenType() {
        return tokenType;
    }

    public void setTokenType(TokenTypeEntity tokenType) {
        this.tokenType = tokenType;
    }

    public Date getExpire() {
        return expire;
    }

    //TODO: the time should configured
    @PrePersist
    private void setExpireDate(){
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.HOUR,24);
        this.expire = calendar.getTime();
    }

    public void setExpire(Date expire) {
        this.expire = expire;
    }
}
