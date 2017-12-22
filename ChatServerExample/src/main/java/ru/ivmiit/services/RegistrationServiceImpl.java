package ru.ivmiit.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.ivmiit.forms.UserForm;
import ru.ivmiit.models.User;
import ru.ivmiit.repositories.UsersRepository;
import ru.ivmiit.security.role.Role;
import ru.ivmiit.security.states.State;

import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.UUID;

@Service
public class RegistrationServiceImpl implements RegistrationService {

    private final PasswordEncoder encoder = new BCryptPasswordEncoder();

    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    private UsersRepository usersRepository;

    @Override
    public void registration(UserForm userForm) {
        User user = User.builder()
                .login(userForm.getLogin())
                .name(userForm.getName())
                .email(userForm.getEmail())
                .phone(userForm.getPhone())
                .hashPassword(encoder.encode(userForm.getPassword()))
                .role(Role.USER)
                .state(State.CONFIRMED)
                .uuid(UUID.randomUUID())
                .build();

        usersRepository.save(user);
       /* MimeMessage message = javaMailSender.createMimeMessage();
        try {
            message.setContent("hello", "text/html");
            MimeMessageHelper messageHelper = new MimeMessageHelper(message, true);
            messageHelper.setTo(user.getEmail());
            messageHelper.setSubject("Подтверждение регистрации в чате");
            messageHelper.setText("http://localhost:8080/confirm/" + user.getUuid(), true);
            messageHelper.setFrom(new InternetAddress("09.622.2group.ivmiit@gmail.com"));
        } catch (MessagingException e) {
            throw new IllegalArgumentException(e);
        }

        javaMailSender.send(message);*/
    }
}
