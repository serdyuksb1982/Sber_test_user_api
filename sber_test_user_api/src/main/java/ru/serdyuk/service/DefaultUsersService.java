package ru.serdyuk.service;

import org.springframework.stereotype.Service;
import ru.serdyuk.dto.UsersDto;

@Service
public class DefaultUsersService implements UserService{
    @Override
    public UsersDto saveUser(UsersDto usersDto) {
        return null;
    }

    @Override
    public void deleteUser(Integer userId) {

    }
}
