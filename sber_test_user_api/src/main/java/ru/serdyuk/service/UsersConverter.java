package ru.serdyuk.service;

import org.springframework.stereotype.Component;
import ru.serdyuk.dto.UsersDto;
import ru.serdyuk.entity.Users;

@Component
public class UsersConverter {

    public Users fromDtoToEntity(UsersDto usersDto) {
        Users users = new Users();
        users.setId(usersDto.getId());
        users.setEmail(usersDto.getEmail());
        users.setName(usersDto.getName());
        users.setLogin(usersDto.getLogin());
        users.setBirthday(usersDto.getBirthday());
        return users;
    }

    public UsersDto fromEntityToDto(Users users) {
        return UsersDto.builder()
                .id(users.getId())
                .email(users.getEmail())
                .login(users.getLogin())
                .name(users.getName())
                .birthday(users.getBirthday())
                .build();
    }

}
