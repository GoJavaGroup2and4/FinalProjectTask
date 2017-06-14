package ua.goit.startupserviceapp.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import ua.goit.startupserviceapp.model.UserDB;
import ua.goit.startupserviceapp.service.UserService;

/**
 * Validator for{@link ua.goit.startupserviceapp.model.UserDB} class,
 * implements {@link Validator} inteface.
 *
 * @author Anastasiya Kravchenko
 */

//TODO написать пропертис файл, проверить в поля в базе и что такое username!!!


@Component
public class UserValidator implements Validator {

    @Autowired
    private UserService userService;

    @Override
    public boolean supports(Class<?> aClass) {
        return UserDB.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        UserDB user = (UserDB) o;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "login", "Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName", "Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "Required");

        if (user.getLogin().length() < 6 || user.getLogin().length() > 32) {
            errors.rejectValue("login", "Size.userForm.login");
        }

        if (userService.findByLogin(user.getLogin()) != null) {
            errors.rejectValue("login", "Duplicate.userForm.login");
        }

        if (user.getPassword().length() < 8 || user.getPassword().length() > 32) {
            errors.rejectValue("password", "Size.userForm.password");
        }

        if (!user.getConfirmPassword().equals(user.getPassword())) {
            errors.rejectValue("confirmPassword", "Different.userForm.password");
        }

        if (!user.getPhoneNumber().matches("^[+]?\\d+")) {
            errors.rejectValue("phoneNumber", "Consist.userForm.phoneNumber");
        }

    }
}