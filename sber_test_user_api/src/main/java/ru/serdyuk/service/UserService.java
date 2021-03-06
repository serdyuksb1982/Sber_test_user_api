package ru.serdyuk.service;

import ru.serdyuk.dto.UsersDto;
import ru.serdyuk.exception.Validation;

import java.util.List;

public interface UserService {
    UsersDto saveUser(UsersDto usersDto) throws Validation;

    void deleteUser(Integer userId);

    UsersDto findByLogin(String login);

    List<UsersDto> findAll();
}
