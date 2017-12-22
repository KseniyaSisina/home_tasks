package ru.ivmiit.services;

import ru.ivmiit.models.User;

import java.util.List;

public interface AdminService {
    List<User> getAllUsers();

    void createTempPassword(Long userId);
}
