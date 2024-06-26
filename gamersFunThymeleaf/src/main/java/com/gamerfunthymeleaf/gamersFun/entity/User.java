package com.gamerfunthymeleaf.gamersFun.entity;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @NotBlank(message = "{register.email.empty}")
    @Email(message = "{register.email.invalid}")
    @Column(name = "email", unique = true)
    private String email;
    @Column(name = "password")
    private String password;
    @Transient
    private String repeatPassword;
    @Column(name = "enabled")
    private boolean enabled = false;
    @Transient// this field will not saved into db
    @Size(min = 5, max = 15, message = "{register.password.size}")
    private String plainPassword;
    @Column(name = "role")
    private String role;
    @NotNull
    @Column(name = "userName", length = 20)
    @Size(min = 2, max = 20, message = "{register.userName.size}")
    private String userName;

    public User() {

    }

    // for testing purpose
    public User(String email, String password, String repeatPassword, String firstName) {
        this.email = email;
        this.setPlainPassword(password);
        this.repeatPassword = repeatPassword;
        this.enabled = true;
        this.userName = firstName;

    }

    public User(String email, String password, String repeatPassword, String firstName, String role) {
        this.email = email;
        this.setPlainPassword(password);
        this.repeatPassword = repeatPassword;
        this.enabled = true;
        this.userName = firstName;
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRepeatPassword() {
        return repeatPassword;
    }

    public void setRepeatPassword(String repeatPassword) {
        this.repeatPassword = repeatPassword;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getPlainPassword() {
        return plainPassword;
    }

    public void setPlainPassword(String plainPassword) {
        this.password = new BCryptPasswordEncoder().encode(plainPassword);
        this.plainPassword = plainPassword;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "SiteUser{" + "id=" + id + ", email='" + email + '\'' + ", password='" + password + '\'' + ", repeatPassword='" + repeatPassword + '\'' + ", enabled=" + enabled + ", plainPassword='" + plainPassword + '\'' + ", role='" + role + '\'' + ", userName='" + userName + '\'' + '}';
    }

}
