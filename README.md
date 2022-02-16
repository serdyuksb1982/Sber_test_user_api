# sber_test_user_api
Тестовое задание.
Задача:
Сделать простое веб приложение на Java с использованием фреймворка Spring Boot для ведения данных пользователей.  
Данные о пользователях должны храниться в таблице в БД (имя, логин, пароль, email, дата рождения). 
Фронтенд приложения должен состоять из 2 экранов (таблица с перечнем пользователей и детальная форма одного пользователя для ввода, редактирования и просмотра). На бэкенде написать контроллеры для создания/редактирования/чтения/удаления данных в БД. 
Желательно написать один юнит тест.  
Технологии которые нужно использовать - Java, Spring Framework, Hibernate (JPA), Junit. БД – Postgres. 
Код нужно выложить на github в ваш личный профиль.

Приступил к выполнению. Тк задачу планирую выполнять на рабочем месте, применяю следующие инструменты и технологии:
ИДЕ - Intellij Idea Community Edition, https://start.spring.io, maven, субд MySQL (в техническом задании postgres, но в силу внутренней политики инф. безопасности организации располагаю 
лишь MySQL, соответствующие настройки для postgres укажу в конце).
Cоздал следующие пакеты:
entity, где class Users, с полями согласно задания, использую Lombook;
service, с интерфейсом UserService и classes UsersServise и UsersConverter (от Entity до DTO и обратно);
dto, с class UsersDto (Data Transfer Object (DTO), основная цель которого - передача данных между подсистемами прилоложения (API)), как правило, содержит только поля и get/set методы;
exception, c class Validation, с минимальной логикой, которой практически нет. Задача - getMessage();
repository, c interface UserRepository наследующему class JpaRepository;
controller, c единственным class UsersController, @RestController (это рест-контроллер), @RequestMapping("/users"), с минимальным набором Get/Post/Delet методов.
Сделал пару простых тестов UsersService в UsersServiceTest, используя Mockito для имитации создания реальных объектов (UserRepository).
Далее index.html. Так как данные технологии мне знакомы поверхностно, то реализация получилась простая, где я использую AJAX, thymeleaf (представляет Front).
Попытался добавить очень простую, даже примитивную валидацию вводимых пользовательских данных. Используя для этого hibernate-validator.

Менять настройки Pom.xml на СУБД Postgres не стал, для этого можно воспользоваться maven repository 
<!-- https://mvnrepository.com/artifact/org.postgresql/postgresql -->
<dependency>
    <groupId>org.postgresql</groupId>
    <artifactId>postgresql</artifactId>    
</dependency>
и соответствующие настройки в application.properties....

