package com.appress.ravi.userRegistrationSystem.bikeSystem.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class Bike {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String email;
    private String phone;
    private String model;
    private String serialNumber;
    private BigDecimal purshacePrice;

    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "MM-dd-yyyy")
    private Date purshaceDate;
    private boolean conact;




    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }






    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public BigDecimal getPurshacePrice() {
        return purshacePrice;
    }

    public void setPurshacePrice(BigDecimal purshacePrice) {
        this.purshacePrice = purshacePrice;
    }

    public Date getPurshaceDate() {
        return purshaceDate;
    }

    public void setPurshaceDate(Date purshaceDate) {
        this.purshaceDate = purshaceDate;
    }

    public boolean isConact() {
        return conact;
    }

    public void setConact(boolean conact) {
        this.conact = conact;
    }


}
