package ru.ivmiit.services;

import org.springframework.security.core.Authentication;
import ru.ivmiit.models.User;


public interface AuthenticationService {
    User getUserByAuthentication(Authentication authentication);
}
