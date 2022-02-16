package ru.serdyuk.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.serdyuk.dto.UsersDto;
import ru.serdyuk.entity.Users;
import ru.serdyuk.repository.UserRepository;

@Service
@AllArgsConstructor
public class DefaultUsersService implements UserService{

    private final UserRepository userRepository;



    @Override
    public UsersDto saveUser(UsersDto usersDto) {
        Users users = new Users();
        users.setId(usersDto.getId());
        users.setLogin(usersDto.getLogin());
        users.setName(usersDto.getName());
        users.setEmail(usersDto.getEmail());
        users.setBirthday(users.getBirthday());

        return userRepository.save(users);
    }

    @Override
    public void deleteUser(Integer userId) {

    }
}
