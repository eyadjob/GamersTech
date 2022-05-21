package gamersFun.com.example.gamersFun.entity;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Date;

@Entity
@Table(name = "verification")
public class VerificationToken {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "token")
    private String token;


    @OneToOne(targetEntity = User.class)
    @JoinColumn(name = "user_id",nullable = false)
    private User user;

    @Column(name = "token_type")
    @Enumerated
    private TokenType tokenType;

    @Column(name = "expiry_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date expire;

    public VerificationToken(){

    }

    public VerificationToken(User user, TokenType tokenType, String token){
        this.user = user;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public TokenType getTokenType() {
        return tokenType;
    }

    public void setTokenType(TokenType tokenType) {
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
