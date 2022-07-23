package com.task.business.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "users")
@Getter
@Setter
@Builder(toBuilder = true, setterPrefix = "with")
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true)
    private String login;
    private String password;

    @Column(unique = true)
    private String email;

    private String firstName;
    private String lastName;
    @ElementCollection
    private Set<Role> roles;

}
