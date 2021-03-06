package ru.ivmiit.validators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import ru.ivmiit.forms.UserForm;
import ru.ivmiit.models.User;
import ru.ivmiit.repositories.UsersRepository;

import java.util.Optional;

@Component
public class UserRegistrationFormValidator implements Validator {
    @Autowired
    private UsersRepository usersRepository;

    @Override
    public boolean supports(Class<?> aClass) {
        return aClass.getName().equals(UserForm.class.getName());
    }
    
    @Override
    public void validate(Object target, Errors errors) {
        UserForm form = (UserForm)target;
        
        Optional<User> existedUser = usersRepository.findOneByLogin(form.getLogin());
        if (existedUser.isPresent()) {
            errors.reject("bad.login", "Логин занят");
        }
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "login", "empty.login", "Пустой логин");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "empty.password", "Пустой пароль");

    }
}
