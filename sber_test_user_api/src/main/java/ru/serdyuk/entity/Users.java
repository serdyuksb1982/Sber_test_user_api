package ru.serdyuk.entity;

import javax.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Data
@NoArgsConstructor
@Table(name = "users_table")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    @Size(min = 2)
    @NotNull
    private String name;
    @Column
    @Size(min = 2)
    @NotNull
    private String login;
    @Column
    @Pattern(regexp = "\\S+@[a-z]+.[a-z]+")
    private String email;
    @Column
    @Size(min = 10, max = 10)
    private String birthday;
}
