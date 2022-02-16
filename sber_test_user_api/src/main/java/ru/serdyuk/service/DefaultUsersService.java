package ru.serdyuk.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.serdyuk.dto.UsersDto;
import ru.serdyuk.entity.Users;
import ru.serdyuk.exception.ValidationException;
import ru.serdyuk.repository.UserRepository;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.Objects.isNull;

@Service
@AllArgsConstructor
public class DefaultUsersService implements UserService{

    private final UserRepository userRepository;

    private final UsersConverter usersConverter;

    @Override
    public UsersDto saveUser(UsersDto usersDto) {
        Users saveUser = userRepository.save(usersConverter.fromDtoToEntity(usersDto));
        return usersConverter.fromEntityToDto(saveUser);
    }

    @Override
    public void deleteUser(Integer userId) {
        userRepository.deleteById(userId);
    }

    @Override
    public UsersDto findByLogin(String login) {
        Users users = userRepository.findByLogin(login);
        if(users != null) {
            return usersConverter.fromEntityToDto(users);
        }
        return null;
    }

    @Override
    public List<UsersDto> findAll() {
        return userRepository.findAll()
                .stream()
                .map(usersConverter::fromEntityToDto)
                .collect(Collectors.toList());
    }

    private void validateUserDto(UsersDto usersDto) throws ValidationException {
        if(isNull(usersDto)) {
            throw new ValidationException("Validation Exception, user is NULL!");
        }
        if(isNull(usersDto.getLogin())|| usersDto.getLogin().isEmpty() ) {
            throw new ValidationException("Your login is empty.");
        }
    }
}
