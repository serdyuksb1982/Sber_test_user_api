package ru.serdyuk.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.serdyuk.entity.Users;

public interface UserRepository extends JpaRepository<Users, Integer> {

    /*
    тк нет такого method в Repository
     */
    Users findByLogin(String login);

}
