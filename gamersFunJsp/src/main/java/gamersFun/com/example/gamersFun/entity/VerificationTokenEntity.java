package gamersFun.com.example.gamersFun.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Date;

@Entity
@Table(name = "verification")
@Data
@EqualsAndHashCode
public class VerificationTokenEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "token")
    private String token;

    @OneToOne(targetEntity = UserEntity.class)
    @JoinColumn(name = "user_id",nullable = false)
    private UserEntity user;

    @Column(name = "token_type")
    @Enumerated
    private TokenTypeEntity tokenType;

    @Column(name = "expiry_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date expire;

    public VerificationTokenEntity(){

    }
    public VerificationTokenEntity(UserEntity userEntity, TokenTypeEntity tokenType, String token){
        this.user = userEntity;
        this.tokenType = tokenType;
        this.token = token;
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
