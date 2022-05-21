package com.appress.ravi.userRegistrationSystem.exception;

import com.appress.ravi.userRegistrationSystem.dto.UserDTO;

public class CustomErrorType extends UserDTO {

    private String errorMessage;

    public CustomErrorType(String errorMsg){
        this.errorMessage = errorMsg;
    }


    public String getErrorMessage(){
        return errorMessage;
    }

}
