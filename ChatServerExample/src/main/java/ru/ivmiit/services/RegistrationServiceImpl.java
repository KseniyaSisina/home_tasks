package ru.ivmiit.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.ivmiit.forms.UserForm;
import ru.ivmiit.models.User;
import ru.ivmiit.repositories.UsersRepository;

@Service
public class RegistrationServiceImpl implements RegistrationService {

    private final PasswordEncoder encoder = new BCryptPasswordEncoder();

    @Autowired
    private UsersRepository usersRepository;

    @Override
    public void registration(UserForm userForm) {
        User user = User.builder()
                .login(userForm.getLogin())
                .name(userForm.getName())
                .email(userForm.getEmail())
                .hashPassword(encoder.encode(userForm.getPassword()))
                .build();

        usersRepository.save(user);
    }
}
