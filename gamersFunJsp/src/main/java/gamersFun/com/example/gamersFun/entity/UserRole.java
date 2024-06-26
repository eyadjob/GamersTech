package gamersFun.com.example.gamersFun.entity;


import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "user_role")
//@PasswordMath(message = "{error.password.mismatch}")
public class UserRole {
    public UserRole(){

    }

    // for testing purpose
    public UserRole(String email, String password, String repeatPassword, String firstName){
        this.email = email;
        this.setPlainPassword(password);
        this.repeatPassword = repeatPassword;
        this.enabled = true;
        this.userName = firstName;

    }
    public UserRole(String email, String password, String repeatPassword, String firstName, String role){
        this.email = email;
        this.setPlainPassword(password);
        this.repeatPassword = repeatPassword;
        this.enabled = true;
        this.userName = firstName;
        this.role = role;
    }


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @NotBlank(message = "{register.email.empty}")
    @Email(message = "{register.email.invalid}")
    @Column(name = "email",unique = true)
    private String email;

    @Column(name = "password")
    private String password;

    public String getRepeatPassword() {
        return repeatPassword;
    }

    public void setRepeatPassword(String repeatPassword) {
        this.repeatPassword = repeatPassword;
    }

    @Transient
    private String repeatPassword;

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    @Column(name="enabled")
    private boolean enabled = false;

    public String getPlainPassword() {
        return plainPassword;
    }

    public void setPlainPassword(String plainPassword) {
        this.password= new BCryptPasswordEncoder().encode(plainPassword);
        this.plainPassword = plainPassword;
    }

    @Transient// this field will not saved into db
    @Size(min=5,max = 15,message = "{register.password.size}")
    private String plainPassword;

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Column(name = "role")
    private String role;



    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @NotNull
    @Column(name = "userName",length = 20)
    @Size(min=2,max = 20,message = "{register.userName.size}")
    private String userName;




    @Override
    public String toString() {
        return "SiteUser{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", repeatPassword='" + repeatPassword + '\'' +
                ", enabled=" + enabled +
                ", plainPassword='" + plainPassword + '\'' +
                ", role='" + role + '\'' +
                ", userName='" + userName + '\'' +
                '}';
    }

}
