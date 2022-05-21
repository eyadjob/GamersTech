package gamersFun.com.example.gamersFun.validation;

import gamersFun.com.example.gamersFun.entity.User;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordMatchValidator implements ConstraintValidator<PasswordMath, User> {

    @Override
    public void initialize(PasswordMath constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(User user, ConstraintValidatorContext context) {
        if(user.getPlainPassword() == null || user.getPlainPassword().length() == 0){
            return true;
        }
        if(user.getPlainPassword() == null || !user.getPlainPassword().equals(user.getRepeatPassword())){
            return false;
        }
        return true;
    }
}
