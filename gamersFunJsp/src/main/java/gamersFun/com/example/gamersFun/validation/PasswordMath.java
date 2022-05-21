package gamersFun.com.example.gamersFun.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.TYPE;

@Target({TYPE})// annotation will apply to whole class not to specific field
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = PasswordMatchValidator.class)
@Documented
public @interface PasswordMath {
    String message() default "{error.password.mismatch}";
    Class<?>[] groups() default {};// for supporting validation group
    Class<? extends Payload>[] payload() default {};
}
