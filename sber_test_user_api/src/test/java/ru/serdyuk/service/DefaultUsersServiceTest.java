package ru.serdyuk.service;

import lombok.SneakyThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import ru.serdyuk.dto.UsersDto;
import ru.serdyuk.entity.Users;
import ru.serdyuk.exception.ValidationException;
import ru.serdyuk.repository.UserRepository;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class DefaultUsersServiceTest {

    private UserService usersService;
    Users users;

    @BeforeEach
    void setUp() {
        UserRepository usersRepository = mock(UserRepository.class);
        UsersConverter usersConverter = new UsersConverter();
        users = new Users();
        users.setId(1);
        users.setLogin("Sergey1900");
        users.setName("Sergey");
        users.setEmail("sergey@mail.ru");
        users.setBirthday("01.01.2021");

        when(usersRepository.save(any())).thenReturn(users);
        usersService = new DefaultUsersService(usersRepository, usersConverter);
    }

    @SneakyThrows
    @Test
    void testSaveEntityReturnDtoFromBirthday() {
        String birthday = "01.01.2021";
        UsersDto usersDto = UsersDto.builder()
                .birthday(birthday)
                .build();
        UsersDto saveUsersDto = usersService.saveUser(usersDto);
        assertThat(saveUsersDto)
                .isNotNull();
        assertThat(saveUsersDto.getBirthday())
                .isEqualTo(birthday);
    }

    @SneakyThrows
    @Test
    void testSaveEntityReturnDtoFromLogin() {
        String login = "Sergey1900";
        UsersDto usersDto = UsersDto.builder()
                .login(login)
                .build();
        UsersDto saveUsersDto = usersService.saveUser(usersDto);
        assertThat(saveUsersDto)
                .isNotNull();
        assertThat(saveUsersDto.getLogin())
                .isEqualTo(login);
    }


}