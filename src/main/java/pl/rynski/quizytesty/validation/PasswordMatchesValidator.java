package pl.rynski.quizytesty.validation;

import pl.rynski.quizytesty.account.AppUser;
import pl.rynski.quizytesty.account.AppUserDto;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordMatchesValidator implements ConstraintValidator<PasswordMatches, Object> {
    @Override
    public void initialize(PasswordMatches constraintAnnotation) {

    }

    @Override
    public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {
        AppUserDto appUser = (AppUserDto) o;
        return appUser.getPassword().equals(appUser.getMatchingPassword());
    }
}
