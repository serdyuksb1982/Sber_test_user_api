package ru.serdyuk.service;

import ru.serdyuk.dto.UsersDto;

public interface UserService {
    UsersDto saveUser(UsersDto usersDto);

    void deleteUser(Integer userId);
}
